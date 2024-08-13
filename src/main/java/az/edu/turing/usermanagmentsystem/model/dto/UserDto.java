package az.edu.turing.usermanagmentsystem.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Past
    private LocalDateTime createdAt;

    @Past
    private LocalDateTime updatedAt;

    @NotBlank
    @Size(min = 2 ,max = 50)
    private String name;

    @NotBlank
    @Size(min = 2 , max = 50)
    private String surname;

    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\+?[0-9]{7,15}")
    private String phoneNumber;

    @Past
    private LocalDateTime dateOfBirth;

    @NotNull
    private boolean gender;

}
