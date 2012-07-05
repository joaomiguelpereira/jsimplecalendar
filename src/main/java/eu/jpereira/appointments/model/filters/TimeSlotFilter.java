package eu.jpereira.appointments.model.filters;

/**
 * Representation of a filter.
 * 
 * @author jpereira
 * 
 */
public class TimeSlotFilter {

    protected static int UNDEFINED = -1;
    
    protected int year = UNDEFINED;
    protected int month = UNDEFINED;
    protected int day = UNDEFINED;
    protected int hour = UNDEFINED;
    protected int minute = UNDEFINED;
    private int durationInMinutes = UNDEFINED;

    /**
     * Set filtering by year
     * 
     * @param year
     *            The year for which all appoointments will be filteres
     * @return The instance of this {@link TimeSlotFilter}
     */
    public TimeSlotFilter setYear(int year) {
        this.year = year;
        return this;
    }

    /**
     * Set filtering by month
     * 
     * @param month
     *            The month for which all appointments will be filtered
     * @return The instance of this filter
     */
    public TimeSlotFilter setMonth(int month) {
        this.month = month;
        return this;
    }

    /**
     * Set filtering by day
     * 
     * @param day
     *            The day for which all appointments will be filtered
     * @return
     */
    public TimeSlotFilter setDay(int day) {
        this.day = day;
        return this;
    }

    public TimeSlotFilter setHour(int hour) {
        this.hour = hour;
        return this;
    }

    public TimeSlotFilter setMinute(int minute) {
        this.minute = minute;
        return this;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getDurantionInMinutes() {
        return this.durationInMinutes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Year: ").append(year).append("\n");
        sb.append("Month: ").append(month).append("\n");
        sb.append("Day: ").append(day).append("\n");
        sb.append("Hour: ").append(hour).append("\n");
        sb.append("Minute: ").append(minute).append("\n");
        sb.append("Duration in minutes: ").append(durationInMinutes).append("\n");
        return sb.toString();
    }

    public static TimeSlotFilter parse(String string) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
