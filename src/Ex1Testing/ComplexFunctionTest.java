package Ex1Testing;

import Ex1.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComplexFunctionTest {


	ComplexFunction cf0,cf1,cf2,cf3,cf4,cf5;
	ComplexFunction [] cf;
	@BeforeEach
	void setUp() throws Exception
	{
		cf=new ComplexFunction[5];
		cf0=new ComplexFunction("comp(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0)");
		cf1=new ComplexFunction("div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x+5.0),-1.0x^4 +2.4x^2 +3.1)");
		cf2=new ComplexFunction("mul(2x^2+4+5x^3,1)");
		cf3=new ComplexFunction("-1.0x^4 +2.4x^2 +3.1");
		cf4=new ComplexFunction("max(min(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x+5.0),-1.0x^4 +2.4x^2 +3.1)");
		cf[0]=cf0;
		cf[1]=cf1;
		cf[2]=cf2;
		cf[3]=cf3;
		cf[4]=cf4;
	}
	
	@AfterEach
	void tearDown() throws Exception
	{
		for(int i=0;i<cf.length;i++) 
			cf[i]=null;
	}

	@Test
	void testComplexFunctionFunction() {

		try {
			String[] s3 = {"x+3","x-2", "x-4"};
			Polynom p1 = new Polynom(s3[0]);
			Polynom p2 = new Polynom(s3[1]);
			Polynom p3 = new Polynom(s3[2]);
			ComplexFunction cf1 = new ComplexFunction(p1);
			ComplexFunction cf2 = new ComplexFunction(p2);
			ComplexFunction cf3 = new ComplexFunction(p3);
			System.out.println(cf3);
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}

	}

	@Test
	void testComplexFunctionStringFunctionFunction() {

		ComplexFunction [] actual=new ComplexFunction[5];
		Polynom p0=new Polynom("-1.0x^4+2.4x^2+3.1");
		Polynom p1=new Polynom("0.1x^5-1.2999999999999998x+5.0");
		String op1="comp";
		actual[0]=new ComplexFunction(op1,p0,p1);
		ComplexFunction temp=new ComplexFunction("plus",p0,p1);
		actual[1]=new ComplexFunction("div",temp,p0);
		Polynom p2=new Polynom("2x^2+4+5x^3");
		Monom m0=new Monom("1");
		actual[2]=new ComplexFunction("mul",p2,m0);
		actual[3]=new ComplexFunction("none",new Polynom("-1.0x^4+2.4x^2+3.1"),null);
		ComplexFunction temp1=new ComplexFunction("min",p0,p1);
		actual[4]=new ComplexFunction("max",temp1,p0);
		for(int i=0;i<cf.length;i++)
		{
			//assertEquals(cf[i].toString(),actual[i].toString());
		}
		
		
		try {
			String s1 = "3.1+2.4x^2-x^4";
			String s2 = "5 +2x-3.3x+0.1x^5";
			p1 = new Polynom(s1);
			p2 = new Polynom(s2);
			ComplexFunction cf = new ComplexFunction("Plus", p1, p2);
			ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x+1"), cf);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}

		try {
			p2 = new Polynom("0");
			ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x+1"), p2);
		} catch (Exception e) {
			System.out.println(e);
		}

		Polynom test1 = new Polynom("x+1");
		Monom m1 = new Monom("1");
		System.out.println(m1);
		System.out.println(test1);

	}


	@Test
	void testComplexFunctionOperationFunctionFunction() {
		
		try {
			ComplexFunction [] actual=new ComplexFunction[5];
			Polynom p0=new Polynom("-1.0x^4+2.4x^2+3.1");
			Polynom p1=new Polynom("0.1x^5-1.2998x+5.0");
			actual[0]=new ComplexFunction(Operation.Comp,p0,p1);
			ComplexFunction temp=new ComplexFunction(Operation.Plus,p0,p1);
			actual[1]=new ComplexFunction(Operation.Divid,temp,p0);
			Polynom p2=new Polynom("2x^2+4+5x^3");
			Monom m0=new Monom("1");
			actual[2]=new ComplexFunction(Operation.Times,p2,m0);
			actual[3]=new ComplexFunction(Operation.None,new Polynom("-1.0x^4+2.4x^2+3.1"),null);
			ComplexFunction temp1=new ComplexFunction(Operation.Min,p0,p1);
			actual[4]=new ComplexFunction(Operation.Max,temp1,p0);
			for(int i=0;i<cf.length;i++)
			{
				System.out.println("+++++++++++++++++"+i);
				assertEquals(cf[i],actual[i]);
				
			}
		} catch (Exception e) {
			
			System.out.println(e);
			e.printStackTrace();
			fail();
		}
		
		
		try {
			Polynom p = new Polynom("x^2+22+11x");
			Monom m1 = new Monom("x^3");
			ComplexFunction test = new ComplexFunction(Operation.Plus, p, m1);
			System.out.println(test);
			function f1 = new Monom("x^33");
			ComplexFunction test2 = new ComplexFunction(Operation.Divid, test,f1);
			System.out.println(test2);
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}

	}

	@Test
	void testF() {
		System.out.println("fffffffffffff(x)");
		Polynom p1 = new Polynom("5x");
		Polynom p2 = new Polynom("3x");
		Monom m1 = new Monom("2");
		Monom m2 = new Monom("1");
		System.out.println("f-*");
		///////////////////////////////////////////////////
		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.mul(p2);
			System.out.println(cf1);
			System.out.println("*******");
			System.out.println(cf1.f(1));

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}

		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction("mul",p1,m1);
			System.out.println(cf1);
			cf1.mul(p2);
			System.out.println(cf1);
			System.out.println("*******");
			System.out.println(cf1.f(1));

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}
		///////////////////end mul///////////////////////////
		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.div(p2);
			System.out.println(cf1);
			System.out.println("*******");
			System.out.println(cf1.f(1));

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}

		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction("div",p1,m1);
			System.out.println(cf1);
			cf1.div(p2);
			System.out.println(cf1);
			System.out.println("*******");
			System.out.println(cf1.f(1));

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}

	}

	@Test
	void testInitFromString() {
		System.out.println("---------------------------");
		Polynom a = new Polynom("0");
		ComplexFunction cf = new ComplexFunction(a);
		function cf1 = cf.initFromString("plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.298x+5.0)");
		ComplexFunction cf2 = new ComplexFunction(cf1);
		System.out.println(cf2);
		System.out.println("---------------------------");
	}

	@Test
	void testCopy() {
		System.out.println("testtttttt copppppyyyyyy");
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");
		try {
		ComplexFunction cf1 = new ComplexFunction(p1);
		System.out.println(cf1);
		
		ComplexFunction cf2 = (ComplexFunction) cf1.copy();
		System.out.println(cf2);
		
		
		
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	@Test
	void testPlus() {
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");
		System.out.println("+");
		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.plus(p2);
			System.out.println(cf1);
			System.out.println("*******");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}

		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction(Operation.Plus,p1,m1);
			System.out.println(cf1);
			cf1.plus(p2);
			System.out.println(cf1);
			System.out.println("*******");

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}


	}

	@Test
	void testMul() {
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");
		System.out.println("*");
		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.mul(p2);
			System.out.println(cf1);
			System.out.println("*******");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}

		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction("mul",p1,m1);
			System.out.println(cf1);
			cf1.mul(p2);
			System.out.println(cf1);
			System.out.println("*******");

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	@Test
	void testDiv() {
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");
		System.out.println("/");
		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.div(p2);
			System.out.println(cf1);
			System.out.println("*******");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}

		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction("div",p1,m1);
			System.out.println(cf1);
			cf1.div(p2);
			System.out.println(cf1);
			System.out.println("*******");

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	void testMax() {
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");
		System.out.println("Maximum");
		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.max(p2);
			System.out.println(cf1);
			System.out.println("*******");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}

		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction("max",p1,m1);
			System.out.println(cf1);
			cf1.max(p2);
			System.out.println(cf1);
			System.out.println("*******");

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}	
	}

	@Test
	void testMin() {
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");
		System.out.println("Minimum");
		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.min(p2);
			System.out.println(cf1);
			System.out.println("*******");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}

		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction("min",p1,m1);
			System.out.println(cf1);
			cf1.min(p2);
			System.out.println(cf1);
			System.out.println("*******");

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}	
	}

	@Test
	void testComp() {
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");
		System.out.println("Compute Funcs");
		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.comp(p2);
			System.out.println(cf1);
			System.out.println("*******");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}

		try {
			System.out.println("*******");
			ComplexFunction cf1 = new ComplexFunction("comp",p1,m1);
			System.out.println(cf1);
			cf1.comp(p2);
			System.out.println(cf1);
			System.out.println("*******");

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}	
	}

	@Test
	void testLeft() {

	}

	@Test
	void testRight() {

	}

	@Test
	void testGetOp() {

	}

	@Test
	void testToString() {
		

	}
	
	@Test
	void testequals() {
		System.out.println("***testequals:***");
		try {
		Monom m1 = new Monom("x");
		Polynom p1 = new Polynom("x^2");
		ComplexFunction cf = new ComplexFunction(Operation.Divid,p1,m1);
		
		System.out.println(cf.equals(m1));
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}
		System.out.println("****");

	}

}
