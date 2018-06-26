package com.briup.apps.poll.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 跨域     任何人可访问接口
 * @author WE
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET","POST","PUT","OPTIONS","DELETE","PATCH").allowCredentials(true).maxAge(3600);
	}
	
}
