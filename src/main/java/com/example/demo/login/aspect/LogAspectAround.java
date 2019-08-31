package com.example.demo.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogAspectAround {

	@Around("execution( * *..*.*Controller.*(..))")
	public Object startLog(ProceedingJoinPoint jp) throws Throwable {

		log.debug("メソッド開始：{}", jp.getSignature());
		try {
			Object result = jp.proceed();
			log.debug("メソッド終了：{}", jp.getSignature());
			return result;
		} catch(Exception e) {
			log.error("メソッド異常終了:{}", jp.getSignature());
			log.error("エラーが発生しました", e);
			throw e;
		}
	}
}
