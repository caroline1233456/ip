package parakeet;

public class InvalidInputError extends Exception {
    public InvalidInputError(String message) {
        super(message);
    }
}
