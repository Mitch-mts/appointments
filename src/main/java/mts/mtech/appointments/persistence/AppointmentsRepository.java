package mts.mtech.appointments.persistence;

import mts.mtech.appointments.domain.Appointments;
import mts.mtech.appointments.domain.BookingStatus;

import java.util.List;
import java.util.Optional;

public interface AppointmentsRepository extends BaseRepository<Appointments> {
        List<Appointments> findAllByBookingStatusAndEmail(BookingStatus bookingStatus, String email);
    Optional<Appointments> findAppointmentsByReferenceNumber(String referenceNumber);
    List<Appointments> findAllByEmail(String email);
}
