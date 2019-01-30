package exceptions;

public class InvalidArgException extends Exception {
    public InvalidArgException() {}

    public InvalidArgException(String msg) {
        super(msg);
    }
}
