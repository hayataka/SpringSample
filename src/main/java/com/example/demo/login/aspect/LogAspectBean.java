package com.example.demo.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogAspectBean {

	@Before("bean(*Controller)")
	public void startByBean(JoinPoint jp) {
		log.trace("bean名指定：メソッド開始：{}", jp.getSignature());
	}
	@Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void startByAnnotation(JoinPoint jp) {
		log.trace("annotation指定：メソッド開始：{}", jp.getSignature());
	}
	@Before("@within(org.springframework.stereotype.Controller)")
	public void startByClassAnnotation(JoinPoint jp) {
		log.trace("class annotation指定：メソッド開始：{}", jp.getSignature());
	}
	
	
}
