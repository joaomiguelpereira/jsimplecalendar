package eu.jpereira.jsimplecalendar.datetime;

import org.testng.annotations.BeforeTest;

import eu.jpereira.jsimplecalendar.testing.AbstractComparableTest;

public class HourMinuteInDayShouldBeComparable extends AbstractComparableTest {

	@Override
	@BeforeTest
	public void fixValues() {
		// Fixtures used in the tests
		value_under_test = HourMinuteInDay.valueOf("09:57");

		value_expected_to_be_equals_to_value_under_test = DayMonthInYear.valueOf("12/12");	
		another_value_expected_to_be_equal_to_value_under_test = DayMonthInYear.valueOf("12/12");

		value_expected_to_be_different_from_value_under_test = DayMonthInYear.valueOf("01/01");
		another_value_expected_to_be_different_from_value_under_test = DayMonthInYear.valueOf("02/01");

		value_expected_to_be_bigger = DayMonthInYear.valueOf("15/12");
		value_expected_to_be_even_bigger= DayMonthInYear.valueOf("16/12");

		value_expected_to_be_smaller_than_expected = DayMonthInYear.valueOf("11/12");
		value_expected_to_be_even_smaller_than_expected = DayMonthInYear.valueOf("10/12");

	}

}
