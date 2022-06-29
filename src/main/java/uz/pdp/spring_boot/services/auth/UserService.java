package uz.pdp.spring_boot.services.auth;

import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.UserCreateDto;
import uz.pdp.spring_boot.dto.auth.UserDto;
import uz.pdp.spring_boot.dto.auth.UserUpdateDto;
import uz.pdp.spring_boot.entity.auth.AuthUser;
import uz.pdp.spring_boot.services.GenericCrudService;

public interface UserService extends GenericCrudService<
        AuthUser,
        UserDto,
        UserCreateDto,
        UserUpdateDto,
        GenericCriteria,
        Long> {
}
