package az.edu.turing.usermanagmentsystem.service;

import az.edu.turing.usermanagmentsystem.mapper.ProfileMapper;
import az.edu.turing.usermanagmentsystem.model.dto.ProfileDto;
import az.edu.turing.usermanagmentsystem.model.dto.UserDto;
import az.edu.turing.usermanagmentsystem.model.entity.ProfileEntity;
import az.edu.turing.usermanagmentsystem.model.entity.UserEntity;
import az.edu.turing.usermanagmentsystem.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class ProfileService {
    private final ProfileMapper profileMapper;
    private final ProfileRepository profileRepository;


    public List<ProfileDto> findAllProfiles() {
        List<ProfileEntity> profiles = profileRepository.findAll();
       List<ProfileDto> profileDto= profileMapper.entityListToDtoList(profiles);
       return profileDto;

    }

    public Optional<ProfileDto >createProfileByUserId(ProfileDto profileDto) {
        ProfileEntity profileEntity = profileMapper.dtoToEntity(profileDto);
        profileEntity.setCreatedAt(LocalDateTime.now());
        profileEntity.setUpdatedAt(LocalDateTime.now());
        ProfileEntity savedProfile = profileRepository.save(profileEntity);
        return Optional.ofNullable(profileMapper.entityToDto(savedProfile));
    }


    public Optional<ProfileDto> updateProfile( ProfileDto profileDto){
        UUID id = profileDto.getId();
        return profileRepository.findById(id).map(existingProfile -> {
            ProfileEntity updatedProfile = profileMapper.dtoToEntity(profileDto);
            updatedProfile.setId(existingProfile.getId());
            updatedProfile.setUpdatedAt(LocalDateTime.now());
            profileRepository.save(updatedProfile);
            return profileMapper.entityToDto(updatedProfile);
        });

    }

    public Optional<ProfileDto> updateProfileById(UUID id,ProfileDto profileDto) {
        return profileRepository.findById(id).map(existingProfile -> {
            ProfileEntity updatedProfile = profileMapper.dtoToEntity(profileDto);
            updatedProfile.setId(existingProfile.getId());
            updatedProfile.setUpdatedAt(LocalDateTime.now());
            profileRepository.save(updatedProfile);
            return profileMapper.entityToDto(updatedProfile);
        });

    }
    public Optional<ProfileDto> findProfileByUserId(UUID id ){
        return profileRepository.findById(id).map(profileMapper::entityToDto);


    }

    public boolean deleteProfile() {
        return false;
    }//todo


    public boolean deleteProfileById(UUID id) {
        return profileRepository.findById(id).map(profile -> {
            profileRepository.delete(profile);
            return true;
        }).orElse(false);
    }
    }//todo

