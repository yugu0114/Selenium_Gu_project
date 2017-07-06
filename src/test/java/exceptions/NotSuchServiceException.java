package exceptions;

public class NotSuchServiceException extends Exception {

    public NotSuchServiceException () {

    }

    public NotSuchServiceException (String message) {
        super (message);
    }

    public NotSuchServiceException (Throwable cause) {
        super (cause);
    }

    public NotSuchServiceException (String message, Throwable cause) {
        super (message, cause);
    }
}
