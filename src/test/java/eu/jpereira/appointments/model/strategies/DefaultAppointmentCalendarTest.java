package eu.jpereira.appointments.model.strategies;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import eu.jpereira.appointments.model.AppointmentDate;
import eu.jpereira.appointments.model.data.AppointmentSpecification;
import eu.jpereira.appointments.model.strategies.AppointmentCalendarStrategy;
import eu.jpereira.appointments.model.strategies.DefaultAppointmentCalendarStrategy;
import eu.jpereira.testfw.DateUtils;

public class DefaultAppointmentCalendarTest {

    @Test
    public void knowItsInTheFuture() {

        AppointmentCalendarStrategy strategy = new DefaultAppointmentCalendarStrategy(DateUtils.getToday());

        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getTomorrow()), 12,
                00, 30);

        assertTrue(strategy.isFuture(spec));

    }

    @Test
    public void knowItsInTheFutureWithAppointmentSameDay() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date baselineDate = calendar.getTime();

        AppointmentCalendarStrategy strategy = new DefaultAppointmentCalendarStrategy(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertTrue(strategy.isFuture(spec));

    }

    @Test
    public void knowItsInTheFutureWithAppointmentSameDayEdgeStartHour() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 59);
        Date baselineDate = calendar.getTime();

        AppointmentCalendarStrategy strategy = new DefaultAppointmentCalendarStrategy(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertTrue(strategy.isFuture(spec));

    }

    @Test
    public void knowAppointmentIsToday() {
        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getToday());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        Date baselineDate = calendar.getTime();

        AppointmentCalendarStrategy strategy = new DefaultAppointmentCalendarStrategy(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertTrue(strategy.isToday(spec));
    }



    @Test
    public void knowAppointmentIsNotToday() {
        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getTomorrow());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        Date baselineDate = calendar.getTime();

        AppointmentCalendarStrategy strategy = new DefaultAppointmentCalendarStrategy(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertFalse(strategy.isToday(spec));
    }


    @Test
    public void knowAppointmentIsThePast() {
        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getToday());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        Date baselineDate = calendar.getTime();

        AppointmentCalendarStrategy strategy = new DefaultAppointmentCalendarStrategy(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getYesterday()), 12,
                00, 30);

        assertTrue(strategy.isPast(spec));
    }

    @Test
    public void knowAppointmentIsThePasSameDayt() {
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);
        AppointmentCalendarStrategy strategy = buildCalendarStrategy(DateUtils.getTomorrow(), 13, 0);
        assertTrue(strategy.isPast(spec));
    }

    @Test
    public void elapsedZeroDaysSinceAppointmentDay() {
        AppointmentCalendarStrategy strategy = buildCalendarStrategy(DateUtils.getToday(), 12, 31);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);
        assertEquals(0, strategy.getElapsedDays(spec));
        
    }
    

    @Test
    @Ignore
    public void elapsedTenDaysSinceAppointmentDay() {
        AppointmentCalendarStrategy strategy = buildCalendarStrategy(DateUtils.getToday(), 12, 31);
        
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);
        assertEquals(10, strategy.getElapsedDays(spec));
        
    }
   
    private AppointmentCalendarStrategy buildCalendarStrategy(Date date, int hour, int minute) {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        Date baselineDate = calendar.getTime();

        return new DefaultAppointmentCalendarStrategy(baselineDate);

    }

}
