package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.DayInWeek;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DateTimeComponentExclusion;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DayInWeekExclusion;

public class DayInWeekContainer extends MapAndListBackedDateTimeComponentContainer<DayInWeekExclusion> {

	private DayInWeekContainer() {

	}

	public static DayInWeekContainer emptyContainer() {
		DayInWeekContainer newInstance = new DayInWeekContainer();
		newInstance.dateTimeComponentExclusions = new HashMap<String, DateTimeComponentExclusion>();
		newInstance.dateTimeComponents = new ArrayList<DateTimeComponent>();
		return newInstance;
	}

	public static DayInWeekContainer containerWithComponents(DayInWeek[] allDaysInWeek) {
		DayInWeekContainer newInstance = new DayInWeekContainer();
		newInstance.dateTimeComponentExclusions = new HashMap<String, DateTimeComponentExclusion>();
		newInstance.dateTimeComponents = Arrays.asList( (DateTimeComponent[])allDaysInWeek);
		return newInstance;
    }
}
