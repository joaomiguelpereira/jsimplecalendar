package eu.jpereira.testfw;

import org.testng.annotations.Test;

public interface Comparsion {

	@Test
	void than(Object dummy_object);

	@Test
	void to(Object dummy_object);

	@Test
	void of(Object dummy_object);

}
