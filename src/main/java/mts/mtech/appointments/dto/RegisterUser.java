package mts.mtech.appointments.dto;

import lombok.*;



@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;
}
