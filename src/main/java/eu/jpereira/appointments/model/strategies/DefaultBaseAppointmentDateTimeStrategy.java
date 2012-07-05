package eu.jpereira.appointments.model.strategies;

import java.util.Calendar;
import java.util.Date;

import eu.jpereira.appointments.model.AppointmentDate;
import eu.jpereira.appointments.model.data.AppointmentSpecification;

public class DefaultBaseAppointmentDateTimeStrategy {

    protected Calendar today;


    
    public DefaultBaseAppointmentDateTimeStrategy(Date baselineDate) {
        
        this.today = Calendar.getInstance();
        this.today.setTime(baselineDate);
    }
    
    protected boolean isInsideTimeSlotTime(AppointmentSpecification appointmentSpecification) {
        int baselineHour = today.get(Calendar.HOUR_OF_DAY);
        int baselineMinute = today.get(Calendar.MINUTE);
        // Normalize into minutes
        int baselineMinutes = MinuteNormalizer.normalize(baselineHour, baselineMinute);

        int appointmentStartMinutes = MinuteNormalizer.normalize(appointmentSpecification.getHour(),
                appointmentSpecification.getMinute());
        int appointmentEndMinutes = appointmentStartMinutes + appointmentSpecification.getDurationInMinutes();
        boolean hasStarted = baselineMinutes >= appointmentStartMinutes;
        boolean hasEnded = baselineMinutes > appointmentEndMinutes;

        return hasStarted && !hasEnded;

    }

    protected boolean isTimeSlotOverTime(AppointmentSpecification appointmentSpecification) {
        int baselineHour = today.get(Calendar.HOUR_OF_DAY);
        int baselineMinute = today.get(Calendar.MINUTE);
        int durationInMinutes = appointmentSpecification.getDurationInMinutes();
        // Normalize into minutes

        int baselineEndMinutes = MinuteNormalizer.normalize(baselineHour, baselineMinute);
        baselineEndMinutes += durationInMinutes;

        int appointmentEndMinutes = MinuteNormalizer.normalize(appointmentSpecification.getHour(),
                appointmentSpecification.getMinute());
        appointmentEndMinutes += durationInMinutes;

        return baselineEndMinutes > appointmentEndMinutes;

    }

    protected  boolean isDateToday(AppointmentDate appDate) {
        int year = appDate.getYear();
        int month = appDate.getMonth();
        int day = appDate.getDay();

        int tdYear = today.get(Calendar.YEAR);
        int tdMonth = today.get(Calendar.MONTH) + 1;// Normalize to match the
                                                    // same behavior as in
                                                    // AppointmentDate
        int tdDay = today.get(Calendar.DAY_OF_MONTH);

        return tdYear == year && tdMonth == month && tdDay == day;
    }

    protected  boolean isDateInFuture(AppointmentDate appDate) {
        int year = appDate.getYear();
        int month = appDate.getMonth();
        int day = appDate.getDay();

        int tdYear = today.get(Calendar.YEAR);
        int tdMonth = today.get(Calendar.MONTH) + 1;// Normalize to match the
                                                    // same behavior as in
                                                    // AppointmentDate
        int tdDay = today.get(Calendar.DAY_OF_MONTH);
        // Ignore time, and compare dates only
        return tdYear < year || (tdYear == year && tdMonth < month)
                || (tdYear == year && tdMonth == month && tdDay < day);
    }


}
