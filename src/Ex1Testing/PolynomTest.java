package Ex1Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Monom;
import Ex1.Polynom;

class PolynomTest {
	
	Polynom p0,p1,p2,p3,p4;
	Polynom [] pol;
	String[] monoms=new String[3];

	@BeforeEach
	public void setUp() throws Exception 
	{
		pol=new Polynom[5];
		p0=new Polynom();
		p1=new Polynom();
		p2=new Polynom();
		p3=new Polynom();
		p4=new Polynom();
		monoms[0] = "1";monoms[1]="x";monoms[2]="x^2";
		for(int i=0;i<monoms.length;i++)
		{
			Monom m = new Monom(monoms[i]);
			p1.add(m);
		}
		monoms[0] = "-2.5x";monoms[1]="x";monoms[2]="x^5";
		for(int i=0;i<monoms.length;i++)
		{
			Monom m = new Monom(monoms[i]);
			p2.add(m);
		}
		monoms[0] = "-5x^3";monoms[1]="2";monoms[2]="7";
		for(int i=0;i<monoms.length;i++)
		{
			Monom m = new Monom(monoms[i]);
			p3.add(m);
		}
		monoms[0] = "1";monoms[1]="0";monoms[2]="0";
		for(int i=0;i<monoms.length;i++)
		{
			Monom m = new Monom(monoms[i]);
			p4.add(m);
		}
		pol[0]=p0;
		pol[1]=p1;
		pol[2]=p2;
		pol[3]=p3;
		pol[4]=p4;
	}

	@AfterEach
	public void tearDown() throws Exception 
	{
		for(int i=0;i<pol.length;i++) 
		{
			pol[i]=null;
		}
	}
	
	
	
	@Test
	void testPolynom() {
		fail("Not yet implemented");
	}

	@Test
	void testPolynomString() {
		Polynom[] actualArr= {new Polynom("0"),new Polynom("1x^2+1x+1"),new Polynom("1x^5-1.5x"),new Polynom("-5x^3+9"),new Polynom("1.0")};
		assertArrayEquals(pol,actualArr);
		assertThrows( RuntimeException.class,() -> new Polynom("x^2-+2x"));
		assertThrows( RuntimeException.class,() -> new Polynom("x^2.2-2x"));
		assertThrows( RuntimeException.class,() -> new Polynom("x^2+2xy"));
		assertThrows( RuntimeException.class,() -> new Polynom("x^2+-2x"));
	}

	@Test
	void testF() {
		double[] expectedArr= {0,7,29,-31,1};
		double[] actualArr= new double[5];
		for(int i=0;i<pol.length;i++) 
		{
			actualArr[i]=pol[i].f(2);
			assertEquals("testing f:",expectedArr[i],actualArr[i],0.00001);
		}
	}

	@Test
	void testAddPolynom_able() {
		Polynom[] expectedArr= {new Polynom("1.0x^2+1.0x+1.0"),new Polynom("1.0x^2+1.0x+1.0"),new Polynom("2.0x^5-3x"),new Polynom("-5.0x^3+2.0x^5-3x+9.0"),new Polynom("1.0x^2+1.0x+2.0")};
		pol[1].add(pol[0]);
		pol[0].add(pol[1]);
		pol[2].add(pol[2]);
		pol[3].add(pol[2]);
		pol[4].add(pol[1]);
		assertArrayEquals(expectedArr,pol);
	}

	@Test
	void testAddMonom() {
		Polynom[] expectedArr= {new Polynom("x"),new Polynom("1.0x^2+2.0x+1.0"),new Polynom("1.0x^5-0.5x"),new Polynom("-5.0x^3+9.0+x"),new Polynom("x+1")};
		Monom m=new Monom("x");
		for(int i=0;i<pol.length;i++) 
		{
			pol[i].add(m);
		}
		assertArrayEquals(expectedArr,pol);
	}

	@Test
	void testSubstract() {
		Polynom[] expectedArr= {new Polynom("-1.0x^2-1.0x-1.0"),new Polynom("1.0x^2+1.0x+1.0"),new Polynom("0"),new Polynom("-5.0x^3+8.0-1.0x^2-1.0x"),new Polynom("1.0")};
		pol[1].substract(pol[0]);
		pol[0].substract(pol[1]);
		pol[2].substract(pol[2]);
		pol[3].substract(pol[1]);
		pol[4].substract(pol[2]);
		assertArrayEquals(expectedArr,pol);
	}

	@Test
	void testMultiplyPolynom_able() {
		Polynom[] expectedArr= {new Polynom("0"),new Polynom("1.0x^3+1.0x^2+1.0x"),new Polynom("1.0x^6-1.5x^2"),new Polynom("-5.0x^4+9.0x"),new Polynom("x")};
		Monom m=new Monom("x");
		for(int i=0;i<pol.length;i++) 
		{
			pol[i].multiply(m);
		}
		assertArrayEquals(expectedArr,pol);
	}

	@Test
	void testEqualsObject() {
		
		Polynom p1=new Polynom("3x^2+5x");
		Polynom p2=new Polynom("3x^2+5x");
		Polynom p3=new Polynom("3x^2+5");
		Polynom p4=new Polynom("3x^2");
		Object m=new Monom("3x^2");
		assertTrue(p4.equals(m));
		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(p3));
		ComplexFunction cf = new ComplexFunction("3x^2");
		assertTrue(p4.equals(cf));
		
		
	}

	@Test
	void testIsZero() {
		fail("Not yet implemented");
	}

	@Test
	void testRoot() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

	@Test
	void testDerivative() {
		fail("Not yet implemented");
	}

	@Test
	void testArea() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiplyMonom() {
		Polynom[] expectedArr= {new Polynom("0"),new Polynom("1.0x^3+1.0x^2+1.0x"),new Polynom("1.0x^6-1.5x^2"),new Polynom("-5.0x^4+9.0x"),new Polynom("x")};
		Monom m=new Monom("x");
		for(int i=0;i<pol.length;i++) 
		{
			pol[i].multiply(m);
		}
		assertArrayEquals(expectedArr,pol);
	}

	@Test
	void testIteretor() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testInitFromString() {
		fail("Not yet implemented");
	}

}
