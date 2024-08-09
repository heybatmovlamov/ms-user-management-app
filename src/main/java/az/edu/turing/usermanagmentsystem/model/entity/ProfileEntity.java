package az.edu.turing.usermanagmentsystem.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
        private UUID profileId;
    @Column( nullable = false )
    private Enum status;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private byte[] profilePhoto;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDateTime lastSeenTime;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;





}
