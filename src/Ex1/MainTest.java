package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.Stack;

public class MainTest {
	
	
	public static void testStdDraw1() {
		StdDraw.setPenRadius(0.05);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.point(0.5, 0.5);
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.line(0.2, 0.2, 0.8, 0.2);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.circle(100, 100, 0.5);
	}
	public static void testStdDraw2() {
		StdDraw.square(0.2, 0.8, 0.1);
		StdDraw.filledSquare(0.8, 0.8, 0.2);
		StdDraw.circle(0.8, 0.2, 0.2);

		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.setPenRadius(0.02);
		StdDraw.arc(0.8, 0.2, 0.1, 200, 45);

		// draw a blue diamond
		StdDraw.setPenRadius();
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		double[] x = { 0.1, 0.2, 0.3, 0.2 };
		double[] y = { 0.2, 0.3, 0.2, 0.1 };
		StdDraw.filledPolygon(x, y);

		// text
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.2, 0.5, "black text");
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(0.8, 0.8, "white text");
	}
	
	

	//	String OP;
	//
	//	public static function testinit(String a) {
	//
	//
	//		
	//		
	//		
	//		

	//		while(a.charAt(i) != '(') {
	//			temp += a.charAt(i);
	//			i++;
	//		}
	//		if(chack_OP(temp)) {
	//			String OP = temp;
	//		}
	//
	//		i++;
	//		int count = 0;
	//		int start_index = i;
	//		int end_index;
	//		boolean flag = true;
	//		String left_side ="";
	//
	//		while(a.charAt(i)!='(') {
	//			left_side+= a.charAt(i++);
	//		}
	//		
	//		while(flag) {
	//			
	//			left_side+= a.charAt(i);
	//			if(a.charAt(i)=='(') {
	//				count++;
	//
	//			}else if(a.charAt(i)==')') {
	//				count --;
	//			}
	//			i++;
	//			if (count == 0) flag = false ;
	//		}
	//		return a;

	//
	//	}



	public static void main(String[] args) throws IOException {

		System.out.println("---------------------------");
		Polynom a = new Polynom("0");
		ComplexFunction cf = new ComplexFunction(a);
		function cf1 = cf.initFromString("div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)");
		ComplexFunction cf2 = new ComplexFunction(cf1);
		System.out.println(cf2);
		System.out.println("---------------------------");
		
		
//		//StdDraw.setCanvasSize(1080 , 2070);
//		StdDraw.setPenRadius(0.1);
//		StdDraw.setPenColor(StdDraw.BLACK); // 
//		StdDraw.point(0.7, 0.5); // PLACE IN GRAPH
//		StdDraw.setPenRadius(0.005);
//		StdDraw.setPenColor(StdDraw.MAGENTA);
//		StdDraw.line(0.2, 0.2, 0.8, 0.2);
		
		
//		Polynom p1 = new Polynom("x");
//		StdDraw.setCanvasSize(1024,1024);
//		
//		StdDraw.setPenRadius(0.009);
//		StdDraw.setPenColor(StdDraw.BLACK);
//		
	//	StdDraw.setScale(-100,100);
		
//		Range rx = new Range(-100, 100);
//		Range ry = new Range(-100,100);
//		StdDraw.setXscale(rx.get_min(),rx.get_max());
//		StdDraw.setYscale(ry.get_min(),ry.get_max());
//		
//		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
//		StdDraw.line(0, ry.get_min(), 0, ry.get_max());
//		
//		
//		StdDraw.setPenColor(StdDraw.RED);
//		StdDraw.setPenRadius(0.005);
//		for (double i = -100; i < 100; i=i+0.2) {
//			StdDraw.point(i,p1.f(i));
//		}
		
//		int width = 1024;
//		int height = 1024;
//		Range rx = new Range(-100, 100);
//		Range ry = new Range(-100,100);
//		int resolution = 200;
//		StdDraw.setCanvasSize(width,height);
//		StdDraw.setPenRadius(0.009);
//		StdDraw.setPenColor(StdDraw.BLACK);
//		
//		StdDraw.setXscale(rx.get_min(),rx.get_max());
//		StdDraw.setYscale(ry.get_min(),ry.get_max());
//		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
//		StdDraw.line(0, ry.get_min(), 0, ry.get_max());
//		
//		double rxr = rx.get_max()-rx.get_min();
//		Polynom p12 = new Polynom("5");
//		StdDraw.setPenColor(StdDraw.RED);
//		StdDraw.setPenRadius(0.005);
//		for (double i = rx.get_min(); i < rx.get_max(); i+=rx.get_max()/resolution) {
//			StdDraw.point(i,p1.f(i));
//		}
		function m0 = new Polynom("0");
		function m1 = new Polynom("x^3-13x^2-2");
		function m2 = new Polynom("x^4-2");
		function m3 = new Polynom("x-2");
		function m4 = new Polynom("12x-2");
		function m5 = new Polynom("x-2x^7");
		
		
		function cf12 = new ComplexFunction("div" ,m1,m3);
		System.out.println(cf12.toString());
		
		Functions_GUI fg = new Functions_GUI();
		Functions_GUI fg1 = new Functions_GUI();
		fg.add(m0);
		fg.add(cf12);
		fg.add(m1);
		fg.add(m2);
		fg.add(m3);
		fg.add(m4);
		fg.add(m5);
		
		//fg.drawFunctions();
		
		ComplexFunction cf13 = fg.get(1);
		System.out.println(cf13.toString());
		
		ComplexFunction cf14 = new ComplexFunction("mul(x,x^2)");
		System.out.println(cf14);
		
		fg.saveToFile("test3.json");
		fg1.initFromFile("test3.json");
		fg1.drawFunctions();
		
	}
}
