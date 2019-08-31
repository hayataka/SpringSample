package com.example.demo.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogAspect {

	@Before("execution( * *..*.*Controller.*(..))")
	public void startLog(JoinPoint jp) {
		log.debug("メソッド開始：{}", jp.getSignature());
	}
	@After("execution( * *..*.*Controller.*(..))")
	public void endLog(JoinPoint jp) {
		log.debug("メソッド終了：{}", jp.getSignature());
	}
}
