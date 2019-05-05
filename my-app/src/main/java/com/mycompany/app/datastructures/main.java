package com.mycompany.app.datastructures;

public class main {
	public static void main(String[] args) {
		Rectangle rectangle0 = new Rectangle();
		Point p0 = new Point();
		Point p1 = new Point(3, 5);
		Point p2 = new Point(10, 7);
		Rectangle rectangle1 = new Rectangle(p1, p2);
		Rectangle rectangle2 = new Rectangle(1,1,7,7);

		System.out.println("Hola soy Tarea 1");
		long time1 = System.currentTimeMillis();
		System.out.println("it is time "+ time1);
	}

}
