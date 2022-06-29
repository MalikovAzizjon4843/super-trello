package uz.pdp.spring_boot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.auth.UserCreateDto;
import uz.pdp.spring_boot.dto.auth.UserDto;
import uz.pdp.spring_boot.dto.auth.UserUpdateDto;
import uz.pdp.spring_boot.entity.auth.AuthUser;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<
        AuthUser,
        UserDto,
        UserCreateDto,
        UserUpdateDto> {

    @Override
    @Mapping(target = "profileImage", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "organization", ignore = true)
    AuthUser fromCreateDto(UserCreateDto userCreateDto);

    @Override
    @Mapping(target = "profileImage", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "organization", ignore = true)
    AuthUser fromUpdateDto(UserUpdateDto userUpdateDto);
}