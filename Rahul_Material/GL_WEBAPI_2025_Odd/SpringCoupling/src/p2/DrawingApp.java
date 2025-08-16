package p2;

import p2.Shape;

//Loose Coupled by Circle Object
public class DrawingApp{
	private Shape shape;
	//private Rectangle r1;

	DrawingApp(Shape shape) {
		this.shape=shape;
	}

	// to print The Dependent Object
	public void printShape() {
		System.out.println(shape);
	}
}
