package com.rahul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DrawingApp {
//Field Injection
	// @Autowired
	private Shape c;

	public DrawingApp(Shape c) {
		super();
		this.c = c;
		System.out.println("DrawingApp is Created");
	}

	public void draw() {
		System.out.println("Shape is " + c);
	}

	
	public void setC(Shape c) {
		System.out.println("The Injection Done through Setter");
		this.c = c;
	}
}
