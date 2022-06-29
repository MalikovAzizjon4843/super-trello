package uz.pdp.spring_boot.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.comment.TaskCommentCreateDto;
import uz.pdp.spring_boot.dto.comment.TaskCommentDto;
import uz.pdp.spring_boot.dto.comment.TaskCommentUpdateDto;
import uz.pdp.spring_boot.entity.task.TaskComment;

@Component
@Mapper(componentModel = "spring")
public interface ProjectColumnMapper extends BaseMapper<
        TaskComment,
        TaskCommentDto,
        TaskCommentCreateDto,
        TaskCommentUpdateDto>{



    @Override
    default TaskComment fromCreateDto(TaskCommentCreateDto dto) {
        return null;
    }

    @Override
    default TaskComment fromUpdateDto(TaskCommentUpdateDto taskCommentUpdateDto) {
        return null;
    }
}
