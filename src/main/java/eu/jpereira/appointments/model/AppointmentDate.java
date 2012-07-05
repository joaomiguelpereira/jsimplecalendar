package eu.jpereira.appointments.model;

import java.util.Calendar;
import java.util.Date;

/**
 * This class abstracts a java.util.Calendar and provides utility methods to
 * access the underlying calendar year, month and day of the abstracted date
 * 
 * @author jpereira
 * 
 */
public class AppointmentDate {

    private final Calendar calendar;

    public AppointmentDate(Date date) {
        this.calendar = Calendar.getInstance();
        this.calendar.setTime(date);
    }
    
    public int getYear() {
        return this.calendar.get(Calendar.YEAR);
    }
    public int getMonth() {
        return this.calendar.get(Calendar.MONTH) + 1; //I want 1-12, not 0-11
    }
    public int getDay() {
        return this.calendar.get(Calendar.DAY_OF_MONTH);
    }
}
