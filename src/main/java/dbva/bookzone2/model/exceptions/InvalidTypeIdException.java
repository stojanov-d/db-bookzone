package dbva.bookzone2.model.exceptions;

public class InvalidTypeIdException extends RuntimeException{
    public InvalidTypeIdException() {
        super("Type not found");
    }
}
