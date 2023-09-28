package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String getHello(@RequestParam("name") String name ) {
		
		
		
		return "Hello " + name;
	}
	
	@RequestMapping("/list")
	@CrossOrigin(origins = "http://localhost:8080")
	public List<String> getList(){
		List<String> list=Arrays.asList("Mohan","Rohan");
		
		return list;
	}

}
