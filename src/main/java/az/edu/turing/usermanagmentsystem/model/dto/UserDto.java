package az.edu.turing.usermanagmentsystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {//todo valid field

    private UUID id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private LocalDateTime dateOfBirth;

    private boolean gender;

}
