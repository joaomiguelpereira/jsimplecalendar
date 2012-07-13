package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DateTimeComponentExclusion;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DayMonthInYearExclusion;

public class DayMonthInYearContainer extends MapAndListBackedDateTimeComponentContainer<DayMonthInYearExclusion> {

	public DayMonthInYearContainer(List<DateTimeComponent> initialDateTimeComponents,
	        Map<String, DateTimeComponentExclusion> initialDateTimeComponentExclusion) {
		super(initialDateTimeComponents, initialDateTimeComponentExclusion);
	}

	public DayMonthInYearContainer() {

	}

	@Override
	public boolean contains(DateTimeComponent dateTimeComponent) {
		// Modify behavior
		if (super.isExcluded(dateTimeComponent)) {
			return false;
		}
		return true;
	}

	@Override
	protected Map<String, DateTimeComponentExclusion> getNewEmptyDateTimeComponentExclusions() {
		return new HashMap<String, DateTimeComponentExclusion>();

	}

	@Override
	protected List<DateTimeComponent> getNewEmptyDateTimeComponents() {
		return new ArrayList<DateTimeComponent>();
	}

}
