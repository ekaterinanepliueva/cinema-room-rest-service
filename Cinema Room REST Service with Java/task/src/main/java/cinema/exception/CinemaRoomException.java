package cinema.exception;

public class CinemaRoomException extends RuntimeException {

    public CinemaRoomException(ExceptionMessages error) {
        super(error.getMessage());
    }
}
