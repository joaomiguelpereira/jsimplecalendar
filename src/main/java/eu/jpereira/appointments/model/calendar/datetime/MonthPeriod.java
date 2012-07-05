package eu.jpereira.appointments.model.calendar.datetime;

public class MonthPeriod implements AbstractPeriod {

    private MonthEnum backedEnumMonths = null;

    private MonthPeriod(MonthEnum targetMonth) {

        this.backedEnumMonths = targetMonth;
    }

    public static MonthPeriod valueOf(String month) {
        MonthEnum targetMonth = MonthEnum.valueOf(month);

        MonthPeriod monthsInstance = new MonthPeriod(targetMonth);
        return monthsInstance;
    }

    public static MonthPeriod[] allMonths() {
        MonthPeriod[] monthPeriods = new MonthPeriod[MonthEnum.values().length];
        int index = 0;
        for (MonthEnum month : MonthEnum.values()) {
            monthPeriods[index++] = new MonthPeriod(month);
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
        MonthPeriod otherPeriod = (MonthPeriod) other;
        if (!backedEnumMonths.equals(otherPeriod.backedEnumMonths)) {
            return false;
        }

        return true;
    }

}
