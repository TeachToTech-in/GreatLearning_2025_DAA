package com.rahul;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan
public class FirstSpringWebApplication {
	

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(FirstSpringWebApplication.class);
		DrawingApp d = context.getBean(DrawingApp.class);
		System.out.println(d.hashCode());
		d = context.getBean(DrawingApp.class);
		System.out.println(d.hashCode());
		d = context.getBean(DrawingApp.class);
		System.out.println(d.hashCode());
		d = context.getBean(DrawingApp.class);
		System.out.println(d.hashCode());
		d = context.getBean(DrawingApp.class);
		System.out.println(d.hashCode());
	}

}
