package eu.jpereira.jsimplecalendar.datetime.containers;

import org.testng.annotations.Test;

import eu.jpereira.jsimplecalendar.datetime.DayMonthInYear;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DayMonthInYearExclusion;

import static org.testng.Assert.*;
//TODO: Complete
public class DayMonthInYearContainerTest {

	private DayMonthInYearContainer containerUT = DayMonthInYearContainer.newContainer();

	/** Component inclusions */

	@Test
	public void everyDayMonthIsIncludedByDefault() {
		assertTrue(this.containerUT.contains(DayMonthInYear.valueOf("12/12")));
	}

	/** Component exclusions */

	@Test
	public void canExcludeDayInMonth() {
		this.containerUT.addExclusion(DayMonthInYearExclusion.valueOf("test exclusion", "12/12"));
		assertFalse(this.containerUT.contains(DayMonthInYear.valueOf("12/12")));
	}

	@Test
	public void canExcludeMultipleDayInMonth() {
		testExclusionBoundaries();

		this.containerUT.addExclusion(DayMonthInYearExclusion.valueOf("test exclusion", "12/12"));
		this.containerUT.addExclusion(DayMonthInYearExclusion.valueOf("test exclusion 2", "13/12"));
		this.containerUT.addExclusion(DayMonthInYearExclusion.valueOf("test exclusion 3", "14/12"));
		assertTrue(this.containerUT.contains(DayMonthInYear.valueOf("11/12")));
		assertFalse(this.containerUT.contains(DayMonthInYear.valueOf("12/12")));
		assertFalse(this.containerUT.contains(DayMonthInYear.valueOf("13/12")));
		assertFalse(this.containerUT.contains(DayMonthInYear.valueOf("14/12")));
		assertTrue(this.containerUT.contains(DayMonthInYear.valueOf("15/12")));
	}

	private void testExclusionBoundaries() {

	}

	@Test
	public void canRemoveExclusions() {
		
		this.containerUT.addExclusion(DayMonthInYearExclusion.valueOf("test exclusion", "12/12"));
		assertFalse(this.containerUT.contains(DayMonthInYear.valueOf("12/12")));
		this.containerUT.removeExclusion("test exclusion");
		assertTrue(this.containerUT.contains(DayMonthInYear.valueOf("12/12")));
		//
	}

	/** Creational Behavior **/

	@Test
	public void canCreateEmptyContainer() {
		assertEquals(0, containerUT.getComponentCount());
		assertEquals(0, containerUT.getExclusions().size());
	}

}
