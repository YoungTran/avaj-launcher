package exceptions;

public class BadCoorsException extends Exception {
    public BadCoorsException () {}

    public BadCoorsException(String msg) {
        super(msg);
    }
}