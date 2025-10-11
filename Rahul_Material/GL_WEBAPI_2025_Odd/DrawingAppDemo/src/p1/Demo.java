package p1;

public class Demo {
	public static void main(String[] args) {
		//The constructor DrawingApp() is undefined
		//The constructor DrawingApp(Rectangle) is undefined
		DrawingApp d = new DrawingApp(new Rectangle());
		d.draw();
		
		//Type mismatch: cannot convert from Rectangle to Circle
		
		//Circle c = new Rectangle();
	}
}
