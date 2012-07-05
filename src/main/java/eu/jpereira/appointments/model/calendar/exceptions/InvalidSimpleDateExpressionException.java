package eu.jpereira.appointments.model.calendar.exceptions;

import eu.jpereira.appointments.model.exeptions.ProgrammingException;

public class InvalidSimpleDateExpressionException extends ProgrammingException {

    public InvalidSimpleDateExpressionException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public InvalidSimpleDateExpressionException(String message, Throwable t) {
        super(message,t);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 161268537144634685L;

}
