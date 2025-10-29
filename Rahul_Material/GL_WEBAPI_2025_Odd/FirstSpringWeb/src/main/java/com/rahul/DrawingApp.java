package com.rahul;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DrawingApp {
private Shape c;


public DrawingApp(Shape c) {
	super();
	this.c = c;
}

public void draw() {
	System.out.println("Shape is "+c);
}
}
