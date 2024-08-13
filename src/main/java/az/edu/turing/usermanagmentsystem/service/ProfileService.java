package az.edu.turing.usermanagmentsystem.service;

import az.edu.turing.usermanagmentsystem.mapper.ProfileMapper;
import az.edu.turing.usermanagmentsystem.model.dto.ProfileDto;
import az.edu.turing.usermanagmentsystem.model.entity.ProfileEntity;
import az.edu.turing.usermanagmentsystem.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Slf4j
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

    public Optional<ProfileDto >createProfileByUserId(UUID id , ProfileDto profileDto) {
        ProfileEntity profileEntity = profileMapper.dtoToEntity(profileDto);
        profileEntity.setId(id);
        profileEntity.setCreatedAt(LocalDateTime.now());
        profileEntity.setUpdatedAt(LocalDateTime.now());
        ProfileEntity savedProfile = profileRepository.save(profileEntity);
        log.info("Profile created with id " + savedProfile.getId());
        return Optional.ofNullable(profileMapper.entityToDto(savedProfile));
    }


    public Optional<ProfileDto> updateProfile( ProfileDto profileDto){

        return profileRepository.findById(profileDto.getId()).map(existingProfile -> {
            ProfileEntity updatedProfile = profileMapper.dtoToEntity(profileDto);
            updatedProfile.setId(existingProfile.getId());
            updatedProfile.setUpdatedAt(LocalDateTime.now());
            profileRepository.save(updatedProfile);
            return profileMapper.entityToDto(updatedProfile);
        });

    }

    public Optional<ProfileDto> updateProfileStatusById(UUID id,ProfileDto profileDto) {
        log.info("updateProfileStatusById");
        return profileRepository.findById(id).map(existingProfile -> {
            ProfileEntity updatedProfile = profileMapper.dtoToEntity(profileDto);
            updatedProfile.setId(existingProfile.getId());
            updatedProfile.setUpdatedAt(LocalDateTime.now());
            profileRepository.save(updatedProfile);
            return profileMapper.entityToDto(updatedProfile);
        });

    }
    public Optional<ProfileDto> findProfileByUserId(UUID id ){
        log.info("Find profile by id: "+id);
        return profileRepository.findById(id).map(profileMapper::entityToDto);


    }

    public boolean deleteAllProfile() {
        log.info("Deleting all profiles");
        return true;

    }//todo


    public boolean deleteProfileById(UUID id) {
        return profileRepository.findById(id).map(profile -> {
            profileRepository.delete(profile);
            log.info("Profile with id {} deleted", id);
            return true;
        }).orElse(false);
    }
    }//todo

