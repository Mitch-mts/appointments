package mts.mtech.appointments.services;

import lombok.extern.slf4j.Slf4j;
import mts.mtech.appointments.domain.User;
import mts.mtech.appointments.dto.LoginRequest;
import mts.mtech.appointments.dto.RegisterUser;
import mts.mtech.appointments.persistence.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public User signup(RegisterUser registerUser) {
        if(!registerUser.getPassword().equals(registerUser.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        User user = new User();
        user.setEmail(registerUser.getEmail());
        user.setFullName(registerUser.getFullName());
        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        user.setRole("CLIENT");

        return userRepository.save(user);
    }

    @Override
    public User authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        return userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + request.getEmail()));
    }
}
