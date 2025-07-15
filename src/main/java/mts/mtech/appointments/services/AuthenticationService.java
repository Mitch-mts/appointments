package mts.mtech.appointments.services;

import mts.mtech.appointments.domain.User;
import mts.mtech.appointments.dto.LoginRequest;
import mts.mtech.appointments.dto.RegisterUser;

public interface AuthenticationService {
    User signup(RegisterUser input);
    User authenticate(LoginRequest input);
}
