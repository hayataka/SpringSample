package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class RestMatcher implements RequestMatcher {

	private AntPathRequestMatcher matcher;
	
	public RestMatcher(String url) {
		super();
		matcher = new AntPathRequestMatcher(url);
	}

	// URLマッチ条件
	@Override
	public boolean matches(HttpServletRequest request) {

		if("GET".contentEquals(request.getMethod())) {
			return false;			
		}
		if (matcher.matches(request)) {
			return false;
		} else {
			return true;
		}

	}

}
