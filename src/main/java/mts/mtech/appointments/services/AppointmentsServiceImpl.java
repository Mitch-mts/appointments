package mts.mtech.appointments.services;

import lombok.extern.slf4j.Slf4j;
import mts.mtech.appointments.domain.Appointments;
import mts.mtech.appointments.domain.BookingStatus;
import mts.mtech.appointments.dto.AppointmentRequest;
import mts.mtech.appointments.dto.UpdateAppointmentRequest;
import mts.mtech.appointments.exceptions.RecordNotFoundException;
import mts.mtech.appointments.persistence.AppointmentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AppointmentsServiceImpl implements AppointmentsService {
    private final AppointmentsRepository appointmentsRepository;

    public AppointmentsServiceImpl(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    @Override
    public Appointments createAppointment(AppointmentRequest request) {
        Appointments appointments = new  Appointments();
        appointments.setBookedDate(request.getBookedDate());
        appointments.setBookedTime(request.getBookedTime());
        appointments.setFullName(request.getFullName());
        appointments.setEmail(request.getEmail());

        return appointmentsRepository.save(appointments);
    }

    @Override
    public Appointments updateAppointment(UpdateAppointmentRequest request, Long id) {
        Appointments appointments = appointmentsRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Appointment Record not found"));

        if(request.getBookingStatus().equals(BookingStatus.CANCELLED) ||
        request.getBookingStatus().equals(BookingStatus.COMPLETED)) {
            appointments.setBookingStatus(request.getBookingStatus());

        } else {
            appointments.setBookedDate(request.getBookedDate());
            appointments.setBookedTime(request.getBookedTime());
            appointments.setFullName(request.getFullName());
            appointments.setEmail(request.getEmail());
        }

        return appointmentsRepository.save(appointments);
    }

    @Override
    public List<Appointments> getAllAppointments() {
        return appointmentsRepository.findAll();
    }

    @Override
    public List<Appointments> getAllAppointmentsForUser(String email) {
        return appointmentsRepository.findAllByEmail(email);
    }

    @Override
    public List<Appointments> getAllAppointmentsByStatus(BookingStatus status, String email) {
        return appointmentsRepository.findAllByBookingStatusAndEmail(status, email);
    }

    @Override
    public Appointments getAppointmentByReferenceNumber(String referenceNumber) {
        return appointmentsRepository.findAppointmentsByReferenceNumber(referenceNumber)
                .orElseThrow(() -> new RecordNotFoundException("Appointment Record not found with reference number: " + referenceNumber));
    }

}
