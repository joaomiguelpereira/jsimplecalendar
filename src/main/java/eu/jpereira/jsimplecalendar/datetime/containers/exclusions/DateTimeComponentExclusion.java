package eu.jpereira.jsimplecalendar.datetime.containers.exclusions;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;

public interface DateTimeComponentExclusion {

	String getName();

	boolean isExcluded(DateTimeComponent dateTimeComponent);

}
