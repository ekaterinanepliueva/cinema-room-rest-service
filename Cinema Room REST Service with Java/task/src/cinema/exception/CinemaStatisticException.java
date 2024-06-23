package cinema.exception;

public class CinemaStatisticException extends RuntimeException{

    public CinemaStatisticException(ExceptionMessages error) {
        super(error.getMessage());
    }
}
