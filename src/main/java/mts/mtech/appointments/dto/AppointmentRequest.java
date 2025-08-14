package mts.mtech.appointments.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentRequest {
    private String fullName;
    private String email;
    private LocalDate bookedDate;
    private LocalTime bookedTime;
    private String additionalNotes;

    public AppointmentRequest() {
    }
    public AppointmentRequest(String fullName, String email, LocalDate bookedDate, LocalTime bookedTime, String additionalNotes) {
        this.fullName = fullName;
        this.email = email;
        this.bookedDate = bookedDate;
        this.bookedTime = bookedTime;
        this.additionalNotes = additionalNotes;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
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

    @Override
    public String toString() {
        return "AppointmentRequest{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", bookedDate=" + bookedDate +
                ", bookedTime=" + bookedTime +
                '}';
    }
}
