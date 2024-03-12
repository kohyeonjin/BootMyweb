package com.coding404.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@GetMapping("/userDetail")
	public String userDetail() {
		return "user/userDetail";
	}
	
	@PostMapping("/loginForm")
	public String loginForm(@RequestParam("id") String id
						   ,@RequestParam("pw") String pw
						   ,HttpSession session) {
		
		session.setAttribute("user_id", "aaa123"); //세션에 유저아이디 저장
		return "redirect:/"; //홈화면
	}
	
}
