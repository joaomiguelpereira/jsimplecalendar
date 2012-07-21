package eu.jpereira.jsimplecalendar.testing;

import org.testng.annotations.Test;

import eu.jpereira.testfw.Comparsion;

public class JUnitDifferentComparsion implements Comparsion {

	private Object value_under_test;

	public JUnitDifferentComparsion(JUnitExpectation jUnitExpectation) {
		value_under_test = jUnitExpectation.value_under_test();
	}

	@Override
	@Test
	public void than(Object expected) {
		Assertions.assert_not_equals(value_under_test, expected);
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
