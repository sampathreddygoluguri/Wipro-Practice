package com.wipro.calc;

import org.junit.jupiter.api.Assertions;

public class CalculationTest {
	Calculation c = new Calculation();
	
	@Test
	void add_Test() {
		Assertions.assertEquals(9, c.add(3,6));
	}
	
	@Test
	void sub_Test() {
		Assertions.assertEquals(9, c.sub(3,6));
	}
	
	@Test
	void mul_Test() {
		Assertions.assertEquals(9, c.mul(3,6));
	}

}
