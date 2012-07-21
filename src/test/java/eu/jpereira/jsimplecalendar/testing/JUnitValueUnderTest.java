package eu.jpereira.jsimplecalendar.testing;

import eu.jpereira.testfw.ValueUnderTest;
import eu.jpereira.testfw.Expectation;

public class JUnitValueUnderTest implements ValueUnderTest {

	private Object value_under_test;

	public JUnitValueUnderTest(Object other_value_under_test) {
		this.value_under_test = other_value_under_test;
	}

	@Override
    public Expectation should_be() {
		
	    return new JUnitExpectation(value_under_test);
    }

	

}
