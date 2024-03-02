package com.coding404.myweb.topic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding404.myweb.command.TopicVO;

@Service("topicService")
public class TopicServiceImple implements TopicService {

	@Autowired
	TopicMapper topicMapper;
	
	@Override
	public int regist(TopicVO vo) {
		
		return topicMapper.regist(vo);
		
	}

	@Override
	public List<TopicVO> getList() {
		List<TopicVO> list = topicMapper.getList();
		return list;
	}

	@Override
	public TopicVO getDetail(int topic_tno) {
		
		return topicMapper.getDetail(topic_tno);
	}

	@Override
	public int updateForm(TopicVO vo) {
		
		return topicMapper.updateForm(vo);	
	}

	@Override
	public int deleteForm(int topic_tno) {
			
		return topicMapper.deleteForm(topic_tno);
	}
	



}
