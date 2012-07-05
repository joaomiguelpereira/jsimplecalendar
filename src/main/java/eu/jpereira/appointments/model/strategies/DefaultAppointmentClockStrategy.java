package eu.jpereira.appointments.model.strategies;

import java.util.Calendar;
import java.util.Date;

import eu.jpereira.appointments.model.data.AppointmentSpecification;

public class DefaultAppointmentClockStrategy extends DefaultBaseAppointmentDateTimeStrategy implements
        AppointmentClockStrategy {

    public DefaultAppointmentClockStrategy(Date baselineDate) {
        super(baselineDate);
    }

    public int getElapsedMinutesSinceStart(AppointmentSpecification appointmentSpecification) {
        int baselineHour = today.get(Calendar.HOUR_OF_DAY);
        int baselineMinute = today.get(Calendar.MINUTE);

        int currentMinutes = MinuteNormalizer.normalize(baselineHour, baselineMinute);

        int startAppointmentMinutes = MinuteNormalizer.normalize(appointmentSpecification.getHour(),
                appointmentSpecification.getMinute());

        return currentMinutes - startAppointmentMinutes;
    }

    public int getElapsedMinutesSinceEnd(AppointmentSpecification appointmentSpecification) {
        int baselineHour = today.get(Calendar.HOUR_OF_DAY);
        int baselineMinute = today.get(Calendar.MINUTE);

        int currentMinutes = MinuteNormalizer.normalize(baselineHour, baselineMinute);

        int endAppointmentMinutes = MinuteNormalizer.normalize(appointmentSpecification.getHour(),
                appointmentSpecification.getMinute());
        endAppointmentMinutes += appointmentSpecification.getDurationInMinutes();

        return currentMinutes - endAppointmentMinutes;

    }

    public boolean isHappening(AppointmentSpecification appointmentSpecification) {
        boolean isToday = isDateToday(appointmentSpecification.getDate());
        boolean areWeInsideTimeSlot = isInsideTimeSlotTime(appointmentSpecification);
        return isToday && areWeInsideTimeSlot;
    }
}
