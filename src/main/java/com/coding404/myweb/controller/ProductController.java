package com.coding404.myweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
		@Autowired
		@Qualifier("productService")
		ProductService productService;
	
		@GetMapping("/productList")
		public String list(Model model) {
			
		
			ArrayList<ProductVO> list = productService.getList();
			model.addAttribute("list", list);
			
			return "product/productList";
		}
		
		@GetMapping("/productReg")
		public String reg() {
			
			return "product/productReg";
		}
		
		@GetMapping("/productDetail")
		public String detail(@RequestParam("prod_id") int prod_id , Model model) {
			
			ProductVO vo = productService.getDetail(prod_id);
			model.addAttribute("vo",vo);
			
			return "product/productDetail";
		}
		
		@PostMapping("/productForm")
		public String productForm(ProductVO vo, RedirectAttributes ra) {
			
			int result = productService.regist(vo);
			
			if(result == 1) { 
				ra.addFlashAttribute("msg", "정상적으로 처리되었습니다");
				
			} else {
				ra.addFlashAttribute("msg", "등록에 실패했습니다");
			}
			
			return "redirect:/product/productList";
		}
		
		//업데이트 요청
		@PostMapping("/updateForm")
		public String updateForm(ProductVO vo, RedirectAttributes ra) {
			//1. 화면에서 넘어오는 값을 받습니다
			//2. 서비스에서 update메서드를 생성
			//3. enddate, prod_name, price, count, discount, 설명, 내용
			//4. 업데이트 성공,실패 여부를 저장해서 목록화면으로 이동
			
	
			int result = productService.update(vo);

			if(result == 1) {
				ra.addFlashAttribute("result","성공!");
			}else {
				ra.addFlashAttribute("result","실패!");
			}
			return "redirect:/product/productList";
		}
		
		@RequestMapping("/deleteForm")
		public String deleteForm(@RequestParam("prod_id") int id) {
			
			productService.delete(id);
			
			return "redirect:/product/productList";
		}
}
