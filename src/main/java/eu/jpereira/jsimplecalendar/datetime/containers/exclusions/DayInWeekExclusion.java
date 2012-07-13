package eu.jpereira.jsimplecalendar.datetime.containers.exclusions;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.DayInWeek;

public class DayInWeekExclusion  implements DateTimeComponentExclusion{
    private String name;
    private DayInWeek dayInWeekExclusion;

    private DayInWeekExclusion(String name, DayInWeek dayInWeekExclusion) {
        this.name = name;
        this.dayInWeekExclusion = dayInWeekExclusion;
    }

    public String getName() {
        return name;
    }

	@Override
    public boolean isExcluded(DateTimeComponent dateTimeComponent) {
	    return this.dayInWeekExclusion.equals(dateTimeComponent);
    }

	public static DateTimeComponentExclusion valueOf(String exclusionName, String dayInWeekExpression) {
	    
	    return new DayInWeekExclusion(exclusionName, DayInWeek.valueOf(dayInWeekExpression));
    }

}
