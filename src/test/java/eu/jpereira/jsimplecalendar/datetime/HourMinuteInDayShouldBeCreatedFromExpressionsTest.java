package eu.jpereira.jsimplecalendar.datetime;

import org.testng.annotations.Test;

import eu.jpereira.jsimplecalendar.datetime.exceptions.IllegalDateTimeComponentValueException;

import static org.testng.Assert.*;

public class HourMinuteInDayShouldBeCreatedFromExpressionsTest {

	@Test
	public void shouldCreateHourMinuteInDayWithValidExpressionWithoutZeroPrefixed() {
		testAllDayHoursWithoutPrefixes();
	}

	@Test
	public void shouldCreateMinuteInDayWithValidExpressionWithZeroPrefixes() {
		testAllDayHoursWithPrefixes();
	}

	@Test(expectedExceptions = IllegalDateTimeComponentValueException.class)
	public void shouldThrowExceptionIfMinutesAreNotGivenInExpression() {
		HourMinuteInDay.valueOf("1:");
	}

	@Test(expectedExceptions = IllegalDateTimeComponentValueException.class)
	public void shouldThrowExceptionIfHourIsNotGivenInExpression() {
		HourMinuteInDay.valueOf(":30");
	}

	@Test(expectedExceptions = IllegalDateTimeComponentValueException.class)
	public void shouldCreateHouMinuteInDayFromExpressionInUpperBoundary() {
		HourMinuteInDay.valueOf("24:00");

	}

	@Test(expectedExceptions = IllegalDateTimeComponentValueException.class)
	public void shouldThrowExceptionIfExpressionRepresentsOutOfRangeValue() {
		HourMinuteInDay.valueOf("-1:00");

	}

	/** Helpers**/
	private void testAllDayHoursWithPrefixes() {
		int hours = 24;
		int minutes = 60;

		for (int h = 0; h < hours; h++) {
			for (int m = 0; m < minutes; m++) {
				String testHour = prefixZero(h);
				String testMinute = prefixZero(m);

				String testData = testHour + ":" + testMinute;
				HourMinuteInDay dayTime = HourMinuteInDay.valueOf(testData);
				assertEquals(h, dayTime.getHour());
				assertEquals(m, dayTime.getMinute());
			}
		}
	}

	private String prefixZero(int h) {
		return (h < 10) ? ("0" + h) : "" + h;

	}

	private void testAllDayHoursWithoutPrefixes() {
		int hours = 24;
		int minutes = 60;

		for (int h = 0; h < hours; h++) {
			for (int m = 0; m < minutes; m++) {
				String testData = h + ":" + m;
				HourMinuteInDay dayTime = HourMinuteInDay.valueOf(testData);
				assertEquals(h, dayTime.getHour());
				assertEquals(m, dayTime.getMinute());
			}
		}
	}

}
