package mts.mtech.appointments.domain;

public enum BookingStatus {
    PENDING("Pending"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled");

    private final String status;

    public String getStatus() {
        return status;
    }

    BookingStatus(String status) {
        this.status = status;
    }
}
