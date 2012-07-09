package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.jpereira.jsimplecalendar.datetime.DayInWeek;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DayInWeekExclusion;

public class DayInWeekContainer implements DateTimeComponentContainer<DayInWeek, DayInWeekExclusion> {

	private Map<String, DayInWeekExclusion> exceptionWeekDay;
	private List<DayInWeek> workingWeekDays;

	public DayInWeekContainer(List<DayInWeek> initialWeekDays, Map<String, DayInWeekExclusion> initialExceptionWeekDay) {
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
		for (DayInWeekExclusion exceptionWorkingDays : exceptionWeekDay.values()) {
			for (DayInWeek weekDay : exceptionWorkingDays.getWeekDays()) {
				if (weekDay.equals(dayOfTheWeek)) {
					return true;
				}
			}
		}
		return false;

	}

	public void addException(DayInWeekExclusion weekDayException) {
		this.exceptionWeekDay.put(weekDayException.getName(), weekDayException);
	}

	public void removeException(String exceptionName) {
		this.exceptionWeekDay.remove(exceptionName);

	}

	@Override
	public List<DayInWeekExclusion> getExclusions() {
		List<DayInWeekExclusion> exceptions = new ArrayList<DayInWeekExclusion>();
		exceptions.addAll(this.exceptionWeekDay.values());
		return exceptions;
	}

	@Override
	public int getComponentCount() { // TODO Auto-generated method stub
		return 0;
	}

	@Override
    public void removeExclusion(String exclusionName) {
	    // TODO Auto-generated method stub
	    
    }

}
