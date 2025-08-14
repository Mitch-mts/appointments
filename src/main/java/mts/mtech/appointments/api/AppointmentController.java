package mts.mtech.appointments.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mts.mtech.appointments.domain.Appointments;
import mts.mtech.appointments.domain.BookingStatus;
import mts.mtech.appointments.dto.AppointmentRequest;
import mts.mtech.appointments.dto.ResponseWrapper;
import mts.mtech.appointments.dto.UpdateAppointmentRequest;
import mts.mtech.appointments.services.AppointmentsService;
import mts.mtech.appointments.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/appointments")
@Tag(name = "Appointments API", description = "Book, cancel and view appointments")
@CrossOrigin
public class AppointmentController {
    private final AppointmentsService appointmentsService;

    public AppointmentController(AppointmentsService appointmentsService) {
        this.appointmentsService = appointmentsService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create booking", description = "API enables creation of appointment bookings")
    public ResponseWrapper<Appointments> bookAppointments(@RequestBody AppointmentRequest request) {
        return new ResponseWrapper<Appointments>().buildSuccessResponse(Constants.SUCCESS,
                appointmentsService.createAppointment(request));
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Appointment", description = "API updates appointments")
    public ResponseWrapper<Appointments> updateAppointment(@RequestBody UpdateAppointmentRequest request, @PathVariable Long id) {
        return new ResponseWrapper<Appointments>().buildSuccessResponse(Constants.SUCCESS,
                appointmentsService.updateAppointment(request, id));
    }

    @GetMapping("/get-by-referenceNumber")
    @Operation(summary = "Retrieve appointments by reference number", description = "API returns available appointments using the provided reference number")
    public ResponseWrapper<Appointments> getAppointmentByReferenceNumber(@RequestParam String referenceNumber) {
        return new ResponseWrapper<Appointments>().buildSuccessResponse(Constants.SUCCESS,
                appointmentsService.getAppointmentByReferenceNumber(referenceNumber));
    }

    @GetMapping("/get-by-status")
    @Operation(summary = "Retrieve appointments by booking status", description = "API returns available appointments by booking status")
    public ResponseWrapper<List<Appointments>> getAppointmentByStatus(@RequestParam BookingStatus status,
                                                                      @RequestParam String email) {
        return new ResponseWrapper<List<Appointments>>().buildSuccessResponse(Constants.SUCCESS,
                appointmentsService.getAllAppointmentsByStatus(status, email));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve appointments by id", description = "API returns available appointments by id")
    public ResponseWrapper<Appointments> getAppointmentById(@PathVariable Long id) {
        return new ResponseWrapper<Appointments>().buildSuccessResponse(Constants.SUCCESS,
                appointmentsService.getAppointmentById(id));
    }

    @GetMapping("/list")
    @Operation(summary = "Retrieve all appointments", description = "API returns all the appointments")
    public ResponseWrapper<List<Appointments>> getAppointments() {
        return new ResponseWrapper<List<Appointments>>().buildSuccessResponse(Constants.SUCCESS,
                appointmentsService.getAllAppointments());
    }

    @GetMapping("/list-for-user")
    @Operation(summary = "Retrieve all appointments for a given user", description = "API returns all the appointments")
    public ResponseWrapper<List<Appointments>> getAppointmentsForUser(@RequestParam String email) {
        return new ResponseWrapper<List<Appointments>>().buildSuccessResponse(Constants.SUCCESS,
                appointmentsService.getAllAppointmentsForUser(email));
    }

}
