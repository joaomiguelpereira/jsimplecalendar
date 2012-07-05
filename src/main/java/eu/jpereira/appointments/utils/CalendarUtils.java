package eu.jpereira.appointments.utils;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtils {

    public static boolean isToday(Date when) {

        ShortDate today = ShortDate.newForToday();
        ShortDate scheduled = ShortDate.newDateFor(when);

        return today.year == scheduled.year && today.month == scheduled.month && today.day == scheduled.day;

    }

    public static boolean isTomorrow(Date when) {

        ShortDate today = ShortDate.newForToday();
        ShortDate scheduled = ShortDate.newDateFor(when);

        return today.year == scheduled.year && today.month == scheduled.month && today.day + 1 == scheduled.day;
    }

    public static Integer getYear(Date when) {

        ShortDate scheduled = ShortDate.newDateFor(when);
        return scheduled.year;
    }

    public static Integer getMonth(Date when) {
        ShortDate scheduled = ShortDate.newDateFor(when);
        return scheduled.month;
    }

    public static int getDay(Date when) {
        ShortDate scheduled = ShortDate.newDateFor(when);
        return scheduled.day;
    }

    private static class ShortDate {
        private int day;
        private int year;
        private int month;

        private static ShortDate newForToday() {
            Calendar calendar = Calendar.getInstance();
            return newInstanceFor(calendar);

        }

        private static ShortDate newDateFor(Date when) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(when);
            return newInstanceFor(calendar);

        }

        private static ShortDate newInstanceFor(Calendar calendar) {
            ShortDate newInstance = new ShortDate();
            newInstance.day = calendar.get(Calendar.DAY_OF_MONTH);
            newInstance.year = calendar.get(Calendar.YEAR);
            newInstance.month = calendar.get(Calendar.MONTH);
            return newInstance;
        }

    }

}
