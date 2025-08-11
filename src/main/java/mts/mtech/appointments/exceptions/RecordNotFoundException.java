package mts.mtech.appointments.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message, Exception cause) {
        super(message,cause);
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
