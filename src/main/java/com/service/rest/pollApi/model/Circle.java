package com.service.rest.pollApi.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Circle implements Shape{

	@Override
	public String getShapeName() {
		
		return "Circle";
	}

	
}
