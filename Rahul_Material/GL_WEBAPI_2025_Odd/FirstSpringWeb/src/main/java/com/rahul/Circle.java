package com.rahul;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Circle implements Shape{
private int radius;

public Circle() {
	super();
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
