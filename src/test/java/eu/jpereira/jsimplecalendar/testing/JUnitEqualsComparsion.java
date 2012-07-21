package eu.jpereira.jsimplecalendar.testing;

import org.testng.annotations.Test;

import eu.jpereira.testfw.Comparsion;

public class JUnitEqualsComparsion implements Comparsion {

	private Object value_under_test;

	public JUnitEqualsComparsion(Object jUnitExpectation) {
		value_under_test = jUnitExpectation;
	}

	@Override
	@Test
	public void than(Object expected) {
		to(expected);

	}

	@Override
	@Test
	public void to(Object expected) {
		Assertions.assert_are_equals(value_under_test, expected);

	}

	@Override
	@Test
	public void of(Object expected) {
		to(expected);

	}

}
