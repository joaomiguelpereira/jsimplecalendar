package eu.jpereira.jsimplecalendar.testing;

import org.testng.annotations.Test;

import eu.jpereira.testfw.Comparsion;

public class JUnitLessComparsion implements Comparsion {

	Object evalue_under_test;

	public JUnitLessComparsion(Object jUnitExpectation) {
		evalue_under_test = jUnitExpectation;
	}

	@Override
	@Test
	public void than(Object expected) {
		Assertions.assert_are_naturally_ordered(evalue_under_test, expected);

	}

	@Override
	@Test
	public void to(Object expected) {
		than(expected);

	}

	@Override
	@Test
	public void of(Object expected) {
		than(expected);

	}

}
