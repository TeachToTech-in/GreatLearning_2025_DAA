package com.rahul;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Circle implements Shape{
private int radius;

public Circle() {
	
	super();
	System.out.println("Circle is Created");
	// TODO Auto-generated constructor stub
}

public Circle(int radius) {
	super();
	this.radius = radius;
}

public int getRadius() {
	return radius;
}

public void setRadius(int radius) {
	this.radius = radius;
}

@Override
public String toString() {
	return "Circle [radius=" + radius + "]";
}

}
