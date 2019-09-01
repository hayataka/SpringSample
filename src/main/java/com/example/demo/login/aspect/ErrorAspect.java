package com.example.demo.login.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ErrorAspect {

	@AfterThrowing(value="execution( * *..*..*(..))" + " && (bean( * Controller) || bean( * Service) || bean( * Repository))", throwing = "ex")
	public void throwingNull(DataAccessException ex) {
		log.warn("-----------------------------------------------");
		log.error("DataAccessException 発生しました", ex);
		log.warn("-----------------------------------------------");
	}
}
