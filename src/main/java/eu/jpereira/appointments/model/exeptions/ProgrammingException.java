package eu.jpereira.appointments.model.exeptions;


public class ProgrammingException extends RuntimeException {

    public ProgrammingException(String message) {
      super(message);
    }

    public ProgrammingException(String message, Throwable t) {
        super(message, t);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 6831857280189162772L;

}
