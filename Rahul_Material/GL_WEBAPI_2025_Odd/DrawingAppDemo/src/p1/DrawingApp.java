package p1;

public class DrawingApp {
private Circle c;


public DrawingApp(Circle c) {
	super();
	this.c = c;
}

public void draw() {
	System.out.println("Shape is "+c);
}
}
