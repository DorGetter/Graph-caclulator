package Ex1Testing;

import Ex1.*;

import static org.junit.Assert.assertEquals;
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
		
		Polynom expected0=new Polynom("3x^2-7x+9");
		ComplexFunction actual0=new ComplexFunction(expected0);
		assertEquals(expected0.f(5),actual0.f(5),0.00001);
		Polynom expected1=new Polynom("6x^3-25x+70");
		ComplexFunction actual1=new ComplexFunction(expected1);
		assertEquals(expected1.f(5),actual1.f(5),0.00001);
		Monom expected2=new Monom("15x^2");
		ComplexFunction actual2=new ComplexFunction(expected2);
		assertEquals(expected2.f(5),actual2.f(5),0.00001);
		Monom expected3=new Monom("-8.5x");
		ComplexFunction actual3=new ComplexFunction(expected3);
		assertEquals(expected3.f(5),actual3.f(5),0.00001);
		
		
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
		double [] expectedArr={-905.0856,-0.696969,52,-3.3,-3.3};
		double [] actualArr=new double[5];
		for(int i=0;i<cf.length;i++) 
		{
			actualArr[i]=cf[i].f(2);	
			assertEquals("testing f:",expectedArr[i],actualArr[i],0.00001);
		}
		
		
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
		System.out.println("--------------testInitFromString-------------");
		Polynom a = new Polynom("0");
		ComplexFunction cfx = new ComplexFunction(a);
		function cf1x = cfx.initFromString("plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.298x+5.0)");
		ComplexFunction cf2 = new ComplexFunction(cf1x);
		System.out.println(cf2);
		
		
		
		Polynom p0=new Polynom("x+2");
		Polynom p1=new Polynom("x^2");
		ComplexFunction c0=new ComplexFunction(Operation.Comp,p0,p1);
		Polynom p2=new Polynom("5x");
		ComplexFunction c1=new ComplexFunction(Operation.None,p2,null);
		ComplexFunction c2=new ComplexFunction(Operation.Plus,c0,c1);
		Polynom p3=new Polynom("x");
		ComplexFunction c3=new ComplexFunction(Operation.Max,p1,p3);
		Polynom p4=new Polynom("3x");
		Polynom p5=new Polynom("3");
		ComplexFunction c4=new ComplexFunction(Operation.Divid,p4,p5);
		ComplexFunction c5=new ComplexFunction(Operation.Min,c3,c4);
		ComplexFunction c6=new ComplexFunction(Operation.Times,c2,c5);
		ComplexFunction c=(ComplexFunction)c6.initFromString("mul(plus(comp(x+2,x^2),none(5x,null)),min(max(x^2,x),div(3x,3)))");
		assertEquals(c6,c);
		assertThrows( RuntimeException.class,() -> cf[0].initFromString("plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5.5 -1.2999999999999998x +5.0)"));//power type of double
		assertThrows( RuntimeException.class,() -> cf[0].initFromString("plus(-1.0x^4 +2.4x^2 +3.1+0.1x^5 -1.2999999999999998x +5.0)"));//wrong structure 
		assertThrows( RuntimeException.class,() -> cf[0].initFromString("plus(-1.0x^4 +2.4x^2 +3.1+0.1x^5 -1.2999999999999998x +5.0),()"));//wrong structure
		assertThrows( RuntimeException.class,() -> cf[0].initFromString("Plus(-1.0x^4 +2.4x^2 +3.1+0.1x^5 -1.2999999999999998x +5.0)"));//plus with capital letter
		
		System.out.println("------------******---------------");
		
		
		
	}

	@Test
	void testCopy() {
		
		function [] actualArr=new ComplexFunction[5];
		for(int i=0;i<cf.length;i++) 
		{
			actualArr[i]=cf[i].copy();	
		}
		assertArrayEquals(cf,actualArr);
		
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
		
		for(int i=1;i<cf.length;i++)
		{
			double expected=cf[i].f(i)+cf[i-1].f(i);
			cf[i].plus(cf[i-1]);
			double actual=cf[i].f(i);
			assertEquals(expected,actual,0.00001);
		}
		
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
		
		for(int i=1;i<cf.length;i++)
		{
			double expected=cf[i].f(i)*cf[i-1].f(i);
			cf[i].mul(cf[i-1]);
			double actual=cf[i].f(i);
			assertEquals(expected,actual,0.00001);
		}
		
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
		
		for(int i=1;i<cf.length;i++)
		{
			double expected=cf[i].f(i)/cf[i-1].f(i);
			cf[i].div(cf[i-1]);
			double actual=cf[i].f(i);
			assertEquals(expected,actual,0.00001);
		}
		
		
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
		
		for(int i=1;i<cf.length;i++)
		{
			
			double expected=cf[i].f(i);
			if(cf[i].f(i)<cf[i-1].f(i))
			{
				expected=cf[i-1].f(i);
			}
			cf[i].max(cf[i-1]);
			double actual=cf[i].f(i);
			assertEquals(expected,actual,0.00001);
		}
		
		
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
		
		for(int i=1;i<cf.length;i++)
		{		
			double expected=cf[i].f(i);
			if(cf[i].f(i)>cf[i-1].f(i))
			{
				expected=cf[i-1].f(i);
			}
			cf[i].min(cf[i-1]);
			double actual=cf[i].f(i);
			assertEquals(expected,actual,0.00001);
		}
		
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
		
		for(int i=1;i<cf.length;i++)
		{
			double expected=cf[i].f(cf[i-1].f(i));
			cf[i].comp(cf[i-1]);
			double actual=cf[i].f(i);
			assertEquals(expected,actual,0.00001);
		}
		
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
		function [] actualArr=new ComplexFunction[5];
		actualArr[0]=new ComplexFunction("-1.0x^4 +2.4x^2 +3.1");
		actualArr[1]=new ComplexFunction("plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x+5.0)");
		actualArr[2]=new ComplexFunction("2x^2+4+5x^3");
		actualArr[3]=new ComplexFunction("-1.0x^4 +2.4x^2+3.1");
		actualArr[4]=new ComplexFunction("min(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x+5.0)");
		for(int i=0;i<cf.length;i++) 
		{
			assertEquals(cf[i].left(),actualArr[i]);
		}
	}

	@Test
	void testRight() {
		
		function [] actualArr=new ComplexFunction[5];
		actualArr[0]=new ComplexFunction("+0.1x^5-1.2999999999999998x +5.0");
		actualArr[1]=new ComplexFunction("-1.0x^4 +2.4x^2 +3.1");
		actualArr[2]=new ComplexFunction("1");
		actualArr[3]=null;
		actualArr[4]=new ComplexFunction("-1.0x^4 +2.4x^2 +3.1");
		for(int i=0;i<cf.length;i++) 
		{
			assertEquals(cf[i].right(),actualArr[i]);
		}
	}

	@Test
	void testGetOp() {
		
		Operation [] actualArr= {Operation.Comp,Operation.Divid,Operation.Times,Operation.None,Operation.Max};
		Operation [] expectedArr=new Operation [5];
		for(int i=0;i<cf.length;i++) 
		{
			expectedArr[i]=cf[i].getOp();
		}
		assertArrayEquals(expectedArr,actualArr);
	
	}

	@Test
	void testToString() {
	}
	
	@Test
	void testequals() {
		
		ComplexFunction cf0=new ComplexFunction("mul(x,x)");
		ComplexFunction cf1=new ComplexFunction("mul(x^2,1)");
		assertTrue(cf1.equals(cf0));
		ComplexFunction cf2=new ComplexFunction("plus(3x,4x)");
		ComplexFunction cf3=new ComplexFunction("mul(x,7)");
		assertTrue(cf3.equals(cf2));
		ComplexFunction cf4=new ComplexFunction("plus(3x+2,4x)");
		assertFalse(cf4.equals(cf3));
		Object p0=new Polynom("7x+2");	
		assertTrue(cf4.equals(p0));
		Object m0=new Monom("3x^2");
		ComplexFunction cf5=new ComplexFunction("3x^2");
		ComplexFunction cf6=new ComplexFunction("none(3x^2,null)");
		assertTrue(cf6.equals(m0));
		assertTrue(cf5.equals(m0));
		
		
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
