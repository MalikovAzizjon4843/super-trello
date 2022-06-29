package uz.pdp.spring_boot.utils.validators.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.task.TaskCreateDto;
import uz.pdp.spring_boot.dto.task.TaskUpdateDto;
import uz.pdp.spring_boot.exceptions.ValidationException;
import uz.pdp.spring_boot.utils.BaseUtils;
import uz.pdp.spring_boot.utils.validators.AbstractValidator;

@Component
public class TaskValidator extends AbstractValidator<TaskCreateDto, TaskUpdateDto, Long> {

    @Autowired
    protected TaskValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(TaskCreateDto taskCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(TaskUpdateDto cd) throws ValidationException {

    }
}
