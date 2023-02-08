package dbva.bookzone2.model.exceptions;

public class InvalidBookIdException extends RuntimeException{
    public InvalidBookIdException() {
        super("Book not found");
    }
}
