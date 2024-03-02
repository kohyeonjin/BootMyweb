package com.coding404.myweb.product.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.command.TopicVO;

@Mapper
public interface ProductMapper {

	public int regist(ProductVO vo);
	public ArrayList<ProductVO> getList();
	public ProductVO getDetail(int prod_id);
	public int update(ProductVO vo);
	public void delete(int prod_id);
}
