package az.edu.turing.usermanagmentsystem.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDto {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private LocalDateTime dateOfBirth;

    private boolean gender;

}
