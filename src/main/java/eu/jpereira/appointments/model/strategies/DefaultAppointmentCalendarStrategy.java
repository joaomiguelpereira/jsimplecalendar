package eu.jpereira.appointments.model.strategies;

import java.util.Date;

import eu.jpereira.appointments.model.AppointmentDate;
import eu.jpereira.appointments.model.data.AppointmentSpecification;

public class DefaultAppointmentCalendarStrategy extends DefaultBaseAppointmentDateTimeStrategy implements
        AppointmentCalendarStrategy {


    public DefaultAppointmentCalendarStrategy(Date baselineDateTime) {
        super(baselineDateTime);

    }

    /**
     * Return true if the date is in the future (example, tommorrow) or if is
     * today but the appointment time did not arrived yet
     */
    public boolean isFuture(AppointmentSpecification appointmentSpecification) {

        AppointmentDate appDate = appointmentSpecification.getDate();

        boolean isDateInFuture = isDateInFuture(appDate);

        boolean isToday = isDateToday(appDate);

        boolean isTimeSlotOver = isTimeSlotOverTime(appointmentSpecification);
        boolean areWeInsideTimeSlot = isInsideTimeSlotTime(appointmentSpecification);

        return isDateInFuture || (isToday && !isTimeSlotOver && !areWeInsideTimeSlot);
    }

    
    public boolean isToday(AppointmentSpecification appointmentSpecification) {
        return isDateToday(appointmentSpecification.getDate());
      
    }

    public boolean isPast(AppointmentSpecification appointmentSpecification) {
        return !isToday(appointmentSpecification) && !isFuture(appointmentSpecification);
    }

    public int getRemainingDays() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getElapsedDays(AppointmentSpecification appointmentSpecification) {
        return 0;
     }

}
