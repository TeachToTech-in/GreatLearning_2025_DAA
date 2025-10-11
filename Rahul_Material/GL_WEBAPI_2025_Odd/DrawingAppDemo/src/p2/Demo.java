package p2;

public class Demo {
	public static void main(String[] args) {

		// The constructor DrawingApp(Circle) is undefined
		//The constructor DrawingApp(Rectangle) is undefined
		DrawingApp d = new DrawingApp(new Rectangle(20,30));
		d.draw();
	}
}
