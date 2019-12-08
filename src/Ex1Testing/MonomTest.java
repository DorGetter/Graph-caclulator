package Ex1Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Ex1.Monom;
import Ex1.Polynom;

class MonomTest {

	Monom m0,m1,m2,m3,m4;
	Monom [] mon;

	@BeforeEach
	public void setUp() throws Exception 
	{
		mon=new Monom[5];
		m0=new Monom(0,0);
		m1=new Monom(1,1);
		m2=new Monom(3,0);
		m3=new Monom(-2.5,2);
		m4=new Monom(3,4);
		mon[0]=m0;
		mon[1]=m1;
		mon[2]=m2;
		mon[3]=m3;
		mon[4]=m4;

	}
	@AfterEach
	public void tearDown() throws Exception 
	{
		for(int i=0;i<mon.length;i++) 
		{
			mon[i]=null;
		}
	}

	@Test
	void testMonomDoubleInt() {

		fail("Not yet implemented");
	}

	@Test
	void testMonomMonom() {
		for(int i=0;i<mon.length;i++) 
		{
			Monom actual=new Monom(mon[i]);
			assertEquals(mon[i],actual);
		}
	}

	@Test
	void testGet_coefficient() {
		double[] expectedArr= {0,1,3,-2.5,3};
		double[] actualArr= new double[5];
		for(int i=0;i<mon.length;i++) 
		{
			actualArr[i]=mon[i].get_coefficient();
			assertEquals("testing get coefficent:",expectedArr[i],actualArr[i],0.00001);
		}
	}

	@Test
	void testGet_power() {
		int[] expectedArr= {0,1,0,2,4};
		int[] actualArr= new int[5];
		for(int i=0;i<mon.length;i++) 
		{
			actualArr[i]=mon[i].get_power();
			assertEquals("testing f:",expectedArr[i],actualArr[i],0.00001);
		}
	}

	@Test
	void testDerivative() {
		Monom m1 = new Monom(5,3);
		Monom m2 =new Monom(2,5);
		Monom m4 =new Monom(4,5);


		Monom dm1 = new Monom(15,2);
		Monom dm2 = new Monom(10,4);
		Monom dm4 = new Monom(20,4);

		Monom d1 = (Monom) m1.derivative();
		Monom d2 = (Monom) m2.derivative();
		Monom d4 = (Monom) m4.derivative();

		assertEquals(d2.toString(), dm2.toString());
		assertEquals(d1.toString(), dm1.toString());
		assertEquals(d4.toString(),dm4.toString());

		Monom[] expectedArr= {new Monom("0"),new Monom("1"),new Monom("0"),new Monom("-5x"),new Monom("12x^3")};
		Monom[] actualArr=new Monom[5];
		for(int i=0;i<mon.length;i++) 
		{
			actualArr[i]=new Monom(mon[i].derivative());
		}
		assertArrayEquals(expectedArr,actualArr);
	}


	@Test
	void testF() {
		Monom m1 = new Monom(5,3);
		double f1, temp;
		for (int i = 1; i < 5; i++) {
			f1=m1.f(i);
			temp= 5*(Math.pow(i, 3));
			if(temp != f1) {
				fail();
			}
		}

		double[] expectedArr= {0,2,3,-10,48};
		double[] actualArr= new double[5];
		for(int i=0;i<mon.length;i++) 
		{
			actualArr[i]=mon[i].f(2);
			assertEquals("testing f:",expectedArr[i],actualArr[i],0.00001);
		}
	}

	@Test
	void testIsZero() {
		Monom m1 = new Monom(5,3);
		Monom m2 =new Monom(0,5);

		if(m1.isZero()) {
			fail("work on your math");
		}
		if(!m2.isZero()) {
			fail("work on your math");
		}
		boolean[] expectedArr= {true,false,false,false,false};
		boolean[] actualArr= new boolean[5];
		for(int i=0;i<mon.length;i++) 
		{
			actualArr[i]=mon[i].isZero();
		}
		assertArrayEquals(expectedArr,actualArr);
	}

	@Test
	void testMonomString() {
		Monom[] actualArr= {new Monom("0"),new Monom("x"),new Monom("3"),new Monom("-2.5x^2"),new Monom("3x^4")};
		assertArrayEquals(mon,actualArr);
		assertThrows( RuntimeException.class,() -> new Monom("jdk"));
		assertThrows( RuntimeException.class,() -> new Monom("3x^"));
		assertThrows( RuntimeException.class,() -> new Monom("3xf"));
		assertThrows( RuntimeException.class,() -> new Monom("3x^-2"));
	}

	@Test
	void testAdd() {
		Monom dm1 = new Monom(15,4);
		Monom dm2 = new Monom(5,4);
		Monom dm4 = new Monom(20,4);
		dm1.add(dm2);		
		assertEquals(dm1.toString(), dm4.toString());

		Monom[] expectedArr= {new Monom("x"),new Monom("2x"),new Monom("6"),new Monom("-5x^2"),new Monom("6x^4")};
		mon[0].add(mon[1]);
		mon[1].add(mon[1]);
		mon[2].add(mon[2]);
		mon[3].add(mon[3]);
		mon[4].add(mon[4]);
		assertArrayEquals(expectedArr,mon);
		assertThrows( RuntimeException.class,() -> mon[1].add(m2));
	}

	@Test
	void testMultipyMonom() {
		Monom m1 = new Monom(4,2);
		Monom m2 = new Monom(5,2);
		Monom m4 = new Monom(20,4);
		m1.multipy(m2);
		assertEquals(m1.toString(), m4.toString());
		
		Monom[] expectedArr= {new Monom("0"),new Monom("x^2"),new Monom("9"),new Monom("0"),new Monom("3x^6")};
		mon[0].multipy(mon[1]);
		mon[1].multipy(mon[1]);
		mon[2].multipy(mon[2]);
		mon[3].multipy(mon[0]);
		mon[4].multipy(mon[1]);
		assertArrayEquals(expectedArr,mon);
	}

	@Test
	void testMultipyInt() {

		Monom m1 = new Monom(3,1);
		Monom m2 = new Monom("x");
		m2.multipy(3);
		assertEquals(m1, m2);
	}

	@Test
	void testToString() {
		Monom dm1 = new Monom(15,4);
		String s="15.0x^4";
		String d=dm1.toString();

		assertEquals(d, s);
		
		assertEquals("0",mon[0].toString());
		assertEquals("x",mon[1].toString());
		assertEquals("3.0",mon[2].toString());
		assertEquals("-2.5x^2",mon[3].toString());
		assertEquals("3.0x^4",mon[4].toString());
	}

	@Test
	void testEqualsMonom() {
		Monom m1=new Monom("3x^2");
		Monom m2=new Monom("3x^2");
		Monom m3=new Monom("3");
		Object p=new Polynom("3");
		assertTrue(m3.equals(p));
		assertTrue(m1.equals(m2));
		assertFalse(m1.equals(m3));
	}

	@Test
	void testInitFromString() {
		String s="15.0x^4";
		Monom m= new Monom(0,0);
		Monom m2= new Monom(15,4);
		Monom f = (Monom) m.initFromString(s);

		assertEquals(f.toString(), m2.toString());
	}

	@Test
	void testCopy() {
		Monom m2= new Monom(15,4);
		Monom m1= (Monom) m2.copy();
		assertEquals(m2.toString(), m1.toString());
	}

}
