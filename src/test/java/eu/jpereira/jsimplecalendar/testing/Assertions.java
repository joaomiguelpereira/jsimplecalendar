package eu.jpereira.jsimplecalendar.testing;

import org.testng.Assert;

public class Assertions {

	public static void assert_are_of_type(Class expected_type, Object... objects) {

		for (Object object : objects) {

			if (!object.getClass().isInstance(expected_type)) {
				Assert.fail(String.format("Expecting type [%s] GOT [%s]", expected_type, object.getClass()));
			}
		}

	}

	public static void assert_are_equals(Object... objects) {

		int current_position = 0;
		for (Object object : objects) {

			if (current_position + 1 < objects.length) {
				if (!object.equals(objects[current_position++])) {
					Assert.fail(String.format("Expecting [%s] GOT [%s]", object, objects[--current_position]));
				}
			}
		}

	}

	public static void assert_not_equals(Object...objects) {

		int current_position = 0;
		for (Object object : objects) {

			if (current_position + 1 < objects.length) {
				if (object.equals(objects[current_position++])) {
					Assert.fail(String.format("Expecting [%s] AND [%s] to be DIFFERENT", object, objects[--current_position]));
				}
			}
		}
	    
	    
    }

	public static void assert_are_naturally_ordered(Object evalue_under_test, Object expected) {
	  Assert.fail("Not implemeted");
	    
    }

}
