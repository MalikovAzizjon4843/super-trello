package uz.pdp.spring_boot.utils.validators.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.auth.UserCreateDto;
import uz.pdp.spring_boot.dto.auth.UserUpdateDto;
import uz.pdp.spring_boot.dto.organization.OrganizationCreateDto;
import uz.pdp.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.pdp.spring_boot.exceptions.ValidationException;
import uz.pdp.spring_boot.utils.BaseUtils;
import uz.pdp.spring_boot.utils.validators.AbstractValidator;


@Component
public class UserValidator extends AbstractValidator<UserCreateDto, UserUpdateDto, Long> {

    protected UserValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(UserCreateDto userCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(UserUpdateDto cd) throws ValidationException {

    }
}
