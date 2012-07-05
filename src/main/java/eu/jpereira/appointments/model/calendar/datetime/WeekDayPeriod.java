package eu.jpereira.appointments.model.calendar.datetime;

public class WeekDayPeriod implements AbstractPeriod {
    private WeekDayEnum backedWeekDayEnum;

    private WeekDayPeriod(WeekDayEnum weekDayEnum) {
        this.backedWeekDayEnum = weekDayEnum;
    }

    public static WeekDayPeriod[] allBusinessWeekDays() {
        WeekDayPeriod[] weekDayPeriods = new WeekDayPeriod[WeekDayEnum.allBusinessWeekDays().length];
        int index = 0;
        for (WeekDayEnum weekDayEnum : WeekDayEnum.allBusinessWeekDays()) {
            weekDayPeriods[index++] = new WeekDayPeriod(weekDayEnum);
        }
        return weekDayPeriods;
    }

    public static WeekDayPeriod valueOf(String weekDay) {
        WeekDayEnum enumValue = WeekDayEnum.valueOf(weekDay);
        return new WeekDayPeriod(enumValue);
    }

}
