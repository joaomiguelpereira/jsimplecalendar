package eu.jpereira.appointments.model.calendar.datetime;

import eu.jpereira.jsimplecalendar.datetime.DayMonthInYear;

public class DayOfMonthException {

    
    private String name;
    private DayMonthInYear dayOfTheMonthException;

    public DayOfMonthException(String name, String dayOfMonthExpression) {
        dayOfTheMonthException = DayMonthInYear.valueOf(dayOfMonthExpression);
        this.name = name;
    }

    public String getName() {
        
        return this.name;
    }

    public boolean includes(DayMonthInYear dayOfMonth) {
        return this.dayOfTheMonthException.equals(dayOfMonth);
      
    }

}
