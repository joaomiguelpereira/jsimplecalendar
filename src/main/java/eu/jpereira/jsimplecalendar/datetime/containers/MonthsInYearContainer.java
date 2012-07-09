package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.jpereira.jsimplecalendar.datetime.MonthInYear;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.MonthInYearExclusion;

/**
 * This class models the Working Months in a calendar model.
 * 
 * @author jpereira
 * 
 */
public class MonthsInYearContainer implements DateTimeComponentContainer<MonthInYear> {

	private List<MonthInYear> monthsBackList;
	private Map<String, MonthInYearExclusion> excludesBackList;

	public MonthsInYearContainer() {
		initializeEmptyContainer();
	}

	/**
	 * Default stuff. Instantiation is not closed, as you can override this
	 * method. For more flexibility in this instantiation process, use one of
	 * the factory methods
	 */
	private void initializeEmptyContainer() {
		this.excludesBackList = new HashMap<String,MonthInYearExclusion>();
		this.monthsBackList = new ArrayList<MonthInYear>();
	}

	/**
	 * Construct a new {@link MonthsInYearContainer}
	 * 
	 * @param initialWorkingMonths
	 * @param initialExcludeMonths
	 */
	public MonthsInYearContainer(List<MonthInYear> initialWorkingMonths, Map<String, MonthInYearExclusion> initialExcludeMonths) {
		this.monthsBackList = initialWorkingMonths;
		this.excludesBackList = initialExcludeMonths;
	}

	public boolean contains(MonthInYear month) {

		if (isExclusion(month)) {
			return false;
		}

		for (MonthInYear workingMonth : this.monthsBackList) {
			if (workingMonth.equals(month)) {
				return true;
			}
		}
		return false;
	}

	private boolean isExclusion(MonthInYear month) {
		for (MonthInYearExclusion exception : this.excludesBackList.values()) {

			for (MonthInYear exceptionMonthPeriod : exception.getMonths()) {
				if (exceptionMonthPeriod.equals(month)) {
					return true;
				}
			}
		}
		return false;

	}

	public void addException(MonthInYearExclusion exception) {
		this.excludesBackList.put(exception.getName(), exception);

	}

	public void removeException(String name) {
		this.excludesBackList.remove(name);

	}

	public List<MonthInYearExclusion> getExceptions() {
		List<MonthInYearExclusion> exceptions = new ArrayList<MonthInYearExclusion>();
		exceptions.addAll(this.excludesBackList.values());
		return exceptions;
	}

	@Override
	public int getComponentCount() {
		return this.monthsBackList.size();
	}

}
