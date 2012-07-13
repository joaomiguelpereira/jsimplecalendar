package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.MonthInYear;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.MonthInYearExclusion;

/**
 * This class models the Working Months in a calendar model.
 * 
 * @author jpereira
 * 
 */
public class MonthsInYearContainer extends MapAndListBackedDateTimeComponentContainer< MonthInYearExclusion> {

	@Override
    protected List<DateTimeComponent> getNewEmptyDateTimeComponents() {
	    List<DateTimeComponent> allMonthsInYear = new ArrayList<DateTimeComponent>();
	    for (MonthInYear monthInYear : MonthInYear.allMonths() ) {
	    	allMonthsInYear.add(monthInYear);
	    }
	    return allMonthsInYear;
    }

	
	
}
