package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DateTimeComponentExclusion;

/**
 * An abstract implementation of {@link DateTimeComponent} It contains a
 * {@link List} of {@link DateTimeComponent} instances. There are exclusions to
 * the list, a way to tell the container to ignore a given
 * {@link DateTimeComponent} in it's list. Class
 * {@link DateTimeComponentExclusion} model one exclusion of the list.
 * 
 * @author jpereira
 * 
 * @param <E>
 */
public abstract class MapAndListBackedDateTimeComponentContainer<E extends DateTimeComponentExclusion> implements DateTimeComponentContainer<E> {

	protected List<DateTimeComponent> dateTimeComponents;

	protected Map<String, DateTimeComponentExclusion> dateTimeComponentExclusions;

	protected MapAndListBackedDateTimeComponentContainer() {

	}

	protected Map<String, DateTimeComponentExclusion> getNewEmptyDateTimeComponentExclusions() {
		return new HashMap<String, DateTimeComponentExclusion>();
	}

	protected List<DateTimeComponent> getNewEmptyDateTimeComponents() {
		return new ArrayList<DateTimeComponent>();
	}

	public boolean contains(DateTimeComponent dateTimeComponent) {

		if (isExcluded(dateTimeComponent)) {
			return false;
		}
		for (DateTimeComponent component : dateTimeComponents) {
			if (component.equals(dateTimeComponent)) {
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean isExcluded(DateTimeComponent dateTimeComponent) {

		for (DateTimeComponentExclusion actualExclusion : this.dateTimeComponentExclusions.values()) {
			if (actualExclusion.isExcluded(dateTimeComponent)) {
				return true;
			}
		}
		return false;

	}

	// TODO: Think about this...
	public List<E> getExclusions() {
		List<DateTimeComponentExclusion> exclusions = new ArrayList<DateTimeComponentExclusion>();
		exclusions.addAll(this.dateTimeComponentExclusions.values());
		return (List<E>) exclusions;
	}

	public int getComponentCount() {
		return this.dateTimeComponents.size();
	}

	public void removeExclusion(String exclusionName) {
		this.dateTimeComponentExclusions.remove(exclusionName);
	}

	@Override
	public void addExclusion(DateTimeComponentExclusion exclusion) {
		this.dateTimeComponentExclusions.put(exclusion.getName(), exclusion);
	}

}
