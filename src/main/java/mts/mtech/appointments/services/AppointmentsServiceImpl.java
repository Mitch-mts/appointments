package mts.mtech.appointments.services;

import lombok.extern.slf4j.Slf4j;
import mts.mtech.appointments.domain.Appointments;
import mts.mtech.appointments.domain.BookingStatus;
import mts.mtech.appointments.dto.AppointmentRequest;
import mts.mtech.appointments.dto.UpdateAppointmentRequest;
import mts.mtech.appointments.exceptions.RecordNotFoundException;
import mts.mtech.appointments.persistence.AppointmentsRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class AppointmentsServiceImpl implements AppointmentsService {
    private final AppointmentsRepository appointmentsRepository;

    public AppointmentsServiceImpl(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    @Override
    public Appointments createAppointment(AppointmentRequest request) {
        Appointments appointments = new Appointments();
        appointments.setBookedDate(convertToDate(request.getDate()));
        appointments.setBookedTime(convertToTime(request.getTime()));
        appointments.setFullName(request.getFullName());
        appointments.setEmail(request.getEmail());
        appointments.setReferenceNumber(generateReferenceNumber());
        appointments.setNotes(request.getNotes());
        appointments.setBookingStatus(BookingStatus.PENDING);

        return appointmentsRepository.save(appointments);
    }

    public static LocalDate convertToDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date provided");
        }
    }

    public static LocalTime convertToTime(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return LocalTime.parse(date, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date provided");
        }
    }

    private static String generateReferenceNumber() {
        final String values = "0123456789qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
        final Random random = new Random();
        char[] refNumber = new char[7];
        for (int i = 0; i < 7; i++) {
            refNumber[i] = values.charAt(random.nextInt(values.length()));
        }
        return new String(refNumber);
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

    @Override
    public Appointments getAppointmentById(Long id) {
        return appointmentsRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException("Appointment Record not found"));
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentsRepository.deleteById(id);
    }

}
