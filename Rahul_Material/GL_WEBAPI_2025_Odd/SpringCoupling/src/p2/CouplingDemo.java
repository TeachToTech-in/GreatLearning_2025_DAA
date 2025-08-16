package p2;

public class CouplingDemo {
	public static void main(String[] args) {
		Circle c1 = new Circle(12);
		// Circle Object Must be provided to the Drawing App
		// To Print
		Rectangle r = new Rectangle(12,13);
		//The constructor DrawingApp(Rectangle) is undefined
		DrawingApp d1 = new DrawingApp(c1);
		d1.printShape();
	}
}
