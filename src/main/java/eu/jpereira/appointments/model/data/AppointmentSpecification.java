package eu.jpereira.appointments.model.data;

import eu.jpereira.appointments.model.AppointmentDate;


/**
 * Data structure holding the specification of one Appointment
 * 
 * @author jpereira
 * 
 */
public class AppointmentSpecification{

    private AppointmentDate date;
    private int hour;
    private int minute;
    private int durationInMinutes;

    public AppointmentSpecification(AppointmentDate date, int hour, int minute, int durationInMinutes) {
        this.date = date;
        this.hour = hour;
        this.minute = minute;
        this.durationInMinutes = durationInMinutes;
    }

    public AppointmentDate getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

   
    

}
