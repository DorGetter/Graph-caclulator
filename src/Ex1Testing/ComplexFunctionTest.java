package Ex1Testing;

import Ex1.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

class ComplexFunctionTest {



//	@Test
//	void testComplexFunctionFunction() {
//
//		try {
//			String[] s3 = {"x+3","x-2", "x-4"};
//			Polynom p1 = new Polynom(s3[0]);
//			Polynom p2 = new Polynom(s3[1]);
//			Polynom p3 = new Polynom(s3[2]);
//			ComplexFunction cf1 = new ComplexFunction(p1);
//			ComplexFunction cf2 = new ComplexFunction(p2);
//			ComplexFunction cf3 = new ComplexFunction(p3);
//			System.out.println(cf3);
//		}catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//	}
//
//	@Test
//	void testComplexFunctionStringFunctionFunction() {
//
//		try {
//			String s1 = "3.1+2.4x^2-x^4";
//			String s2 = "5 +2x-3.3x+0.1x^5";
//			Polynom p1 = new Polynom(s1);
//			Polynom p2 = new Polynom(s2);
//			ComplexFunction cf = new ComplexFunction("Plus", p1, p2);
//			ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x+1"), cf);
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//		try {
//			Polynom p2 = new Polynom("0");
//			ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x+1"), p2);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//		Polynom test1 = new Polynom("x+1");
//		Monom m1 = new Monom("1");
//		System.out.println(m1);
//		System.out.println(test1);
//
//	}
//
//
//	@Test
//	void testComplexFunctionOperationFunctionFunction() {
//		try {
//			Polynom p = new Polynom("x^2+22+11x");
//			Monom m1 = new Monom("x^3");
//			ComplexFunction test = new ComplexFunction(Operation.Plus, p, m1);
//			System.out.println(test);
//			function f1 = new Monom("x^33");
//			ComplexFunction test2 = new ComplexFunction(Operation.Divid, test,f1);
//			System.out.println(test2);
//		}catch (Exception e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//	}
//
//	@Test
//	void testF() {
//System.out.println("fffffffffffff(x)");
//		Polynom p1 = new Polynom("5x");
//		Polynom p2 = new Polynom("3x");
//		Monom m1 = new Monom("2");
//		Monom m2 = new Monom("1");
//		System.out.println("f-*");
//		///////////////////////////////////////////////////
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction(p1);
//			System.out.println(cf1);
//			cf1.mul(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//			System.out.println(cf1.f(1));
//
//		} catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction("mul",p1,m1);
//			System.out.println(cf1);
//			cf1.mul(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//			System.out.println(cf1.f(1));
//
//		}catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//		///////////////////end mul///////////////////////////
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction(p1);
//			System.out.println(cf1);
//			cf1.div(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//			System.out.println(cf1.f(1));
//
//		} catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction("div",p1,m1);
//			System.out.println(cf1);
//			cf1.div(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//			System.out.println(cf1.f(1));
//
//		}catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//	}

//	@Test
//	void testInitFromString() {
//		System.out.println("---------------------------");
//		Polynom a = new Polynom("0");
//		ComplexFunction cf = new ComplexFunction(a);
//		function cf1 = cf.initFromString("plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.298x+5.0)");
//		ComplexFunction cf2 = new ComplexFunction(cf1);
//		System.out.println(cf2);
//		System.out.println("---------------------------");
//	}

//	@Test
//	void testCopy() {
//		System.out.println("testtttttt copppppyyyyyy");
//		Polynom p1 = new Polynom("55.446x");
//		Polynom p2 = new Polynom("3x^2");
//		Monom m1 = new Monom("2.01");
//		Monom m2 = new Monom("1");
//		try {
//		ComplexFunction cf1 = new ComplexFunction(p1);
//		System.out.println(cf1);
//		
//		ComplexFunction cf2 = (ComplexFunction) cf1.copy();
//		System.out.println(cf2);
//		
//		
//		
//		}catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
//
//	@Test
//	void testPlus() {
//		Polynom p1 = new Polynom("55.446x");
//		Polynom p2 = new Polynom("3x^2");
//		Monom m1 = new Monom("2.01");
//		Monom m2 = new Monom("1");
//		System.out.println("+");
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction(p1);
//			System.out.println(cf1);
//			cf1.plus(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		} catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction(Operation.Plus,p1,m1);
//			System.out.println(cf1);
//			cf1.plus(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		}catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//
//	}
//
//	@Test
//	void testMul() {
//		Polynom p1 = new Polynom("55.446x");
//		Polynom p2 = new Polynom("3x^2");
//		Monom m1 = new Monom("2.01");
//		Monom m2 = new Monom("1");
//		System.out.println("*");
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction(p1);
//			System.out.println(cf1);
//			cf1.mul(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		} catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction("mul",p1,m1);
//			System.out.println(cf1);
//			cf1.mul(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		}catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
//
//	@Test
//	void testDiv() {
//		Polynom p1 = new Polynom("55.446x");
//		Polynom p2 = new Polynom("3x^2");
//		Monom m1 = new Monom("2.01");
//		Monom m2 = new Monom("1");
//		System.out.println("/");
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction(p1);
//			System.out.println(cf1);
//			cf1.div(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		} catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction("div",p1,m1);
//			System.out.println(cf1);
//			cf1.div(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		}catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
//	/////////////////////////////////////////////////////////////////////////////////////////////////////
//	@Test
//	void testMax() {
//		Polynom p1 = new Polynom("55.446x");
//		Polynom p2 = new Polynom("3x^2");
//		Monom m1 = new Monom("2.01");
//		Monom m2 = new Monom("1");
//		System.out.println("Maximum");
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction(p1);
//			System.out.println(cf1);
//			cf1.max(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		} catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction("max",p1,m1);
//			System.out.println(cf1);
//			cf1.max(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		}catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}	
//	}
//
//	@Test
//	void testMin() {
//		Polynom p1 = new Polynom("55.446x");
//		Polynom p2 = new Polynom("3x^2");
//		Monom m1 = new Monom("2.01");
//		Monom m2 = new Monom("1");
//		System.out.println("Minimum");
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction(p1);
//			System.out.println(cf1);
//			cf1.min(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		} catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction("min",p1,m1);
//			System.out.println(cf1);
//			cf1.min(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		}catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}	
//	}
//
//	@Test
//	void testComp() {
//		Polynom p1 = new Polynom("55.446x");
//		Polynom p2 = new Polynom("3x^2");
//		Monom m1 = new Monom("2.01");
//		Monom m2 = new Monom("1");
//		System.out.println("Compute Funcs");
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction(p1);
//			System.out.println(cf1);
//			cf1.comp(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		} catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//
//		try {
//			System.out.println("*******");
//			ComplexFunction cf1 = new ComplexFunction("comp",p1,m1);
//			System.out.println(cf1);
//			cf1.comp(p2);
//			System.out.println(cf1);
//			System.out.println("*******");
//
//		}catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}	
//	}
//
//	@Test
//	void testLeft() {
//
//	}
//
//	@Test
//	void testRight() {
//
//	}
//
//	@Test
//	void testGetOp() {
//
//	}
//
//	@Test
//	void testToString() {
//		
//
//	}
	
	@Test
	void testequals() {
		
		Monom m1 = new Monom("x");
		Polynom p1 = new Polynom("x^2");
		ComplexFunction cf = new ComplexFunction(Operation.Divid,p1,m1);
		
		System.out.println(cf.equals(m1));

	}

}
