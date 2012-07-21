package eu.jpereira.jsimplecalendar.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import eu.jpereira.testfw.Comparsion;

public class JUnitGreatComparsion implements Comparsion {

	private Object value_under_test;

	public JUnitGreatComparsion(Object jUnitExpectation) {
		value_under_test = jUnitExpectation;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Test
	public void than(Object expected) {
		// Cast for Comparable
		Assertions.assert_are_of_type(Comparable.class, value_under_test, expected);

		Comparable a = (Comparable) value_under_test;
		Comparable b = (Comparable) expected;
		Assert.assertTrue(a.compareTo(b) > 0);

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
