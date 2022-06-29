package uz.pdp.spring_boot.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.task.Task;

@Getter
@Setter
public class TaskCommentUpdateDto extends GenericDto {


    private String message;
    private Task task;
    @Builder(builderMethodName = "childBuilder")

    public TaskCommentUpdateDto(Long id, String message, Task task) {
        super(id);
        this.message = message;
        this.task = task;
    }
}
