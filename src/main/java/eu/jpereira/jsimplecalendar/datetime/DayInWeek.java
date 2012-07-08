package eu.jpereira.jsimplecalendar.datetime;

import eu.jpereira.jsimplecalendar.datetime.exceptions.IllegalDateTimeComponentValueException;

public class DayInWeek implements DateTimeComponent {

	private WeekDayEnum backedWeekDayEnum;

	private DayInWeek(WeekDayEnum weekDayEnum) {
		this.backedWeekDayEnum = weekDayEnum;
	}

	public static DayInWeek[] allBusinessWeekDays() {
		DayInWeek[] weekDayPeriods = new DayInWeek[WeekDayEnum.allBusinessWeekDays().length];
		int index = 0;
		for (WeekDayEnum weekDayEnum : WeekDayEnum.allBusinessWeekDays()) {
			weekDayPeriods[index++] = new DayInWeek(weekDayEnum);
		}
		return weekDayPeriods;
	}

	/**
	 * Static Factory Method
	 * 
	 * @param weekDay
	 * @return
	 */
	public static DayInWeek valueOf(String weekDay) {
		try {
			WeekDayEnum enumValue = WeekDayEnum.valueOf(weekDay);
			return new DayInWeek(enumValue);
		} catch ( IllegalArgumentException ile) {
			throw new IllegalDateTimeComponentValueException("Invalid value for day in Week.",ile);
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + backedWeekDayEnum.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		DayInWeek other = (DayInWeek) obj;

		if (!backedWeekDayEnum.equals(other.backedWeekDayEnum)) {
			return false;
		}

		return true;
	}

}
