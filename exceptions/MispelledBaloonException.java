package exceptions;

public class MispelledBaloonException extends Exception {
    public MispelledBaloonException () {}

    public MispelledBaloonException(String msg) {
        super(msg);
    }
}