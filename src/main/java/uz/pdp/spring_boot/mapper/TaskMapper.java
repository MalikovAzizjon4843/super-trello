package uz.pdp.spring_boot.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.task.TaskCreateDto;
import uz.pdp.spring_boot.dto.task.TaskDto;
import uz.pdp.spring_boot.dto.task.TaskUpdateDto;
import uz.pdp.spring_boot.entity.task.Task;

@Component
@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<
        Task,
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto> {

    @Override
    Task fromCreateDto(TaskCreateDto taskCreateDto);

    @Override
    Task fromUpdateDto(TaskUpdateDto taskUpdateDto);
}
