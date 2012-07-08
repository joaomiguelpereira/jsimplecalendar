package eu.jpereira.appointments.model.calendar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.jpereira.appointments.model.calendar.datetime.WeekDayException;
import eu.jpereira.appointments.model.calendar.datetime.WorkingPeriod;
import eu.jpereira.jsimplecalendar.datetime.DayInWeek;

public class WorkingWeekDays implements WorkingPeriod<DayInWeek> {

	private Map<String, WeekDayException> exceptionWeekDay;
	private List<DayInWeek> workingWeekDays;

	public WorkingWeekDays(List<DayInWeek> initialWeekDays,
			Map<String, WeekDayException> initialExceptionWeekDay) {
		this.workingWeekDays = initialWeekDays;
		this.exceptionWeekDay = initialExceptionWeekDay;
	}

	public boolean contains(DayInWeek dayOfTheWeek) {

		if (isException(dayOfTheWeek)) {
			return false;
		}
		for (DayInWeek weekDay : workingWeekDays) {
			if (weekDay.equals(dayOfTheWeek)) {
				return true;
			}
		}
		return false;

	}

	private boolean isException(DayInWeek dayOfTheWeek) {
		// Check exceptions
		for (WeekDayException exceptionWorkingDays : exceptionWeekDay.values()) {
			for (DayInWeek weekDay : exceptionWorkingDays.getWeekDays()) {
				if (weekDay.equals(dayOfTheWeek)) {
					return true;
				}
			}
		}
		return false;

	}

	public void addException(WeekDayException weekDayException) {
		this.exceptionWeekDay.put(weekDayException.getName(), weekDayException);
	}

	public void removeException(String exceptionName) {
		this.exceptionWeekDay.remove(exceptionName);

	}

	public List<WeekDayException> getExceptions() {
		List<WeekDayException> exceptions = new ArrayList<WeekDayException>();
		exceptions.addAll(this.exceptionWeekDay.values());
		return exceptions;
	}

}
