package eu.jpereira.appointments.model.strategies;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import eu.jpereira.appointments.model.AppointmentDate;
import eu.jpereira.appointments.model.data.AppointmentSpecification;
import eu.jpereira.testfw.DateUtils;
import static org.junit.Assert.*;

public class DefaultAppointmentClockStrategyTest {

    @Test
    public void canGetMinutesPastSinceStart() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getToday());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 31);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = buildStrategyUT(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertEquals(31, comparator.getElapsedMinutesSinceStart(spec));
    }

    @Test
    public void canGetMinutesPastSinceStartEdge() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getToday());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 30);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = buildStrategyUT(baselineDate);

        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertEquals(30, comparator.getElapsedMinutesSinceStart(spec));
    }

    @Test
    public void canGetMinutesPastSinceStartUpper() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getToday());
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 30);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = buildStrategyUT(baselineDate);

        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertEquals(90, comparator.getElapsedMinutesSinceStart(spec));
    }

    @Test
    public void canGetMinutesElapsedMinutesSinceStartBeforeHapenning() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getToday());
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 30);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = buildStrategyUT(baselineDate);

        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertEquals(-30, comparator.getElapsedMinutesSinceStart(spec));
    }

    private DefaultAppointmentClockStrategy buildStrategyUT(Date baselineDate) {
        return new DefaultAppointmentClockStrategy(baselineDate);
    }

    @Test
    public void appointmentHasTeminatedLessThanAnHourAgo() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getToday());
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 00);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = buildStrategyUT(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                15);

        assertEquals(45, comparator.getElapsedMinutesSinceEnd(spec));
    }

    @Test
    public void appointmentHasTeminatedMoreThanAnHourAgo() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getToday());
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 15);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = buildStrategyUT(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                15);

        assertEquals(60, comparator.getElapsedMinutesSinceEnd(spec));
    }

    @Test
    public void appointmentWillNowAnEnd() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getToday());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 15);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = buildStrategyUT(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                15);

        assertEquals(0, comparator.getElapsedMinutesSinceEnd(spec));
    }

    @Test
    public void appointmentWillEventuallyEnd() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getToday());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 00);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = buildStrategyUT(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                15);

        assertEquals(-15, comparator.getElapsedMinutesSinceEnd(spec));
    }

    @Test
    public void knowAppointmentIsHappeningInStartHour() {
        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getToday());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = new DefaultAppointmentClockStrategy(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertTrue(comparator.isHappening(spec));
    }

    @Test
    public void knowAppointmentIsNowInEndHour() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 30);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = new DefaultAppointmentClockStrategy(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertTrue(comparator.isHappening(spec));

    }

    @Test
    public void knowAppointmentIsNowInMiddleHour() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 15);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = new DefaultAppointmentClockStrategy(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertTrue(comparator.isHappening(spec));

    }

    @Test
    public void knowAppointmentIsNotNowInStartHour() {
        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getTomorrow());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        Date baselineDate = calendar.getTime();
        AppointmentClockStrategy comparator = new DefaultAppointmentClockStrategy(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertFalse(comparator.isHappening(spec));
    }

    @Test
    public void knowAppointmentIsNotNowInEndHour() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getYesterday());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 30);
        Date baselineDate = calendar.getTime();
        AppointmentClockStrategy comparator = new DefaultAppointmentClockStrategy(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertFalse(comparator.isHappening(spec));

    }

    @Test
    public void knowAppointmentIsNotNowInMiddleHour() {

        // Create a dummy baselineDateTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.getYesterday());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 15);
        Date baselineDate = calendar.getTime();

        AppointmentClockStrategy comparator = new DefaultAppointmentClockStrategy(baselineDate);
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), 12, 00,
                30);

        assertFalse(comparator.isHappening(spec));
    }

}
