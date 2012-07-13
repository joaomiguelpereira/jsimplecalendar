package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.DayInWeek;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DateTimeComponentExclusion;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DayInWeekExclusion;

public class DayInWeekContainer extends MapAndListBackedDateTimeComponentContainer<DayInWeekExclusion> {

	
	@Override
    protected Map<String, DateTimeComponentExclusion> getNewEmptyDateTimeComponentExclusions() {
		return new HashMap<String, DateTimeComponentExclusion>();
    }

	@Override
    protected List<DateTimeComponent> getNewEmptyDateTimeComponents() {
		List<DateTimeComponent> initialComponents = new ArrayList<DateTimeComponent>();
		for (DayInWeek dayInweek : DayInWeek.allDaysInWeek() ) {
			initialComponents.add(dayInweek);
		}
	    return initialComponents;
    }


}
