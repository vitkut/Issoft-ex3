package models.exceptions;

public class UnderageUserException extends Exception {

    public UnderageUserException() {
        super("User is underage");
    }

    public UnderageUserException(String message) {
        super(message);
    }
}
