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

        List<MonthInYear> initialWorkingMonths = new ArrayList<MonthInYear>(12);
        initialWorkingMonths.addAll(Arrays.asList(MonthInYear.allMonths()));
        Map<String, MonthInYearExclusion> initialExceptionWorkingMonths = new HashMap<String, MonthInYearExclusion>();
        this.monthsInYearContainerUT = new MonthsInYearContainer(initialWorkingMonths, initialExceptionWorkingMonths);
    }
    
    
    @Test
    public void canCreateEmptyContainer() {
    	MonthsInYearContainer container = new MonthsInYearContainer();
    	assertEquals(0, container.getComponentCount());
    }
    @Test
    public void emptyContainerContainsZeroComponents() {
    	MonthsInYearContainer container = new MonthsInYearContainer();
    	assertFalse(container.contains(MonthInYear.valueOf("JANUARY")));
    }
    @Test
    public void canApplyCorrectExclusion() {
    	MonthsInYearContainer container = new MonthsInYearContainer();
    	container.addException(new MonthInYearExclusion("ExclusionName", MonthInYear.valueOf("JANUARY")));
    	container.addException(new MonthInYearExclusion("ExclusionName2", MonthInYear.valueOf("MARCH")));
    	
    	assertFalse(container.contains(MonthInYear.valueOf("JANUARY")));
    	assertFalse(container.contains(MonthInYear.valueOf("MARCH")));
    }
    public void canAddExclusions() {

        for (MonthInYear month : MonthInYear.allMonths()) {
            assertTrue(monthsInYearContainerUT.contains(month));
        }
        monthsInYearContainerUT.addException(new MonthInYearExclusion("Closing", MonthInYear.valueOf("JANUARY")));
        assertFalse(monthsInYearContainerUT.contains(MonthInYear.valueOf("JANUARY")));
    }

    @Test
    public void canRemoveExclusions() {

        for (MonthInYear month : MonthInYear.allMonths()) {
            assertTrue(monthsInYearContainerUT.contains(month));
        }
        monthsInYearContainerUT.addException(new MonthInYearExclusion("Closing", MonthInYear.valueOf("JANUARY")));
        assertFalse(monthsInYearContainerUT.contains(MonthInYear.valueOf("JANUARY")));
        monthsInYearContainerUT.removeException("Closing");
        assertTrue(monthsInYearContainerUT.contains(MonthInYear.valueOf("JANUARY")));

    }

    @Test
    public void canListExclusions() {

        for (MonthInYear month : MonthInYear.allMonths()) {
            assertTrue(monthsInYearContainerUT.contains(month));
        }
        assertEquals(0, monthsInYearContainerUT.getExclusions().size());
        monthsInYearContainerUT.addException(new MonthInYearExclusion("Closing", MonthInYear.valueOf("JANUARY")));
        assertEquals(1, monthsInYearContainerUT.getExclusions().size());

    }

}
