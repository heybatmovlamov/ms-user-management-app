package az.edu.turing.usermanagmentsystem.controller;

import az.edu.turing.usermanagmentsystem.model.dto.ProfileDto;
import az.edu.turing.usermanagmentsystem.model.dto.UserDto;
import az.edu.turing.usermanagmentsystem.service.ProfileService;
import az.edu.turing.usermanagmentsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final ProfileService profileService;

    @GetMapping("/")
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.userById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.update(id));
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteAll() {
        return ResponseEntity.ok(userService.delete);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateEmail(@PathVariable UUID id, @PathVariable String email) {
        return ResponseEntity.ok(userService.updateEmail(id, email));
    }


    @GetMapping("/{id}/profile/{id}")
    public ResponseEntity<String> findProfileByUserId(@PathVariable UUID id) {
        return ResponseEntity.ok((profileService.findProfileByUserId(id)));
    }

    @PutMapping("/{id}/profile/{id}")
    public ResponseEntity<String> updateProfile(@PathVariable UUID id) {
        return ResponseEntity.ok((profileService.updateProfile(id)));
    }

    @PatchMapping("/{id}/profile/{id}")
    public ResponseEntity<String> updateProfileById(@PathVariable UUID id,@PathVariable Enum status) {
        return ResponseEntity.ok((profileService.updateProfileById(id,status)));
    }

    @DeleteMapping("/{id}/profile/")
    public ResponseEntity<String> deleteProfile() {
        return ResponseEntity.ok((profileService.deleteProfile()));
    }

    @DeleteMapping("/{id}/profile/{id}")
    public ResponseEntity<String> deleteProfileById(@PathVariable UUID id) {
        return ResponseEntity.ok((profileService.deleteProfileById(id)));
    }

    @GetMapping("/{id}/profile/")
    public ResponseEntity<String> findAllProfiles() {
        return ResponseEntity.ok((profileService.findAllProfiles()));
    }

    @PostMapping("/{id}/profile/create")
    public ResponseEntity<String> createProfileByUserId(@PathVariable UUID id, @RequestBody ProfileDto profileDto) {
        return ResponseEntity.ok(profileService.createByUserId(id, profileDto));
    }
}
