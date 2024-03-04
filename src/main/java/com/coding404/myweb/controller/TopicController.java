package com.coding404.myweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.topic.service.TopicService;

@Controller
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@GetMapping("topicReg")
	public String Reg() {
		
		return "topic/topicReg";
	}
	
	@PostMapping("topicForm")
	public String topicForm(TopicVO vo) {
		
		int result = topicService.regist(vo);
		
		return "redirect:/topic/topicList";
	}
	
	
	@GetMapping("topicList")
	public String topicList(Model model) {
		
		List<TopicVO> list = topicService.getList();
		model.addAttribute("list", list);
		return "topic/topicListme";
	}
	
	@GetMapping("topicDetail")
	public String topicDetail(@RequestParam("topic_tno") int topic_tno , Model model) {
		
		model.addAttribute("vo",topicService.getDetail(topic_tno));
		
		return "topic/topicDetail";
	}
	
	@GetMapping("topicUpdate")
	public String topicUpdate(@RequestParam("topic_tno") int topic_tno , Model model) {
		
		TopicVO vo = topicService.getDetail(topic_tno);
		model.addAttribute("vo", vo);
		
		return "topic/topicModify";
	}
	
	@PostMapping("/updateForm")
	public String updateForm(TopicVO vo) {
		
		System.out.println(vo.toString());
		int result = topicService.updateForm(vo);
		
		
		return "redirect:/topic/topicList";
	}
	
	@RequestMapping("/deleteForm")
	public String deleteForm(TopicVO vo) {
		
		
		int topic_tno = vo.getTopic_tno();
		topicService.deleteForm(topic_tno);
		
		return "redirect:/topic/topicList";
	}
}
