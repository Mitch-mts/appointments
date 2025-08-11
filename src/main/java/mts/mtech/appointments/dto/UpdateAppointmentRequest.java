package mts.mtech.appointments.dto;

import mts.mtech.appointments.domain.BookingStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class UpdateAppointmentRequest {
    private String fullName;
    private String email;
    private LocalDate bookedDate;
    private LocalTime bookedTime;
    private BookingStatus bookingStatus;

    public UpdateAppointmentRequest() {
    }

    public UpdateAppointmentRequest(String fullName,
                                    String email,
                                    LocalDate bookedDate,
                                    LocalTime bookedTime,
                                    BookingStatus bookingStatus) {
        this.fullName = fullName;
        this.email = email;
        this.bookedDate = bookedDate;
        this.bookedTime = bookedTime;
        this.bookingStatus = bookingStatus;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(LocalDate bookedDate) {
        this.bookedDate = bookedDate;
    }

    public LocalTime getBookedTime() {
        return bookedTime;
    }

    public void setBookedTime(LocalTime bookedTime) {
        this.bookedTime = bookedTime;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return "UpdateAppointmentRequest{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", bookedDate=" + bookedDate +
                ", bookedTime=" + bookedTime +
                ", bookingStatus=" + bookingStatus +
                '}';
    }
}
