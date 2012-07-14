package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.List;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DateTimeComponentExclusion;

/**
 * An imutable container of {@link DateTimeComponent} with muttable {@link DateTimeComponentExclusion}
 * @author jpereira
 *
 * @param <E>
 */
public interface DateTimeComponentContainer<E extends DateTimeComponentExclusion> {

	/**
	 * Core Interface
	 * @param dateTimeComponent
	 * @return
	 */
	boolean contains(DateTimeComponent dateTimeComponent);

	/** Building state interfaces **/
	int getComponentCount();
	

	List<E> getExclusions();

	void addExclusion(E exclusion);

	void removeExclusion(String exclusionName);

	boolean isExcluded(DateTimeComponent dateTimeComponent);

}
