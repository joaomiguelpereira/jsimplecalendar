package eu.jpereira.jsimplecalendar.datetime.containers.exclusions;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.DayMonthInYear;

public class DayMonthInYearExclusion implements DateTimeComponentExclusion {

	private DayMonthInYear excludedDayMonthInYear;
	private String name;

	private DayMonthInYearExclusion(String nameOfTheExclusion, DayMonthInYear dayMontInYearToExclude) {
		this.name = nameOfTheExclusion;
		this.excludedDayMonthInYear = dayMontInYearToExclude;
	}

	@Override
	public String getName() {

		return this.name;
	}

	public static DayMonthInYearExclusion valueOf(String exclusionName, String dayMonthInYearExpression) {
		DayMonthInYearExclusion newExclusion = new DayMonthInYearExclusion(exclusionName, DayMonthInYear.valueOf(dayMonthInYearExpression));
		return newExclusion;
	}

	@Override
    public boolean isExcluded(DateTimeComponent dateTimeComponent) {
	    return dateTimeComponent.equals(excludedDayMonthInYear);
    }

}
