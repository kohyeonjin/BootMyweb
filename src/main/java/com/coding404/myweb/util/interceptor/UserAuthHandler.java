package com.coding404.myweb.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//@Component //컨트롤러,서비스.DAO가 아닌 특정클래스를 빈으로 생성
public class UserAuthHandler implements HandlerInterceptor {
	//로그인 여부를 확인하는 인터셉터
	//pre - 컨트롤러 들어가기 전에 실행됨
	//post - 컨트로롤러에서 dispatcherServlet으로 리턴하기 전에 실행됨
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("컨트롤러 요청 전에 실행됨");
		
		//로그인이 된 사람의 확인
		HttpSession session = request.getSession(); //현재세션
		String user_id = (String)session.getAttribute("user_id");
		//null일 경우 error
		if(user_id != null) { //로그인이 된 사람
			return true; //컨트롤러를 실행 시킴
		}else { //로그인이 안된 사람
			response.sendRedirect( request.getContextPath()+"/user/login" );
			return false;
		}
		
		
		//return true; //true - 컨트롤러가 실행됨
		//return false; //false - 컨트롤러가 실행되지 않음
	
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("컨트롤러 요청 후에 실행됨");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	//로그인여부를 확인하는 인터셉터
}
