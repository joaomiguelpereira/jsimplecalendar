package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.jpereira.appointments.model.calendar.exceptions.WorkingTimeExceptionNotFound;
import eu.jpereira.jsimplecalendar.datetime.TimeInDayPeriod;
import eu.jpereira.jsimplecalendar.datetime.EmptyTimeInDayPeriod;
import eu.jpereira.jsimplecalendar.datetime.TimeInDay;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.TimeInDayExclusion;

public class TimeInDayContainer implements DateTimeComponentContainer<TimeInDay, TimeInDayExclusion> {

	private Map<String, TimeInDayExclusion> exclusions;

	private TimeInDayPeriod dayTimeSlot;

	public TimeInDayContainer(String startDayTimeExpression, String endDayTimeExpression, Map<String, TimeInDayExclusion> initialExceptions) {
		this.dayTimeSlot = new TimeInDayPeriod(startDayTimeExpression, endDayTimeExpression);
		this.exclusions = initialExceptions;
	}

	/**
	 * Create an empty container
	 */
	public TimeInDayContainer() {
		initializeEmptyContainer();
	}

	private void initializeEmptyContainer() {
		this.dayTimeSlot = new EmptyTimeInDayPeriod();
		this.exclusions = new HashMap<String, TimeInDayExclusion>();

	}

	public void addException(TimeInDayExclusion workingTimeException) {
		exclusions.put(workingTimeException.getName(), workingTimeException);
	}

	public boolean contains(TimeInDay dayTime) {

		return this.dayTimeSlot.includes(dayTime) && !isException(dayTime);

	}

	private boolean isException(TimeInDay dayTime) {
		for (TimeInDayExclusion exception : exclusions.values()) {
			if (exception.includes(dayTime)) {
				return true;
			}
		}
		return false;
	}

	public void removeExclusion(String exclusionName) {
		this.exclusions.remove(exclusionName);

	}

	@Override
	public int getComponentCount() {
		return 0;
	}

	@Override
	public List<TimeInDayExclusion> getExclusions() {
		List<TimeInDayExclusion> exceptions = new ArrayList<TimeInDayExclusion>();
		exceptions.addAll(this.exclusions.values());
		return exceptions;
	}

}
