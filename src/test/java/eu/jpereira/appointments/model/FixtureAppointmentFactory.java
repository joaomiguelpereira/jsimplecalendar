package eu.jpereira.appointments.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.jpereira.appointments.model.data.AppointmentSpecification;
import eu.jpereira.appointments.model.filters.TimeSlotFilter;
import eu.jpereira.appointments.model.strategies.AppointmentCalendarStrategy;
import eu.jpereira.appointments.model.strategies.AppointmentClockStrategy;
import eu.jpereira.appointments.model.strategies.DefaultAppointmentCalendarStrategy;
import eu.jpereira.appointments.model.strategies.DefaultAppointmentClockStrategy;


public class FixtureAppointmentFactory {

    static Appointment getAppointment() {
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(new Date()), 0, 0, 30);
        
        Date baseLineDate = new Date();
        AppointmentCalendarStrategy comparatorStrategy = new DefaultAppointmentCalendarStrategy(baseLineDate);
        AppointmentClockStrategy clockStrategy = new DefaultAppointmentClockStrategy(baseLineDate);
        return new Appointment(spec, comparatorStrategy, clockStrategy);
        
        
    }

    static Appointment getAppointment(Date date) {
        
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(date), 0, 0, 30);
      
        Date baseLineDate = new Date();
        AppointmentCalendarStrategy comparatorStrategy = new DefaultAppointmentCalendarStrategy(baseLineDate);
        AppointmentClockStrategy clockStrategy = new DefaultAppointmentClockStrategy(baseLineDate);
        return new Appointment(spec, comparatorStrategy, clockStrategy);
      
    }

    static Appointment getAppointment(AppointmentSpecification spec) {
        
        Date baseLineDate = new Date();
        AppointmentCalendarStrategy comparatorStrategy = new DefaultAppointmentCalendarStrategy(baseLineDate);
        AppointmentClockStrategy clockStrategy = new DefaultAppointmentClockStrategy(baseLineDate);
        return new Appointment(spec, comparatorStrategy, clockStrategy);
      
        
    }
    static void buildNAppointmentsAndAddToCalendar(int i, DefaultCalendar calendar) {

        for (int c = 0; c < i; c++) {
            Appointment appointment = FixtureAppointmentFactory.getAppointment();
            calendar.schedule(appointment);
        }

    }

    public static List<Appointment> buildNAppointmentsForFilter(int numberOfAppointments, TimeSlotFilter filter) {
        List<Appointment> appointments = new ArrayList<Appointment>();
        
        java.util.Calendar utilCalendar = java.util.Calendar.getInstance();

        int year = filter.getYear() != -1 ? filter.getYear() : utilCalendar.get(java.util.Calendar.YEAR);
        int month = filter.getMonth() != -1 ? filter.getMonth() : utilCalendar.get(java.util.Calendar.MONTH);
        int day = filter.getDay() != -1 ? filter.getDay() : utilCalendar.get(java.util.Calendar.DAY_OF_MONTH);
        int startHour = filter.getHour() !=-1 ? filter.getHour() : 9;
        int startMinute = filter.getMinute() !=-1 ? filter.getMinute() : 0;
        int durationInMinutes = filter.getDurantionInMinutes() !=-1 ? filter.getDurantionInMinutes() : 30;
        

        utilCalendar.set(java.util.Calendar.YEAR, year);
        utilCalendar.set(java.util.Calendar.MONTH, month);
        utilCalendar.set(java.util.Calendar.DAY_OF_MONTH, day);

        Date date = utilCalendar.getTime();
        
        final AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(date),startHour, startMinute, durationInMinutes);
        

        for (int c = 0; c < numberOfAppointments; c++) {
            Appointment appointment = getAppointment(spec);
            appointments.add(appointment);
        }

        return appointments;
    }

    public static void buildNAppointmentsFromFilterAndAddToCalendar(int numberOfAppointments,
            TimeSlotFilter filter, DefaultCalendar calendar) {

        List<Appointment> appointments = buildNAppointmentsForFilter(numberOfAppointments, filter);
        for (Appointment appointment : appointments) {
            calendar.schedule(appointment);
        }

    }

    /*
     * Given a String in the format of DD/MM/YYYY HH:mm, create a new appointments scheduled for that date and time
     */
    public static Appointment buildAppointment(String expression) {
        // 01/01/2012 9:00-9:30
        //TimeSlot timeSlot = getTimeSlotFromExpression(expression);
        return null;
        
        
    }
}
