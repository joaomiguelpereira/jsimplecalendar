package eu.jpereira.jsimplecalendar.datetime;

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
		WeekDayEnum enumValue = WeekDayEnum.valueOf(weekDay);
		return new DayInWeek(enumValue);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backedWeekDayEnum == null) ? 0 : backedWeekDayEnum.hashCode());
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
