package az.edu.turing.usermanagmentsystem.repository;

import az.edu.turing.usermanagmentsystem.model.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<ProfileEntity, UUID> {
}
