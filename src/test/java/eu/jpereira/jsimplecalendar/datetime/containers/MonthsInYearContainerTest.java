package eu.jpereira.jsimplecalendar.datetime.containers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.jsimplecalendar.datetime.MonthInYear;
import eu.jpereira.jsimplecalendar.datetime.containers.MonthsInYearContainer;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.MonthInYearExclusion;

public class MonthsInYearContainerTest {

    private MonthsInYearContainer monthsInYearContainerUT;

    @Before
    public void setup() {
        this.monthsInYearContainerUT = MonthsInYearContainer.newContainerWithComponents(MonthInYear.allMonths());
    }
    
    
    @Test
    public void canCreateFullContainer() {
    	assertEquals(12, monthsInYearContainerUT.getComponentCount());
    }
    
    
    @Test
    public void canApplyCorrectExclusion() {

    	monthsInYearContainerUT.addExclusion(MonthInYearExclusion.valueOf("ExclusionName", MonthInYear.valueOf("JANUARY")));
    	monthsInYearContainerUT.addExclusion(MonthInYearExclusion.valueOf("ExclusionName2", MonthInYear.valueOf("MARCH")));
    	
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
