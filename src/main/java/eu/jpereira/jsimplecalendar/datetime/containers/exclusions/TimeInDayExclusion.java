package eu.jpereira.jsimplecalendar.datetime.containers.exclusions;

import java.util.Formatter;

import eu.jpereira.appointments.model.calendar.datetime.DayTimeInterval;

public class TimeInDayExclusion extends DayTimeInterval implements DateTimeComponentExclusion {

    private String name;

    public TimeInDayExclusion(String name, String startDayTimeExpression, String endDayTimeExpression) {
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
