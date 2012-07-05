package eu.jpereira.appointments.model.calendar.datetime;

import java.util.Formatter;

public class WorkingTimeException extends DayTimeInterval {

    private String name;

    public WorkingTimeException(String name, String startDayTimeExpression, String endDayTimeExpression) {
        super(startDayTimeExpression, endDayTimeExpression);
        this.name = name;

    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        Formatter fmt = new Formatter();
        fmt.format("Start DayTime is: %s ; End DayTime is: %s", this.startDayTime.toString(),
                this.endDayTime.toString());
        return fmt.out().toString();
    }

}
