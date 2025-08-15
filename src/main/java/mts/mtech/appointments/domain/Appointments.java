package mts.mtech.appointments.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "Appointments")
@Entity
public class Appointments implements Serializable {
    @Id
    @GeneratedValue(
            generator = "role_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String fullName;
    @Column
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column
    private LocalDate bookedDate;
    @JsonFormat(pattern = "HH:mm")
    @Column
    LocalTime bookedTime;
    @Column
    private BookingStatus bookingStatus;
    @Column
    private String referenceNumber;
    @Column
    private String notes;

    public Appointments() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", bookedDate=" + bookedDate +
                ", bookedTime=" + bookedTime +
                ", bookingStatus=" + bookingStatus +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
