package mts.mtech.appointments.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import mts.mtech.appointments.domain.User;
import mts.mtech.appointments.dto.LoginRequest;
import mts.mtech.appointments.dto.LoginResponse;
import mts.mtech.appointments.dto.RegisterUser;
import mts.mtech.appointments.dto.ResponseWrapper;
import mts.mtech.appointments.security.JwtService;
import mts.mtech.appointments.services.AuthenticationService;
import mts.mtech.appointments.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/auth")
@Tag(name = "Authentication API", description = "Api for authentication and authorisation")
@CrossOrigin
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }
    @PostMapping("/register")
    @Operation(summary = "Register user for authentication and authorisation", description = "API registers users")

    public ResponseWrapper<User> register(@RequestBody RegisterUser registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return new ResponseWrapper<User>().buildSuccessResponse(Constants.SUCCESS, registeredUser);
    }

    @PostMapping("/login")
    @Operation(summary = "Login to retrieve auth token", description = "API for retrieving authentication token")

    public ResponseWrapper<LoginResponse> authenticate(@RequestBody LoginRequest loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        loginResponse.setUserData(authenticatedUser);

        return new ResponseWrapper<LoginResponse>().buildSuccessResponse(Constants.SUCCESS, loginResponse);
    }

}
