package eu.jpereira.appointments.model.calendar;

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

import eu.jpereira.appointments.model.calendar.datetime.MonthException;
import eu.jpereira.jsimplecalendar.datetime.MonthInYear;

public class WorkingMonthsTest {

    private WorkingMonths testWorkingMonths;

    @Before
    public void setup() {

        List<MonthInYear> initialWorkingMonths = new ArrayList<MonthInYear>(12);
        initialWorkingMonths.addAll(Arrays.asList(MonthInYear.allMonths()));
        Map<String, MonthException> initialExceptionWorkingMonths = new HashMap<String, MonthException>();
        this.testWorkingMonths = new WorkingMonths(initialWorkingMonths, initialExceptionWorkingMonths);
    }

    @Test
    public void canAddMonthsExceptions() {

        for (MonthInYear month : MonthInYear.allMonths()) {
            assertTrue(testWorkingMonths.contains(month));
        }
        testWorkingMonths.addException(new MonthException("Closing", MonthInYear.valueOf("JANUARY")));
        assertFalse(testWorkingMonths.contains(MonthInYear.valueOf("JANUARY")));
    }

    @Test
    public void canRemoveMonthsExceptions() {

        for (MonthInYear month : MonthInYear.allMonths()) {
            assertTrue(testWorkingMonths.contains(month));
        }
        testWorkingMonths.addException(new MonthException("Closing", MonthInYear.valueOf("JANUARY")));
        assertFalse(testWorkingMonths.contains(MonthInYear.valueOf("JANUARY")));
        testWorkingMonths.removeException("Closing");
        assertTrue(testWorkingMonths.contains(MonthInYear.valueOf("JANUARY")));

    }

    @Test
    public void canListMonthsExceptions() {

        for (MonthInYear month : MonthInYear.allMonths()) {
            assertTrue(testWorkingMonths.contains(month));
        }
        assertEquals(0, testWorkingMonths.getExceptions().size());
        testWorkingMonths.addException(new MonthException("Closing", MonthInYear.valueOf("JANUARY")));
        assertEquals(1, testWorkingMonths.getExceptions().size());

    }

}
