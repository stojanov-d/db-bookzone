package dbva.bookzone2.model.exceptions;

public class InvalidUserIdException extends RuntimeException{
    public InvalidUserIdException() {
        super("User not found");
    }
}
