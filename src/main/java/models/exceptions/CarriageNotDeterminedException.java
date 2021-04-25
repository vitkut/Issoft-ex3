package models.exceptions;

public class CarriageNotDeterminedException extends Exception{

    public CarriageNotDeterminedException() {
        super("Carriage is not determined");
    }

    public CarriageNotDeterminedException(String message) {
        super(message);
    }
}
