package az.edu.turing.usermanagmentsystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    private UUID id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Enum status;

    private String username;

    private byte[] profilePhoto;

    private String description;

    private LocalDateTime lastSeenTime;


}
