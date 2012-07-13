package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DateTimeComponentExclusion;

public abstract class MapAndListBackedDateTimeComponentContainer<E extends DateTimeComponentExclusion> implements DateTimeComponentContainer<E> {
	protected List<DateTimeComponent> dateTimeComponents;

	protected Map<String, DateTimeComponentExclusion> dateTimeComponentExclusions;

	public MapAndListBackedDateTimeComponentContainer() {
		this.dateTimeComponents = getNewEmptyDateTimeComponents();
		this.dateTimeComponentExclusions = getNewEmptyDateTimeComponentExclusions();

	}

	public MapAndListBackedDateTimeComponentContainer(List<DateTimeComponent> initialDateTimeComponents,
	        Map<String, DateTimeComponentExclusion> initialDateTimeComponentExclusion) {
		this.dateTimeComponents = initialDateTimeComponents;
		this.dateTimeComponentExclusions = initialDateTimeComponentExclusion;
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
	public void addDateTimeComponent(DateTimeComponent dateTimeComponent) {
		this.dateTimeComponents.add(dateTimeComponent);
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

	// TODO: Think about this
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
