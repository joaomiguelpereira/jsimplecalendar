package eu.jpereira.jsimplecalendar.datetime;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import eu.jpereira.jsimplecalendar.datetime.exceptions.IllegalDateTimeComponentValueException;



public class MonthInYearTest {

	
	@Test
	public void testAllValidValues() {
		for ( MonthInYear month : MonthInYear.allMonths() ) {
			MonthInYear.valueOf(month.toString());
		}
	}
	
	@Test(expectedExceptions=IllegalDateTimeComponentValueException.class)
	public void testInvaldiValues() throws Throwable{
		MonthInYear.valueOf("invalid");
		
	}
	
	@Test
	public void testEqualsReflexive() {
		MonthInYear m1 = MonthInYear.valueOf("JANUARY");
		assertTrue(m1.equals(m1));
	}
	@Test
	public void testEqualsSymetric() {
		MonthInYear m1 = MonthInYear.valueOf("JANUARY");
		MonthInYear m2 = MonthInYear.valueOf("JANUARY");
		assertTrue(m1.equals(m2) && m2.equals(m1));
	}
	@Test
	public void testEqualsTransitive() {
		MonthInYear m1 = MonthInYear.valueOf("JANUARY");
		MonthInYear m2 = MonthInYear.valueOf("JANUARY");
		MonthInYear m3 = MonthInYear.valueOf("JANUARY");
		assertTrue(m1.equals(m2) && m2.equals(m3) && m1.equals(m3));

	}
	
	@Test
	public void testEqualsNull() {
		MonthInYear m1 = MonthInYear.valueOf("JANUARY");
		assertFalse(m1.equals(null));
	}

	@Test
	public void testEqualsDifferentValue() {
		MonthInYear m1 = MonthInYear.valueOf("JANUARY");
		MonthInYear m2 = MonthInYear.valueOf("MARCH");
		assertFalse(m1.equals(m2));
	}


	@Test
	public void testEqualsDifferentType() {
		MonthInYear m1 = MonthInYear.valueOf("JANUARY");
		assertFalse(m1.equals(new Object()));
	}


	@Test
	public void testHashCode() {
		MonthInYear m1 = MonthInYear.valueOf("JANUARY");
		MonthInYear m2 = MonthInYear.valueOf("JANUARY");
		assertTrue(m1.hashCode() == m2.hashCode());
	}

}
