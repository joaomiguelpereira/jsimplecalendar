package eu.jpereira.appointments.model.calendar.datetime;

import eu.jpereira.jsimplecalendar.datetime.DayInMonth;

public class DayOfMonthException {

    
    private String name;
    private DayInMonth dayOfTheMonthException;

    public DayOfMonthException(String name, String dayOfMonthExpression) {
        dayOfTheMonthException = DayInMonth.valueOf(dayOfMonthExpression);
        this.name = name;
    }

    public String getName() {
        
        return this.name;
    }

    public boolean includes(DayInMonth dayOfMonth) {
        return this.dayOfTheMonthException.equals(dayOfMonth);
      
    }

}
