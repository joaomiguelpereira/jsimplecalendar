package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.List;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DateTimeComponentExclusion;

public interface DateTimeComponentContainer<E extends DateTimeComponentExclusion> {

	boolean contains(DateTimeComponent dateTimeComponent);

	int getComponentCount();

	List<E> getExclusions();

	public void addDateTimeComponent(DateTimeComponent dateTimeComponent);

	void addExclusion(E exclusion);

	void removeExclusion(String exclusionName);

	boolean isExcluded(DateTimeComponent dateTimeComponent);

}
