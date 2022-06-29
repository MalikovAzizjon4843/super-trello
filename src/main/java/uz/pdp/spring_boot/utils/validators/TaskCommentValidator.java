package uz.pdp.spring_boot.utils.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.project.ProjectCreateDto;
import uz.pdp.spring_boot.dto.project.ProjectUpdateDto;
import uz.pdp.spring_boot.exceptions.ValidationException;
import uz.pdp.spring_boot.utils.BaseUtils;
import uz.pdp.spring_boot.utils.validators.AbstractValidator;

@Component
public class TaskCommentValidator extends AbstractValidator<ProjectCreateDto, ProjectUpdateDto, Long> {


    @Autowired
    protected TaskCommentValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ProjectCreateDto projectCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ProjectUpdateDto cd) throws ValidationException {

    }
}
