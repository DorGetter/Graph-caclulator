package Ex1Testing;

import Ex1.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

class ComplexFunctionTest {

	@Test
	void testComplexFunctionFunction() {
		
		try {
		String[] s3 = {"x+3","x-2", "x-4"};
		Polynom p3 = new Polynom(s3[0]);
		ComplexFunction cf3 = new ComplexFunction(p3);
		System.out.println(cf3);
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Not yet implemented");
		}

	}

	@Test
	void testComplexFunctionOperationFunctionFunction() {
		try {
			Polynom p = new Polynom("x^2+22+11x");
			Monom m1 = new Monom("x^3");
			ComplexFunction test = new ComplexFunction(Operation.Plus, p, m1);
			System.out.println(test);
			function f1 = new Monom("x^33");
			ComplexFunction test2 = new ComplexFunction(Operation.Divid, test,f1);
			System.out.println(test2);
			
			
			String s1 = "3.1+2.4x^2-x^4";
			String s2 = "5 +2x-3.3x+0.1x^5";
			String[] s3 = {"x+3","x-2", "x-4"};
			Polynom p1 = new Polynom(s1);
			Polynom p2 = new Polynom(s2);
			Polynom p3 = new Polynom(s3[0]);
			ComplexFunction cf3 = new ComplexFunction(p3);
			System.out.println(cf3);
			for(int i=1;i<s3.length;i++) {
				cf3.mul(new Polynom(s3[i]));
			}
			
			ComplexFunction cf = new ComplexFunction("Plus", p1, p2);
			ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x+1"), cf3);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
		
	}

	@Test
	void testF() {
		
	}

	@Test
	void testInitFromString() {
		
	}

	@Test
	void testCopy() {
		
	}

	@Test
	void testPlus() {
		
	}

	@Test
	void testMul() {
		
	}

	@Test
	void testDiv() {
		
	}

	@Test
	void testMax() {
		
	}

	@Test
	void testMin() {
		
	}

	@Test
	void testComp() {
		
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

}
