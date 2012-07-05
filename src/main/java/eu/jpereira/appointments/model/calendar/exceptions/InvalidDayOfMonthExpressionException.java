package eu.jpereira.appointments.model.calendar.exceptions;

import eu.jpereira.appointments.model.exeptions.ProgrammingException;

public class InvalidDayOfMonthExpressionException extends ProgrammingException {

    public InvalidDayOfMonthExpressionException(String message, Throwable t) {
        super(message, t);
    }

    public InvalidDayOfMonthExpressionException(String message) {
        super(message);
    }

    /**
     * 
     */
    private static final long serialVersionUID = -5723785549941887212L;

}
