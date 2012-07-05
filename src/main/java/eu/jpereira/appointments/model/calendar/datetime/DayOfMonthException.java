package eu.jpereira.appointments.model.calendar.datetime;

public class DayOfMonthException {

    
    private String name;
    private DayOfMonth dayOfTheMonthException;

    public DayOfMonthException(String name, String dayOfMonthExpression) {
        dayOfTheMonthException = DayOfMonth.valueOf(dayOfMonthExpression);
        this.name = name;
    }

    public String getName() {
        
        return this.name;
    }

    public boolean includes(DayOfMonth dayOfMonth) {
        return this.dayOfTheMonthException.equals(dayOfMonth);
      
    }

}
