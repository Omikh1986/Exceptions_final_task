package custom_exception;

public class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);
    }

    public WrongLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
