package models.exceptions;

public class TrainNotDeterminedException extends Exception {

    public TrainNotDeterminedException() {
        super("Train is not determined");
    }

    public TrainNotDeterminedException(String message) {
        super(message);
    }
}
