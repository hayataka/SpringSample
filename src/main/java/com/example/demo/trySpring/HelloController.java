package com.example.demo.trySpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping
	public String getHello() {
		return "hello";
	}
	
	
	
}
