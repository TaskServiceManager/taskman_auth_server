package tsm.auth.exceptions;


public class FieldPropertiesEmptyException extends Exception{

    private static final String DEFAULT_MESSAGE = "Field(s) properties (is)are empty: ";

    public FieldPropertiesEmptyException() {
        super(DEFAULT_MESSAGE);
    }

    public FieldPropertiesEmptyException(String message) {
        super(DEFAULT_MESSAGE + message);
    }

    public FieldPropertiesEmptyException(String message, Throwable cause) {
        super(DEFAULT_MESSAGE + message, cause);
    }
}
