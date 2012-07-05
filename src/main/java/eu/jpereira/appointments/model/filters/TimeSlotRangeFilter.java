package eu.jpereira.appointments.model.filters;

public class TimeSlotRangeFilter {

    private TimeSlotFilter startFilter;
    private TimeSlotFilter endFilter;

    public TimeSlotRangeFilter(TimeSlotFilter startFilter, TimeSlotFilter endFilter) {
        this.startFilter = startFilter;
        this.endFilter = endFilter;
    }

}
