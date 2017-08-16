package com.att.omni.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@ComponentScan("com.att.omni")
public class SpringBootJaxrsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJaxrsDemoApplication.class, args);
	}
	
	 @RequestMapping("/hello")
	    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
	        model.addAttribute("name", name);
	        return "hello";
	    }
}