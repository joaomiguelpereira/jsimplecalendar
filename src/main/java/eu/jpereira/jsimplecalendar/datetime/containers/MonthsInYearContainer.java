package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.MonthInYear;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DateTimeComponentExclusion;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.MonthInYearExclusion;

/**
 * This class models the Working Months in a calendar model.
 * 
 * @author jpereira
 * 
 */
public class MonthsInYearContainer extends MapAndListBackedDateTimeComponentContainer< MonthInYearExclusion> {

	private MonthsInYearContainer() {
		
	}
	
	@Override
    protected List<DateTimeComponent> getNewEmptyDateTimeComponents() {
	    List<DateTimeComponent> allMonthsInYear = new ArrayList<DateTimeComponent>();
	    for (MonthInYear monthInYear : MonthInYear.allMonths() ) {
	    	allMonthsInYear.add(monthInYear);
	    }
	    return allMonthsInYear;
    }
	public static MonthsInYearContainer newContainerWithComponents(MonthInYear...monthsInYear) {
		MonthsInYearContainer container = new MonthsInYearContainer();
		container.dateTimeComponentExclusions = new HashMap<String, DateTimeComponentExclusion>();
		container.dateTimeComponents = Arrays.asList((DateTimeComponent[])monthsInYear);
		return container;
	}
	
	
}
