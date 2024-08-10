package az.edu.turing.usermanagmentsystem.model.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity(name = "profiles")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column( name = "status", nullable = false )
    private Enum status;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "profile_photo", nullable = false)
    private byte[] profilePhoto;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "last_seen_time", nullable = false)
    private LocalDateTime lastSeenTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
