package eu.jpereira.appointments.model.calendar.datetime;

enum WeekDayEnum {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    static WeekDayEnum[] allBusinessWeekDays() {
        WeekDayEnum[] businessWeekDays = new WeekDayEnum[5];
        businessWeekDays[0] = MONDAY;
        businessWeekDays[1] = TUESDAY;
        businessWeekDays[2] = WEDNESDAY;
        businessWeekDays[3] = THURSDAY;
        businessWeekDays[4] = FRIDAY;
        return businessWeekDays;
    }

    static WeekDayEnum[] allWeekDays() {
        WeekDayEnum[] businessWeekDays = new WeekDayEnum[7];
        businessWeekDays[0] = MONDAY;
        businessWeekDays[1] = TUESDAY;
        businessWeekDays[2] = WEDNESDAY;
        businessWeekDays[3] = THURSDAY;
        businessWeekDays[4] = FRIDAY;
        businessWeekDays[5] = SATURDAY;
        businessWeekDays[6] = SUNDAY;
        return businessWeekDays;

    }

}
