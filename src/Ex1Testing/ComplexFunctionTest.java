package Ex1Testing;

import Ex1.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.function.Function;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComplexFunctionTest {


	ComplexFunction cf0,cf1,cf2,cf3,cf4,cf5;
	ComplexFunction [] cf;
	ComplexFunction [] complist;
	Polynom [] polylist;
	Monom [] monolist;
	String [] str;
	
	@BeforeEach
	void setUp() throws Exception
	{
		complist = new ComplexFunction[5];
		polylist = new Polynom[5];
		monolist = new Monom[5];
		str = new String[5];
		double start = -50;
		double end = 50;
		for (int i = 0; i < 5; i++) {
			double random = new Random().nextDouble();
			double result = start + (random * (end - start));
			
			str[i] = result+"x^";
		}
		
		for (int i = 0; i < 5; i++) {
			int random = new Random().nextInt(9 + 1)+1;
			str[i] =str[i]+""+random;
		}
		
		for (int i = 0; i < 5; i++) {
			monolist[i] = new Monom(str[i]);
		}
		
		for (int i = 0; i <5; i++) {
			int random = new Random().nextInt(4 + 1);
			polylist[i] = new Polynom();
			polylist[i].add(monolist[random]);
			polylist[i].add(monolist[random]);
		}
		
		for (int i = 0; i <5; i++) {
			int random = new Random().nextInt(4 + 1);
			complist[i] = new ComplexFunction(polylist[random]);
			complist[i].comp(polylist[random]);
		}
		
		for (int i = 0; i <5; i++) {
			int random = new Random().nextInt(4 + 1);
			complist[i].plus(monolist[random]);
		}
		
		
		
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
		for(int i=0;i<cf.length;i++) {
			polylist[i]=null;
			monolist[i]=null;
			str[i]=null;
			cf[i]=null;
		}
			
	}

	@Test
	void testComplexFunctionFunction() {
		
		
		ComplexFunction [] test = new ComplexFunction[5];
		for (int i = 0; i < 5; i++) {
			test[i] = new ComplexFunction(complist[i]);
			assertEquals(test[i], complist[i]);
		}
		
		test = new ComplexFunction[5];
		for (int i = 0; i < test.length; i++) {
			test[i] = new ComplexFunction(polylist[i]);
			assertEquals(test[i], polylist[i]);
		}
		
		test = new ComplexFunction[5];
		for (int i = 0; i < test.length; i++) {
			test[i] = new ComplexFunction(monolist[i]);
			assertEquals(test[i], monolist[i]);
		}
		
		
		
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
		
		ComplexFunction [] test = new ComplexFunction[5];
		for (int i = 0; i < test.length; i++) {
			Operation op = complist[i].getOp();
			function left = complist[i].left();
			function right = complist[i].right();
			String op_str = ""+op;
			test[i] = new ComplexFunction(op_str,left,right);
		}
		
		for (int i = 0; i < test.length; i++) {
			assertEquals(complist[i], test[i]);
		}
		
		try {
			String s1 = "3.1+2.4x^2-x^4";
			String s2 = "5 +2x-3.3x+0.1x^5";
			Polynom p1 = new Polynom(s1);
			Polynom p2 = new Polynom(s2);
			ComplexFunction cf = new ComplexFunction("Plus", p1, p2);
			ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x+1"), cf);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		try {
			Polynom p2 = new Polynom("0");
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
		
		ComplexFunction [] test = new ComplexFunction[5];
		for (int i = 0; i < test.length; i++) {
			Operation op = complist[i].getOp();
			function left = complist[i].left();
			function right = complist[i].right();
			test[i] = new ComplexFunction(op,left,right);
		}
		for (int i = 0; i < test.length; i++) {
			assertEquals(complist[i], test[i]);
		}	
			
		try {
			Polynom p = new Polynom("x^2+22+11x");
			Monom m1 = new Monom("x^3");
			ComplexFunction temp = new ComplexFunction(Operation.Plus, p, m1);
			System.out.println(test);
			function f1 = new Monom("x^33");
			ComplexFunction test2 = new ComplexFunction(Operation.Divid, temp,f1);
			System.out.println(test2);
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}

	}

	@Test
	void testF() {


		ComplexFunction [] test = new ComplexFunction[5];
		for (int i = 0; i < test.length; i++) {
			int random = new Random().nextInt(4 + 1);
			test[i] = new ComplexFunction(Operation.Plus,polylist[i],polylist[i]);
			double temp = test[i].f(random);
			double temp2 = polylist[i].f(random)+polylist[i].f(random);
			if (temp != temp2) {
				fail();
			}
		}
		
		ComplexFunction [] test2 = new ComplexFunction[5];
		for (int i = 0; i < test.length; i++) {
			int random = new Random().nextInt(4 + 1);
			test2[i] = new ComplexFunction(Operation.Times,polylist[i],polylist[i]);
			double temp = test2[i].f(random);
			double temp2 = polylist[i].f(random)*polylist[i].f(random);
			if (temp != temp2) {
				fail();
			}
		}
		
		ComplexFunction [] test3 = new ComplexFunction[5];
		
		for (int i = 0; i < test3.length; i++) {
			int random = new Random().nextInt(4 + 1);
			test3[i] = new ComplexFunction(polylist[i]);
			for (int j = 0; j < test3.length; j++) {
				test3[i].plus(test2[j]);
				test3[i].div(test[j]);
				
			}
			test3[i].f(1);
		}
		
		
		Polynom p1 = new Polynom("5x");
		Polynom p2 = new Polynom("3x");
		Monom m1 = new Monom("2");
		Monom m2 = new Monom("1");

		try {
			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.mul(p2);
			System.out.println(cf1);
			System.out.println(cf1.f(1));

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}

		try {

			ComplexFunction cf1 = new ComplexFunction("mul",p1,m1);
			System.out.println(cf1);
			cf1.mul(p2);
			System.out.println(cf1);
			System.out.println(cf1.f(1));

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}
		try {

			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.div(p2);
			System.out.println(cf1);
			System.out.println(cf1.f(1));

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}

		try {
			ComplexFunction cf1 = new ComplexFunction("div",p1,m1);
			System.out.println(cf1);
			cf1.div(p2);
			System.out.println(cf1);
			System.out.println(cf1.f(1));

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}

	}

	@Test
	void testInitFromString() {
		
		Polynom a = new Polynom("0");
		ComplexFunction cfx = new ComplexFunction(a);
		function cf1x = cfx.initFromString("plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.298x+5.0)");
		ComplexFunction cf2 = new ComplexFunction(cf1x);
		assertEquals(cf2.toString(), cf1x.toString());
		ComplexFunction temp = new ComplexFunction("x");
		assertThrows( RuntimeException.class,() -> temp.initFromString("plus(3.1x,11x^5.5)"));
		assertThrows( RuntimeException.class,() -> temp.initFromString("plus(33x^2+19)"));
		assertThrows( RuntimeException.class,() -> temp.initFromString("plus(x^7),()"));
		assertThrows( RuntimeException.class,() -> temp.initFromString("Divi(-1.0x^4,2)"));
		
		
	}

	@Test
	void testCopy() {
		
		
		ComplexFunction [] test = new ComplexFunction[5];
		for (int i = 0; i < test.length; i++) {
			test[i] = (ComplexFunction) complist[i].copy();
			assertEquals(test[i], complist[i]);
		}
		
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");
		try {
		ComplexFunction cf1 = new ComplexFunction(p1);
		ComplexFunction cf2 = (ComplexFunction) cf1.copy();
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testPlus() {
		
		
		ComplexFunction [] test = new ComplexFunction[5]; 
		for (int i = 0; i < cf.length; i++) {
			int random1 = new Random().nextInt(4 + 1);
			int random2 = new Random().nextInt(4 + 1);
			test[i] = new ComplexFunction(Operation.Plus,polylist[random1],polylist[random2]);
			double t1 = test[i].f(10);
			double t2 = polylist[random1].f(10)+polylist[random2].f(10);
			if(t1 != t2) {
				fail();
			}
			
		}
		
	
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");
		System.out.println("+");
		try {
			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.plus(p2);
			System.out.println(cf1);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}

		try {
			ComplexFunction cf1 = new ComplexFunction(Operation.Plus,p1,m1);
			System.out.println(cf1);
			cf1.plus(p2);
			System.out.println(cf1);

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}


	}

	@Test
	void testMul() {

		ComplexFunction [] test = new ComplexFunction[5]; 
		for (int i = 0; i < cf.length; i++) {
			int random1 = new Random().nextInt(4 + 1);
			int random2 = new Random().nextInt(4 + 1);
			test[i] = new ComplexFunction(Operation.Times,monolist[random1],monolist[random2]);
			double t1 = test[i].f(10);
			double t2 = monolist[random1].f(10)*monolist[random2].f(10);
			if(t1 != t2) {
				fail();
			}
			
		}
		
		
		test = new ComplexFunction[5]; 
		for (int i = 0; i < cf.length; i++) {
			int random1 = new Random().nextInt(4 + 1);
			int random2 = new Random().nextInt(4 + 1);
			test[i] = new ComplexFunction(Operation.Times,polylist[random1],polylist[random2]);
			double t1 = test[i].f(10);
			double t2 = polylist[random1].f(10)*polylist[random2].f(10);
			if(t1 != t2) {
				fail();
			}
			
		}
		
		test = new ComplexFunction[5]; 
		for (int i = 0; i < cf.length; i++) {
			int random1 = new Random().nextInt(4 + 1);
			int random2 = new Random().nextInt(4 + 1);
			test[i] = new ComplexFunction(Operation.Times,complist[random1],complist[random2]);
			double t1 = test[i].f(10);
			double t2 = complist[random1].f(10)*complist[random2].f(10);
			if(t1 != t2) {
				fail();
			}
			
		}
			
		
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");

		try {

			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.mul(p2);
			System.out.println(cf1);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}

		try {

			ComplexFunction cf1 = new ComplexFunction("mul",p1,m1);
			System.out.println(cf1);
			System.out.println(cf1);

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testDiv() {
		
		
		ComplexFunction [] test = new ComplexFunction[5]; 
		for (int i = 0; i < cf.length; i++) {
			int random1 = new Random().nextInt(4 + 1);
			int random2 = new Random().nextInt(4 + 1);
			test[i] = new ComplexFunction(Operation.Divid,monolist[random1],monolist[random2]);
			try {
			double t1 = test[i].f(10);
			double t2 = monolist[random1].f(10)/monolist[random2].f(10);
			if(t1 != t2) {
				fail();
			}}catch (RuntimeException e) {}// if div by zero keep alive
			
		}

		
		test = new ComplexFunction[5]; 
		for (int i = 0; i < cf.length; i++) {
			int random1 = new Random().nextInt(4 + 1);
			int random2 = new Random().nextInt(4 + 1);
			test[i] = new ComplexFunction(Operation.Divid,polylist[random1],polylist[random2]);
			try {
			double t1 = test[i].f(10);
			double t2 = polylist[random1].f(10)/polylist[random2].f(10);
			if(t1 != t2) {
				fail();
			}}catch (RuntimeException e) {} // if div by zero keep alive
			
		}
		
		test = new ComplexFunction[5]; 
		for (int i = 0; i < cf.length; i++) {
			int random1 = new Random().nextInt(4 + 1);
			int random2 = new Random().nextInt(4 + 1);
			test[i] = new ComplexFunction(Operation.Divid,complist[random1],complist[random2]);
			try {
			double t1 = test[i].f(10);
			double t2 = complist[random1].f(10)/complist[random2].f(10);
			if(t1 != t2) {
				fail();
			}}catch (RuntimeException e) {}// if div by zero keep alive
			
		}
		
		
		
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");

		try {

			ComplexFunction cf1 = new ComplexFunction(p1);
			System.out.println(cf1);
			cf1.div(p2);
			System.out.println(cf1);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}

		try {
			ComplexFunction cf1 = new ComplexFunction("div",p1,m1);
			System.out.println(cf1);
			cf1.div(p2);
			System.out.println(cf1);

		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testMax() {
		
		
		ComplexFunction c1 = new ComplexFunction("Plus(Times(x,x),8)") ;//9
		ComplexFunction c2 = new ComplexFunction("Times(Plus(Times(x,x),8),3)") ;
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		ComplexFunction c3 = new ComplexFunction(Operation.Max,p1,p2);
		double temp1 = c3.f(2);
		if(temp1 != p1.f(2)) { fail();}
		c3= new ComplexFunction(Operation.Max,c1,c2);
		temp1 =c3.f(1); 
		if(temp1 != c2.f(1)) { fail();} 
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");
		

		try {

			ComplexFunction cf1 = new ComplexFunction(p1);
			cf1.max(p2);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}

		try {
			ComplexFunction cf1 = new ComplexFunction("max",p1,m1);
			cf1.max(p2);
			
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}	
	}

	@Test
	void testMin() {
		   
		ComplexFunction c1 = new ComplexFunction("Plus(Times(x,x),8)") ;//9
		ComplexFunction c2 = new ComplexFunction("Times(Plus(Times(x,x),8),3)") ;
		Polynom p1 = new Polynom("55.446x");
		Polynom p2 = new Polynom("3x^2");
		ComplexFunction c3 = new ComplexFunction(Operation.Min,p1,p2);
		double temp1 = c3.f(2);
		if(temp1 != p2.f(2)) { fail();}
		c3= new ComplexFunction(Operation.Min,c1,c2);
		temp1 =c3.f(1); 
		if(temp1 != c1.f(1)) { fail();} 
		
		p1 = new Polynom("55.446x");
		p2 = new Polynom("3x^2");
		Monom m1 = new Monom("2.01");
		Monom m2 = new Monom("1");
	
		try {
			
			ComplexFunction cf1 = new ComplexFunction(p1);
			cf1.min(p2);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
		}

		try {

			ComplexFunction cf1 = new ComplexFunction("min",p1,m1);

			cf1.min(p2);
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();
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
		try {
			
			ComplexFunction cf1 = new ComplexFunction(p1);

			cf1.comp(p2);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		try {
			ComplexFunction cf1 = new ComplexFunction("comp",p1,m1);
			cf1.comp(p2);
			
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail();}
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
