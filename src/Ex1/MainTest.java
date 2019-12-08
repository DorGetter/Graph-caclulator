package Ex1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.Stack;

public class MainTest {




	public static void main(String[] args) throws IOException {

		ComplexFunction c6=new ComplexFunction(new Polynom("x"));
		ComplexFunction cc = new ComplexFunction(Operation.None,c6,null);
		function ccc = cc.initFromString("none(5x,null)");
		System.out.println(ccc);
		ComplexFunction c=(ComplexFunction)c6.initFromString("mul(plus(comp(x+2,x^2),none(5x,null)),min(max(x^2,x),div(3x,3)))");
		ComplexFunction css=(ComplexFunction)c6.initFromString("mul(plus(div(x,x),plus(2x,2x)),4x)");
		
//		function m0 = new Polynom("0");
//		function m1 = new Polynom("x^3-13x^2-2");
//		function m2 = new Polynom("x^4-2");
//		function m3 = new Polynom("x-2");
//		function m4 = new Polynom("12x-2");
//		function m5 = new Polynom("x-2x^7");
//
//
//		function cf12 = new ComplexFunction("div" ,m1,m3);
//		System.out.println(cf12.toString());
//
//		Functions_GUI fg = new Functions_GUI();
//		Functions_GUI fg1 = new Functions_GUI();
//		fg.add(m0);
//		fg.add(cf12);
//		fg.add(m1);
//		fg.add(m2);
//		fg.add(m3);
//		fg.add(m4);
//		fg.add(m5);
//
//		//fg.drawFunctions();
//		//fg.drawFunctions(1024, 1024, new Range(-25, 25), new Range(-25, 25), 200);
//		ComplexFunction cf13 = fg.get(1);
//		System.out.println(cf13.toString());
//
//		ComplexFunction cf14 = new ComplexFunction("mul(x,x^2)");
//		System.out.println(cf14);
//
//		//fg.saveToFile("test15");
//		fg1.initFromFile("test15");
//		//fg1.drawFunctions();
//		fg1.drawFunctions("GUI_params .json");


	}
}
