package com.coding404.myweb.product.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding404.myweb.command.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public int regist(ProductVO vo) {
		
		return productMapper.regist(vo);
	}

	@Override
	public ArrayList<ProductVO> getList() {
		ArrayList<ProductVO> list = productMapper.getList();
		return list;
	}

	@Override
	public ProductVO getDetail(int prod_id) {
		ProductVO vo = productMapper.getDetail(prod_id);
		return vo;
	}

	@Override
	public int update(ProductVO vo) {
		
		int result = productMapper.update(vo);
		return result;
	}

	@Override
	public void delete(int prod_id) {
		
		productMapper.delete(prod_id);
		
	}

	

}
