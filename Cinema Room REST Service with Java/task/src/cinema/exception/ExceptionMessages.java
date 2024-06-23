package cinema.exception;

public enum ExceptionMessages {

    ROW_OR_COLUMN_OUT_OF_BOUNDS_MESSAGE("The number of a row or a column is out of bounds!"),
    TICKET_IS_PURCHASED_MESSAGE("The ticket has been already purchased!"),
    WRONG_TOKEN_MESSAGE("Wrong token!"),
    WRONG_PASSWORD_MESSAGE("The password is wrong!");

    private final String message;
    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
