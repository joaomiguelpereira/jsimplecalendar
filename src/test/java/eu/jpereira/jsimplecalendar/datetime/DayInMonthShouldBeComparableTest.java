package eu.jpereira.jsimplecalendar.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DayInMonthShouldBeComparableTest {

	@Test
	public void shouldVerifyReflexiveProertyOfEquals() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/12");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/11");
		assertFalse(dayOne.equals(dayTwo));
		assertFalse(dayTwo.equals(dayOne));
	}

	@Test
	public void shouldReturnTrueIfComparingTwoEqualReference() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("01/01");
		DayMonthInYear daywo = dayOne;
		assertTrue(dayOne.equals(daywo));
	}

	@Test
	public void shouldReturnFalseWhenCoparingWithNull() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/12");
		assertFalse(dayOne.equals(null));
	}

	@Test
	public void shouldReturnFalseWhenComparingTwoDifferentTypes() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/12");
		assertFalse(dayOne.equals(new Object()));
	}

	@Test
	public void shouldReturnFalseWhenComparingDifferentValues() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/12");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/12");
		assertEquals(0, dayOne.compareTo(dayTwo));
	}

	@Test
	public void shoulReturnGreaterThanZeroWhenComparingWithSomeDaysBefore() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/12");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("11/12");
		assertTrue(dayOne.compareTo(dayTwo) > 0);
	}

	@Test
	public void shouldReturnLessThanZeroWhenComparingWithSomeDaysAfter() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("9/12");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/12");
		assertTrue(dayOne.compareTo(dayTwo) < 0);

	}

	@Test
	public void shouldReturnLessThanZeroWhenComparingWithSomeMonthsAfter() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/11");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/12");
		assertTrue(dayOne.compareTo(dayTwo) < 0);
	}

	@Test
	public void shouldReturnMoreThanZeroWhenComparingWithSomeMonthsAfter() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("11/12");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/10");
		assertTrue(dayOne.compareTo(dayTwo) > 0);
	}

	@Test
	public void shouldReturnSameHashCodeWhenEqualsObject() {
		DayMonthInYear dayInMonth = DayMonthInYear.valueOf("01/02");
		DayMonthInYear dayInMonth_equals = DayMonthInYear.valueOf("01/02");
		assertEquals(dayInMonth.hashCode(), dayInMonth_equals.hashCode());
	}

	@Test
	public void shouldReturnDifferentHashCodeWhenDifferentObject() {
		DayMonthInYear dayInMonth = DayMonthInYear.valueOf("01/02");
		DayMonthInYear dayInMonth_equals = DayMonthInYear.valueOf("01/03");
		assertFalse(dayInMonth.hashCode() == dayInMonth_equals.hashCode());
	}
}
