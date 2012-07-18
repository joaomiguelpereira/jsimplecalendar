package eu.jpereira.jsimplecalendar.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Test;

import eu.jpereira.jsimplecalendar.testing.ObjectShouldBeComparableTest;

@SuppressWarnings("rawtypes")
public class DayMonthInYearShouldBeComparableTest implements ObjectShouldBeComparableTest {

	// Fixtures used in the tests
	private Comparable valueUnderTest = DayMonthInYear.valueOf("12/12");
	private Comparable valueExpectedToBeEqualAsValueUnderTest = DayMonthInYear.valueOf("12/12");
	private Comparable anotherValueExpectedToBeEqualToValueUnderTest = DayMonthInYear.valueOf("12/12");

	private Comparable valueExpectedToBeDifferentFromValueUnderTest = DayMonthInYear.valueOf("01/01");
	private Comparable anotherValueExpectedToBeDifferentFromValueUnderTest = DayMonthInYear.valueOf("02/01");;

	private Comparable valueExpectedToBeBiggerThanExpected = DayMonthInYear.valueOf("15/12");
	private Comparable valueExpectedToBeSmallerThanExpected = DayMonthInYear.valueOf("11/12");;

	@Override
	@Test
	public void shouldHaveTheReflexivePropertyOfEquality() {

		Object sameReferenceAsValueUnderTest = valueUnderTest;
		assertTrue(valueUnderTest.equals(sameReferenceAsValueUnderTest));

	}

	@Override
	@Test
	public void shouldHaveTheSymetricPropertyOfEquality() {
		assertTrue(valueUnderTest.equals(valueExpectedToBeEqualAsValueUnderTest));
		assertTrue(valueExpectedToBeEqualAsValueUnderTest.equals(valueUnderTest));
	}

	@Override
	@Test
	public void shouldHaveTheTransitivePropertyOfEquality() {
		// if a=b and b=c, then a=c
		assertTrue(valueUnderTest.equals(valueExpectedToBeEqualAsValueUnderTest));
		assertTrue(valueExpectedToBeEqualAsValueUnderTest.equals(anotherValueExpectedToBeEqualToValueUnderTest));
		assertTrue(valueUnderTest.equals(anotherValueExpectedToBeEqualToValueUnderTest));

	}

	@Override
	@Test
	public void shouldFollowConsitentyContractOfEquality() {
		// For any a.equals(b), any number of sonsecutive calls will produce the
		// same result as last invocation, assuming no state in the object was
		// changed
		// This may be a nice to have verification
		for (int i = 0; i < 10; i++) {
			assertTrue(valueUnderTest.equals(valueExpectedToBeEqualAsValueUnderTest));
		}

	}

	@Override
	@Test
	public void shouldFollwoNonNullWithNulRespondeFalseContractOfEquality() {
		assertFalse(valueUnderTest.equals(null));
	}

	@Override
	@Test
	public void shouldRespondFalseForDifferentTypes() {
		assertFalse(valueUnderTest.equals(new Object()));
	}

	@Override
	@Test
	public void shouldRespondFalseForDifferentValues() {
		assertFalse(valueUnderTest.equals(valueExpectedToBeDifferentFromValueUnderTest));
	}

	@Override
	@Test
	public void shouldHaveTheTransitivePropertyOfInequality() {
		// if a!=b, and b!=c, then a!=c
		assertFalse(valueUnderTest.equals(valueExpectedToBeDifferentFromValueUnderTest));
		assertFalse(valueExpectedToBeDifferentFromValueUnderTest
		        .equals(anotherValueExpectedToBeDifferentFromValueUnderTest));
		assertFalse(valueUnderTest.equals(anotherValueExpectedToBeDifferentFromValueUnderTest));
	}

	@Override
	@Test
	public void shouldRespondWithSameHashCodeIfObjectsAreEquals() {
		assertEquals(valueUnderTest.hashCode(), valueExpectedToBeEqualAsValueUnderTest.hashCode());

	}

	@Override
	@Test
	public void shouldRespondDifferentHashCodesIfObjectAreNotEquals() {
		assertFalse(valueUnderTest.hashCode() == valueExpectedToBeDifferentFromValueUnderTest.hashCode());
	}

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void shoulRespondGreaterThanZeroWhenComparingWithSmallerValue() {

		assertTrue(valueUnderTest.compareTo(valueExpectedToBeBiggerThanExpected) > 0);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void shouldRespondSmallerThanZeroWhenComparingWithGreaterValue() {
		assertTrue(valueUnderTest.compareTo(valueExpectedToBeSmallerThanExpected) < 0);
	}

	@Override
	@Test
	public void shouldRespondZeroIfComparingWithEqualValue() {
		Assert.fail("Not implemented");

	}

	@Override
	@Test
	public void shouldHaveFirstTransitivePropertyOfInequality() {
		Assert.fail("Not implemented");

	}

	@Override
	@Test
	public void shouldHaveSecondTransitivePropertyOfInequality() {
		Assert.fail("Not implemented");

	}

	/** More specific behavior to implement */
	@Test
	public void shouldRespondLessThanZeroWhenComparingWithSomeMonthsAfter() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/11");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/12");
		assertTrue(dayOne.compareTo(dayTwo) < 0);
	}

	@Test
	public void shouldRespondMoreThanZeroWhenComparingWithSomeMonthsAfter() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("11/12");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/10");
		assertTrue(dayOne.compareTo(dayTwo) > 0);
	}

}
