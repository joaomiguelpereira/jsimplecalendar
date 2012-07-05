package eu.jpereira.appointments.model.calendar.exceptions;

public class InvalidDayTimeExpressionException extends RuntimeException{

    private static final long serialVersionUID = -6924971487908298490L;

    
    public InvalidDayTimeExpressionException(String message, Throwable throwable) {
        super(message, throwable);
    }


    public InvalidDayTimeExpressionException(String message) {
        super(message);
    }

}
