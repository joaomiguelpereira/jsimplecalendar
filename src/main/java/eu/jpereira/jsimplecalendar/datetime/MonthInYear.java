package eu.jpereira.jsimplecalendar.datetime;

import eu.jpereira.jsimplecalendar.datetime.exceptions.IllegalDateTimeComponentValueException;

public class MonthInYear implements DateTimeComponent {

	private MonthEnum backedEnumMonths = null;

	private MonthInYear(MonthEnum targetMonth) {

		this.backedEnumMonths = targetMonth;
	}

	public static MonthInYear valueOf(String month) {

		try {
			MonthEnum targetMonth = MonthEnum.valueOf(month);
			MonthInYear monthsInstance = new MonthInYear(targetMonth);
			return monthsInstance;
		} catch (IllegalArgumentException ile) {
			// wrap and retrow
			throw new IllegalDateTimeComponentValueException("Ivalid value for representing a month!", ile);
		}

	}

	public static MonthInYear[] allMonths() {
		MonthInYear[] monthPeriods = new MonthInYear[MonthEnum.values().length];
		int index = 0;
		for (MonthEnum month : MonthEnum.values()) {
			monthPeriods[index++] = new MonthInYear(month);
		}
		return monthPeriods;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backedEnumMonths == null) ? 0 : backedEnumMonths.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}

		if (other == null) {
			return false;
		}

		if (getClass() != other.getClass()) {
			return false;
		}
		MonthInYear otherPeriod = (MonthInYear) other;
		if (!backedEnumMonths.equals(otherPeriod.backedEnumMonths)) {
			return false;
		}

		return true;
	}

	public String toString() {
		return this.backedEnumMonths.toString();
	}

}
