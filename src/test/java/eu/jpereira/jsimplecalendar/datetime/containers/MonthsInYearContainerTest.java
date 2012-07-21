package eu.jpereira.jsimplecalendar.datetime.containers;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import eu.jpereira.jsimplecalendar.datetime.MonthInYear;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.MonthInYearExclusion;

import static org.testng.Assert.*;

public class MonthsInYearContainerTest {

	private MonthsInYearContainer monthsInYearContainerUT;

	@BeforeTest
	public void setup() {
		this.monthsInYearContainerUT = MonthsInYearContainer.newContainerWithComponents(MonthInYear.allMonths());
	}

	@Test
	public void canCreateFullContainer() {
		assertEquals(12, monthsInYearContainerUT.getComponentCount());
	}

	@Test
	public void canApplyCorrectExclusion() {

		monthsInYearContainerUT.addExclusion(MonthInYearExclusion.valueOf("ExclusionName",
		        MonthInYear.valueOf("JANUARY")));
		monthsInYearContainerUT.addExclusion(MonthInYearExclusion.valueOf("ExclusionName2",
		        MonthInYear.valueOf("MARCH")));

		assertFalse(monthsInYearContainerUT.contains(MonthInYear.valueOf("JANUARY")));
		assertFalse(monthsInYearContainerUT.contains(MonthInYear.valueOf("MARCH")));
	}

	public void canAddExclusions() {

		for (MonthInYear month : MonthInYear.allMonths()) {
			assertTrue(monthsInYearContainerUT.contains(month));
		}
		monthsInYearContainerUT.addExclusion(MonthInYearExclusion.valueOf("Closing", MonthInYear.valueOf("JANUARY")));
		assertFalse(monthsInYearContainerUT.contains(MonthInYear.valueOf("JANUARY")));
	}

	@Test
	public void canRemoveExclusions() {

		for (MonthInYear month : MonthInYear.allMonths()) {
			assertTrue(monthsInYearContainerUT.contains(month));
		}
		monthsInYearContainerUT.addExclusion(MonthInYearExclusion.valueOf("Closing", MonthInYear.valueOf("JANUARY")));
		assertFalse(monthsInYearContainerUT.contains(MonthInYear.valueOf("JANUARY")));
		monthsInYearContainerUT.removeExclusion("Closing");
		assertTrue(monthsInYearContainerUT.contains(MonthInYear.valueOf("JANUARY")));

	}

	@Test
	public void canListExclusions() {

		for (MonthInYear month : MonthInYear.allMonths()) {
			assertTrue(monthsInYearContainerUT.contains(month));
		}
		assertEquals(0, monthsInYearContainerUT.getExclusions().size());
		monthsInYearContainerUT.addExclusion(MonthInYearExclusion.valueOf("Closing", MonthInYear.valueOf("JANUARY")));
		assertEquals(1, monthsInYearContainerUT.getExclusions().size());

	}

}
