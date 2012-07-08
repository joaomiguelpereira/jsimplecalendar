package eu.jpereira.jsimplecalendar.datetime.exceptions;


public class IllegalDateTimeComponentValueException extends RuntimeException {

	public IllegalDateTimeComponentValueException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public IllegalDateTimeComponentValueException(String message) {
	    super(message);
    }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1293962646313186868L;

}
