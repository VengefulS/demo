package com.hero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Cors {
	@Bean
	public WebMvcConfigurer corsConf() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*")
						.allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH").allowCredentials(true)
						.allowedHeaders("*");
			}
		};
	}
	/*
	 * @Configuration public class WebConfig implements WebMvcConfigurer {
	 * 
	 * public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**") .allowedOrigins("http://219.216.81.193:8080",
	 * "null") .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
	 * .maxAge(3600) .allowCredentials(true); } }
	 */

}