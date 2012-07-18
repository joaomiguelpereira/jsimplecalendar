package eu.jpereira.jsimplecalendar.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.jpereira.jsimplecalendar.testing.ObjectShouldBeComparableTest;

@SuppressWarnings("rawtypes")
public class DayMonthInYearShouldBeComparableTest implements ObjectShouldBeComparableTest {

	
    private Comparable valueUnderTest = DayMonthInYear.valueOf("12/12");
	private Comparable valueExpectedToBeEqualAsValueUnderTest = DayMonthInYear.valueOf("12/12");
	private Comparable anotherValueExpectedToBeEqualToValueUnderTest;
	private Comparable valueExpectedToBeDifferentFromValueUnderTest;
	private Comparable anotherValueExpectedToBeDifferentFromValueUnderTest;

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
	public void shouldHaveTheTransitivePropertyOfEquality() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shouldFollowConsitentyContractOfEquality() {
		// TODO Auto-generated method stub

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
	public void shouldRespondFalseForDifferentValues() {
		assertFalse(valueUnderTest.equals(valueExpectedToBeDifferentFromValueUnderTest));
	}

	@Override
	public void shouldHaveTheTransitivePropertyOfInequality() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shouldRespondWithSameHashCodeIfObjectsAreEquals() {
		assertEquals(valueUnderTest.hashCode(), valueExpectedToBeEqualAsValueUnderTest.hashCode());

	}

	@Override
	public void shouldRespondDifferentHashCodesIfObjectAreNotEquals() {
		assertFalse(valueUnderTest.hashCode() == valueExpectedToBeDifferentFromValueUnderTest.hashCode());
	}

	@Override
	public void shoulRespondGreaterThanZeroWhenComparingWithSmallerValue() {

		assertTrue(valueUnderTest.compareTo(valueExpectedToBeBiggerThanExpected) > 0);

	}

	@Override
	public void shouldRespondSmallerThanZeroWhenComparingWithGreaterValue() {
		assertTrue(valueUnderTest.compareTo(valueExpectedToBeSmallerThanExpected) < 0);
	}

	@Override
	public void shouldRespondZeroIfComparingWithEqualValue() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shouldHaveFirstTransitivePropertyOfInequality() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shouldHaveSecondTransitivePropertyOfInequality() {
		// TODO Auto-generated method stub

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
