package mts.mtech.appointments.services;

import mts.mtech.appointments.domain.Appointments;
import mts.mtech.appointments.domain.BookingStatus;
import mts.mtech.appointments.dto.AppointmentRequest;
import mts.mtech.appointments.dto.UpdateAppointmentRequest;

import java.util.List;

public interface AppointmentsService {
    Appointments createAppointment(AppointmentRequest request);
    Appointments updateAppointment(UpdateAppointmentRequest request, Long id);
    List<Appointments> getAllAppointments();
    List<Appointments> getAllAppointmentsForUser(String email);
    List<Appointments> getAllAppointmentsByStatus(BookingStatus status, String email);
    Appointments getAppointmentByReferenceNumber(String referenceNumber);
    Appointments getAppointmentById(Long id);
    void deleteAppointment(Long id);

}
