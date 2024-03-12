package com.coding404.myweb.product.service;

import java.util.ArrayList;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.command.ProductUploadVO;
import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;

@Mapper
public interface ProductMapper {

	public int regist(ProductVO vo);
	public ArrayList<ProductVO> getList(@Param("cri") Criteria cri, @Param("user_id") String user_id);
	public int getTotal(@Param("cri") Criteria cri, @Param("user_id") String user_id);
	public ProductVO getDetail(int prod_id);
	public int update(ProductVO vo);
	public void delete(int prod_id);
	public ArrayList<CategoryVO> getCategory();
	public ArrayList<CategoryVO> getCategoryChild(CategoryVO vo);
	//파일업로드 insert
	public void registFile(ProductUploadVO vo);
	public ArrayList<ProductUploadVO> getImgs(int prod_id);
}
