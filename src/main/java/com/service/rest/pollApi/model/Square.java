package com.service.rest.pollApi.model;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape {

	@Override
	public String getShapeName() {
		return "square";
	}

}
