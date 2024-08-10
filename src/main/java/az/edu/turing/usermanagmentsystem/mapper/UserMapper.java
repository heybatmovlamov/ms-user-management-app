package az.edu.turing.usermanagmentsystem.mapper;

import az.edu.turing.usermanagmentsystem.model.dto.UserDto;
import az.edu.turing.usermanagmentsystem.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper

public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        UserDto userEntityToUserDto(UserEntity userEntity);
        UserEntity userDtoToUserEntity(UserDto userDto);
}
