package com.coding404.myweb.topic.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.coding404.myweb.command.TopicVO;

@Mapper
public interface TopicMapper {
	
	public int regist(TopicVO vo);
	public List<TopicVO> getList();
	public TopicVO getDetail(int topic_tno);
	public int updateForm(TopicVO vo);
	public int deleteForm(int topic_tno);
}
