package com.coding404.myweb.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.product.service.ProductService;

@RestController
public class AjaxController {
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Value("${project.upload.path}")
	private String uploadPath;
	
	//등록화면에 대분류를 가져나가는 get데이터 조회문장
	@GetMapping("/getCategory")
	public ResponseEntity<ArrayList<CategoryVO>> getCategory(){
	
//		productService.getCategory();
		
		return new ResponseEntity<>(productService.getCategory() , HttpStatus.OK);	
	}
	
	// 중분류 or 소분류를 가져나가는 get데이터 조회
	@GetMapping("/getCategoryChild/{group_id}/{category_lv}/{category_detail_lv}")
	public ResponseEntity<ArrayList<CategoryVO>> 
	getCategoryChild(@PathVariable("group_id") String group_id,
					 @PathVariable("category_lv") Integer category_lv,
					 @PathVariable("category_detail_lv") Integer category_detail_lv){
		
		CategoryVO vo = CategoryVO.builder().group_id(group_id).category_lv(category_lv).category_detail_lv(category_detail_lv).build();
		
		return new ResponseEntity<>(productService.getCategoryChild(vo), HttpStatus.OK);
	}
	
	////////////////////////////////
	//로컬에 저장되어 있는 이미지 byte정보를 구해서 보여줌
	
	@GetMapping("/display/{filepath}/{uuid}/{filename}")
	public ResponseEntity<byte[]> display(@PathVariable("filepath") String filepath
										 ,@PathVariable("uuid") String uuid
										 ,@PathVariable("filename") String filename){
		
		//로컬에 있는 파일데이터 byte 정보
		
		ResponseEntity<byte[]> entity = null;
		
		try {
			String savePath = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;
			File file = new File(savePath);
			//데이터
			byte[] arr = FileCopyUtils.copyToByteArray(file);
			//헤더
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type" , Files.probeContentType(file.toPath()));
			entity = new ResponseEntity<>(arr , header , HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return entity;
	
	
}
	
	@GetMapping("/download/{filepath}/{uuid}/{filename}")
	public ResponseEntity<byte[]> download(@PathVariable("filepath") String filepath
										 ,@PathVariable("uuid") String uuid
										 ,@PathVariable("filename") String filename){
		
		//로컬에 있는 파일데이터 byte 정보
		
		ResponseEntity<byte[]> entity = null;
		
		try {
			String savePath = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;
			File file = new File(savePath);
			//데이터
			byte[] arr = FileCopyUtils.copyToByteArray(file);
			//헤더
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Disposition" ,"attachment; filename=" + filename);
			entity = new ResponseEntity<>(arr , header , HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entity;
	
	
}
}