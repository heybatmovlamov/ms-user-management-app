package az.edu.turing.usermanagmentsystem.service;

import az.edu.turing.usermanagmentsystem.exception.UserNotFoundException;
import az.edu.turing.usermanagmentsystem.mapper.UserMapper;
import az.edu.turing.usermanagmentsystem.model.dto.UserDto;
import az.edu.turing.usermanagmentsystem.model.entity.UserEntity;
import az.edu.turing.usermanagmentsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserMapper mapper;

    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        List<UserEntity> all = userRepository.findAll();
        List<UserDto> userDto = mapper.entityListToDtoList(all);
        if (userDto == null) {
            throw new UserNotFoundException("Aybeniz Tapılmadı");
        }
        return userDto;
    }

    public UserDto create(UserDto userDto) {

        UserEntity userEntity = mapper.dtoToEntity(userDto);
        UserEntity savedEntity = userRepository.save(userEntity);
        UserDto savedDto = mapper.entityToDto(savedEntity);

        return savedDto;
    }

    public Optional<UserDto> userById(UUID id) {
        return userRepository.findById(id).map(mapper::entityToDto);
    }

    public Optional<UserDto> update(UUID id, UserDto userDto) {
        return userRepository.findById(id)// dto icerisine id daxil et yada deisdirersen
                .map(existingUser -> {
                    UserEntity updatedUserEntity = mapper.dtoToEntity(userDto);
                    UserEntity savedEntity = userRepository.save(updatedUserEntity);
                    return Optional.of(mapper.entityToDto(savedEntity));
                }).orElseThrow(() -> new UserNotFoundException("User not found"));

    }
    public Optional<UserDto> update2(UUID id, UserDto userDto) {
        // Müəyyən edilən id ilə istifadəçi entity-si tapılır
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));

        userEntity.setName(userDto.getName());
        userEntity.setSurname(userDto.getSurname());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setGender(userDto.isGender());
        userEntity.setDateOfBirth(userDto.getDateOfBirth());
        userEntity.setPhoneNumber(userDto.getPhoneNumber());

        // Yenilənmiş entity verilənlər bazasına saxlanılır
        userRepository.save(userEntity);

        // Yenilənmiş entity-dən DTO yaradılır və qaytarılır
        UserDto updatedUserDto = mapper.entityToDto(userEntity);
        return Optional.of(updatedUserDto);
    }

    public boolean deleteAll() {
        return false ;//todo
    }

    public boolean deleteById(UUID id) {
        return userRepository.findById(id)
                .map(userEntity -> {
                    userRepository.delete(userEntity);
        return true;
                }).orElse(false);}


    public Optional<UserDto> updateEmail(UUID id , String email) {
        return userRepository.findById(id)
                .map(userEntity -> {
                    userEntity.setEmail(email);
                    UserEntity savedEntity = userRepository.save(userEntity);
                    return Optional.of(mapper.entityToDto(savedEntity));
                }).orElseThrow(() -> new UserNotFoundException("User not found"));

    }
}
