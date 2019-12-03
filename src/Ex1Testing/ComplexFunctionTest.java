package Ex1Testing;

import Ex1.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

class ComplexFunctionTest {

	@Test
	void testComplexFunction() {
		fail("Not yet implemented");
	}

	@Test
	void testComplexFunctionOperationFunctionFunction() {
		
		try {
			Polynom p1 = new Polynom("x^2+22+11x");
			Monom m1 = new Monom("x^3");
			ComplexFunction test = new ComplexFunction(Operation.Plus, p1, m1);
			System.out.println(test);
			
			function f1 = new Monom("x^33");
			ComplexFunction test2 = new ComplexFunction(Operation.Divid, test,f1);
			System.out.println(test2);
			
		}catch (Exception e) {
			fail("Not yet implemented");
		}
		
		
	}

	@Test
	void testF() {
		fail("Not yet implemented");
	}

	@Test
	void testInitFromString() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

	@Test
	void testPlus() {
		fail("Not yet implemented");
	}

	@Test
	void testMul() {
		fail("Not yet implemented");
	}

	@Test
	void testDiv() {
		fail("Not yet implemented");
	}

	@Test
	void testMax() {
		fail("Not yet implemented");
	}

	@Test
	void testMin() {
		fail("Not yet implemented");
	}

	@Test
	void testComp() {
		fail("Not yet implemented");
	}

	@Test
	void testLeft() {
		fail("Not yet implemented");
	}

	@Test
	void testRight() {
		fail("Not yet implemented");
	}

	@Test
	void testGetOp() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
