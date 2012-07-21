package eu.jpereira.jsimplecalendar.testing;

import eu.jpereira.testfw.Comparsion;
import eu.jpereira.testfw.Expectation;

public class JUnitExpectation implements Expectation {
	
	private Object value_under_test;
	
	
	public JUnitExpectation(Object forValueUnderTest) {
		value_under_test = forValueUnderTest;
    }

	@Override
	public Comparsion greater() {

		return new JUnitGreatComparsion(value_under_test);
	}

	@Override
	public Comparsion less() {

		return new JUnitLessComparsion(value_under_test);
	}

	@Override
	public Comparsion equals() {
		return new JUnitEqualsComparsion(value_under_test);
	}

	@Override
	public Comparsion different() {

		return new JUnitDifferentComparsion(this);
	}


	public Object value_under_test() {
	    return value_under_test;
    }

}
