package az.edu.turing.usermanagmentsystem.mapper;

import az.edu.turing.usermanagmentsystem.model.dto.ProfileDto;
import az.edu.turing.usermanagmentsystem.model.entity.ProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper {
    ProfileMapper INSTANCE= Mappers.getMapper(ProfileMapper.class);
    ProfileDto profileToProfileDto(ProfileEntity profileEntity);
    ProfileEntity profileDtoToProfileEntity(ProfileDto profileDto);

}
