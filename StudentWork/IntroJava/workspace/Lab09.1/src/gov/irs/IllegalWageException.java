package gov.irs;

public class IllegalWageException extends Exception{

    public IllegalWageException() {
    }

    public IllegalWageException(String message) {
        super(message);
    }

    public IllegalWageException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalWageException(Throwable cause) {
        super(cause);
    }

    public IllegalWageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
