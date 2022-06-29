package uz.pdp.spring_boot.services.comment;

import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.comment.TaskCommentCreateDto;
import uz.pdp.spring_boot.dto.comment.TaskCommentDto;
import uz.pdp.spring_boot.dto.comment.TaskCommentUpdateDto;
import uz.pdp.spring_boot.entity.task.TaskComment;
import uz.pdp.spring_boot.services.GenericCrudService;

public interface TaskCommentService extends GenericCrudService<
        TaskComment,
        TaskCommentDto,
        TaskCommentCreateDto,
        TaskCommentUpdateDto,
        GenericCriteria,
        Long> {


}
