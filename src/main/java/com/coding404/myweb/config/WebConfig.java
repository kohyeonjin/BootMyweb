package com.coding404.myweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.coding404.myweb.util.interceptor.UserAuthHandler;

@Configuration //스프링 설정파일
public class WebConfig implements WebMvcConfigurer {
	
	//1st
	/*
	 * @Autowired UserAuthHandler userAuthHandler;
	 */
	
	//인터셉터를 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	
		registry.addInterceptor( userAuthHandler() )
				.addPathPatterns("/product/**") //product로 시작하는 경로에 등록
				.addPathPatterns("/user/**") //user경로에 대해서 전부다.
				.excludePathPatterns("/user/login") //login은 패스에서제외
				.excludePathPatterns("/user/loginForm") //login요청
				.excludePathPatterns("/user/join"); //join 패스에서제외
				
	}


	
	//2nd
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler();
	}
}
