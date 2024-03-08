package com.coding404.myweb.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.command.ProductUploadVO;
import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;


public interface ProductService {
	
	public int regist(ProductVO vo, List<MultipartFile> list);
	public ArrayList<ProductVO> getList(Criteria cri);
	public int getTotal(Criteria cri);
	public ProductVO getDetail(int prod_id);
	public int update(ProductVO vo);
	public void delete(int prod_id);
	public ArrayList<CategoryVO> getCategory();
	public ArrayList<CategoryVO> getCategoryChild(CategoryVO vo);
	
	//이미지조회
	public ArrayList<ProductUploadVO> getImgs(int prod_id);
}
