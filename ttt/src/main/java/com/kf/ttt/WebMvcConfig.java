package com.kf.ttt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	// 리액트 연동 cors 문제
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://172.30.1.19:3000")
//			.allowedOrigins("http://localhost:3000")
				.allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE");

	}


	// url prefix 설정
//	@Override
//	public void configurePathMatch(PathMatchConfigurer configurer) {
//		configurer.addPathPrefix("/api", HandlerTypePredicate.forBasePackage("com.kf.ttt"));
//	}
}
