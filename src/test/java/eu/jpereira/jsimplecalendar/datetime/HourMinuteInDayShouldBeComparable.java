package eu.jpereira.jsimplecalendar.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.jpereira.jsimplecalendar.testing.ObjectShouldBeComparableTest;

public class HourMinuteInDayShouldBeComparable implements ObjectShouldBeComparableTest{

	@Test
	public void testEquals() {
		HourMinuteInDay d1 = HourMinuteInDay.valueOf("9:00");
		HourMinuteInDay d2 = HourMinuteInDay.valueOf("09:00");
		assertTrue(d1.equals(d2));
		assertTrue(d2.equals(d1));

		assertFalse(d2.equals(HourMinuteInDay.valueOf("09:01")));
		assertFalse(d2.equals(null));

	}

	@Test
	public void testGreater() {
		HourMinuteInDay d1 = HourMinuteInDay.valueOf("9:00");
		HourMinuteInDay d2 = HourMinuteInDay.valueOf("9:01");

		assertTrue(d1.compareTo(d2) < 0);
		assertTrue(d2.compareTo(d1) > 0);

		assertEquals(d1.compareTo(d2), d2.compareTo(d1) * -1);

		assertTrue(d1.compareTo(HourMinuteInDay.valueOf("09:00")) == 0);

	}

	@Override
    public void shouldHaveTheReflexivePropertyOfEquality() {
	    HourMinuteInDay hourMinuteInDayUT = HourMinuteInDay.valueOf("12:17");
	    HourMinuteInDay otherHourMinuteInDayUT = hourMinuteInDayUT;
	    assertTrue(hourMinuteInDayUT.equals(otherHourMinuteInDayUT));
	    
    }

	@Override
    public void shouldHaveTheSymetricPropertyOfEquality() {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public void shouldRespondFalseIfComparingNull() {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public void shouldRespondFalseIfComparingTwoDifferentTypes() {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public void shouldRespondFalseIfComparingDifferentValues() {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public void shoulRespondGreaterThanZeroWhenComparingWithLowerValue() {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public void shouldRespondLessThanZeroWhenComparingWithHigerValue() {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public void shouldRespondWithSameHashCodeIfObjectIsEqual() {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public void shouldRespondDifferentHashCodesIfObjectAreDifferent() {
	    // TODO Auto-generated method stub
	    
    }

}
