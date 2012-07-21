package eu.jpereira.jsimplecalendar.testing;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import eu.jpereira.testfw.ValueUnderTest;
import static org.testng.Assert.*;


@SuppressWarnings("rawtypes")
// TODO: How to tell that the user of this class needs to set the fixtures
// before running any test??
public abstract class AbstractComparableTest implements ObjectShouldBeComparableTest {

	// Fixtures used in the test
	protected Comparable value_under_test;

	protected Comparable value_expected_to_be_equals_to_value_under_test;
	protected Comparable another_value_expected_to_be_equal_to_value_under_test;

	protected Comparable value_expected_to_be_different_from_value_under_test;
	protected Comparable another_value_expected_to_be_different_from_value_under_test;

	protected Comparable value_expected_to_be_bigger;
	protected Comparable value_expected_to_be_even_bigger;

	protected Comparable value_expected_to_be_smaller_than_expected;
	protected Comparable value_expected_to_be_even_smaller_than_expected;

	protected int number_of_iterations_in_consitency_verification = 10;

	@BeforeTest
	public abstract void fixValues();

	@Override
	@Test
	public void should_have_the_reflexive_property_of_equality() {

		Object sameReferenceAsValueUnderTest = value_under_test;
		assertTrue(value_under_test.equals(sameReferenceAsValueUnderTest));

	}

	@Override
	@Test
	public void should_have_the_symetric_property_of_equality() {
		assertTrue(value_under_test.equals(value_expected_to_be_equals_to_value_under_test));
		assertTrue(value_expected_to_be_equals_to_value_under_test.equals(value_under_test));
	}

	@Override
	@Test
	public void should_have_the_transitive_property_of_equality() {
		// if a=b and b=c, then a=c
		assertTrue(value_under_test.equals(value_expected_to_be_equals_to_value_under_test));
		assertTrue(value_expected_to_be_equals_to_value_under_test.equals(another_value_expected_to_be_equal_to_value_under_test));
		assertTrue(value_under_test.equals(another_value_expected_to_be_equal_to_value_under_test));

	}

	@Override
	@Test
	public void should_follow_consitenty_contract_of_equality() {
		// For any a.equals(b), any number of sonsecutive calls will produce the
		// same result as last invocation, assuming no state in the object was
		// changed
		// This may be a nice to have verification
		for (int i = 0; i < number_of_iterations_in_consitency_verification; i++) {
			assertTrue(value_under_test.equals(value_expected_to_be_equals_to_value_under_test));
		}

	}

	@Override
	@Test
	public void should_follwo_non_null_with_null_responds_false_contract_of_equality() {
		assertFalse(value_under_test.equals(null));
	}

	@Override
	@Test
	public void should_respond_false_for_different_types() {
		assertFalse(value_under_test.equals(new Object()));
	}

	@Override
	@Test
	public void should_respond_false_for_different_values() {
		assertFalse(value_under_test.equals(value_expected_to_be_different_from_value_under_test));
	}

	@Override
	@Test
	public void should_have_the_transitive_property_of_inequality() {
		// if a!=b, and b!=c, then a!=c
		
		assertFalse(value_under_test.equals(value_expected_to_be_different_from_value_under_test));
		assertFalse(value_expected_to_be_different_from_value_under_test
		        .equals(another_value_expected_to_be_different_from_value_under_test));
		assertFalse(value_under_test.equals(another_value_expected_to_be_different_from_value_under_test));
	}
	
	private ValueUnderTest value_under_test() {
	    return new JUnitValueUnderTest(value_under_test);

    }
	

	@Override
	@Test
	public void shouldRespondWithSameHashCodeIfObjectsAreEquals() {
		assertEquals(value_under_test.hashCode(), value_expected_to_be_equals_to_value_under_test.hashCode());

	}

	@Override
	@Test
	public void shouldRespondDifferentHashCodesIfObjectAreNotEquals() {
		assertFalse(value_under_test.hashCode() == value_expected_to_be_different_from_value_under_test.hashCode());
	}

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void shoulRespondGreaterThanZeroWhenComparingWithSmallerValue() {

		assertTrue(value_under_test.compareTo(value_expected_to_be_smaller_than_expected) > 0);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void shouldRespondSmallerThanZeroWhenComparingWithBiggerValue() {
		assertTrue(value_under_test.compareTo(value_expected_to_be_bigger) < 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void shouldRespondZeroIfComparingWithEqualValue() {
		assertTrue(value_under_test.compareTo(value_expected_to_be_equals_to_value_under_test) == 0);

	}

	@SuppressWarnings("unchecked")
    @Override
	@Test
	/**
	 * If a < b and b < c , then a.compare(c) < 0. 
	 */
	public void should_have_first_transitive_property_of_inequality() {
		assertTrue(value_under_test.compareTo(value_expected_to_be_bigger) < 0);
		assertTrue(value_expected_to_be_bigger.compareTo(value_expected_to_be_even_bigger) < 0);
		assertTrue(value_under_test.compareTo(value_expected_to_be_even_bigger) < 0);
	}

	@SuppressWarnings("unchecked")
    @Override
	@Test
	public void shouldHaveSecondTransitivePropertyOfInequality() {
		assertTrue(value_under_test.compareTo(value_expected_to_be_smaller_than_expected) > 0);
		assertTrue(value_expected_to_be_smaller_than_expected.compareTo(value_expected_to_be_even_smaller_than_expected) > 0);
		assertTrue(value_under_test.compareTo(value_expected_to_be_even_smaller_than_expected) > 0);

	}

}
