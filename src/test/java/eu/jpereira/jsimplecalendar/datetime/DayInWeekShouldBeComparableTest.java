package eu.jpereira.jsimplecalendar.datetime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class DayInWeekShouldBeComparableTest {

	@Test
	public void shouldRespectSimetricPropertyOfEquality() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		DayInWeek d2 = DayInWeek.valueOf("SUNDAY");
		assertTrue(d1.equals(d2));
		assertTrue(d2.equals(d1));

	}

	@Test
	public void shouldRespectReflexivePropertyOfEquality() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		assertTrue(d1.equals(d1));
	}

	@Test
	public void shouldRespectTransitivityPropertyOfEquality() {

		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		DayInWeek d2 = DayInWeek.valueOf("SUNDAY");
		DayInWeek d3 = DayInWeek.valueOf("SUNDAY");
		assertTrue(d1.equals(d2) && d2.equals(d3) && d1.equals(d3));

	}

	@Test
	public void shouldNeveBeEqualToNull() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		assertFalse(d1.equals(null));
	}

	@Test
	public void shoulReturnFalseWithDifferentValues() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		assertFalse(d1.equals(DayInWeek.valueOf("MONDAY")));
	}

	@Test
	public void shoulReturnFalseWithDifferentTypes() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		assertFalse(d1.equals(new Object()));
	}

	@Test
	public void shouldReturnSameHashCodeAsEqualValue() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		DayInWeek d2 = DayInWeek.valueOf("SUNDAY");

		assertTrue(d1.hashCode() == d2.hashCode());

	}

	@Test
	public void shouldReturnDifferentHashcodeThanDifferentValue() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		DayInWeek d2 = DayInWeek.valueOf("WEDNESDAY");

		assertTrue(d1.hashCode() != d2.hashCode());

	}

}
