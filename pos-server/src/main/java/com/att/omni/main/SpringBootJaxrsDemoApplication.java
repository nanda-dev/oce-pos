package com.att.omni.main;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

@SpringBootApplication
@ComponentScan("com.att.omni")
@EnableAutoConfiguration
public class SpringBootJaxrsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJaxrsDemoApplication.class, args);
	}

	 @Bean(name = "multipartResolver")
	public CommonsMultipartResolver commonsMultipartResolver() {
		final CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(3 * 1024 * 1024);
		return commonsMultipartResolver;
	}

	@Bean
	public FilterRegistrationBean multipartFilterRegistrationBean() {
		final MultipartFilter multipartFilter = new MultipartFilter();
		final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(multipartFilter);
		filterRegistrationBean.addInitParameter("multipartResolverBeanName", "multipartResolver");
		return filterRegistrationBean;
	}
	
	 @Bean
	 public MultipartConfigElement multipartConfigElement() {
	     return new MultipartConfigElement("");
	 }

	 @Bean
	 public MultipartResolver multipartResolver() {
	     org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
	     multipartResolver.setMaxUploadSize(1000000);
	     return multipartResolver;
	 }
	 
	
}