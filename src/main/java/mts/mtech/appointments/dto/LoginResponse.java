package mts.mtech.appointments.dto;

import lombok.*;
import mts.mtech.appointments.domain.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginResponse {
    private String token;
    private long expiresIn;
    private User userData;
}