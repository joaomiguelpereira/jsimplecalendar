package eu.jpereira.testfw.test;

import org.testng.annotations.Test;

import eu.jpereira.jsimplecalendar.testing.JUnitValueUnderTest;
import eu.jpereira.testfw.ValueUnderTest;

public class testing {

	@Test
	public void should_compare_equality() {

		Object dummy_object = Integer.valueOf(20);
		ValueUnderTest value_under_test = new JUnitValueUnderTest(dummy_object);
		
		value_under_test.should_be().greater().than(dummy_object);
		value_under_test.should_be().less().than(dummy_object);
		value_under_test.should_be().equals().to(dummy_object);
		value_under_test.should_be().different().than(dummy_object);
		
	}
}
