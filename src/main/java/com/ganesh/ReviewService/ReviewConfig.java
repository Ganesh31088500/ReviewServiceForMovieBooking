package com.ganesh.ReviewService;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewConfig {

	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}
