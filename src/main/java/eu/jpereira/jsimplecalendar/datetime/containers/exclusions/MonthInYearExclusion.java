package eu.jpereira.jsimplecalendar.datetime.containers.exclusions;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.MonthInYear;


public class MonthInYearExclusion implements DateTimeComponentExclusion {

    private String name;
    private MonthInYear excludedMonthInYear;

    private MonthInYearExclusion(String name, MonthInYear excludedMonthInYear) {
        this.name = name;
        this.excludedMonthInYear = excludedMonthInYear;
    }

    public static MonthInYearExclusion valueOf(String exclusionName, MonthInYear excludedMonthInYear) {
    	return new MonthInYearExclusion(exclusionName, excludedMonthInYear);
    }
    public String getName() {
        return name;
    }

	@Override
    public boolean isExcluded(DateTimeComponent dateTimeComponent) {
	    
	    return this.excludedMonthInYear.equals(dateTimeComponent);
    }

}
