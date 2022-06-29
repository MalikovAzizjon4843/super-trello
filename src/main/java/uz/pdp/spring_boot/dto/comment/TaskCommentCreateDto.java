package uz.pdp.spring_boot.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.Dto;
import uz.pdp.spring_boot.entity.task.Task;

@Getter
@Setter
public class TaskCommentCreateDto implements Dto {


    private String message;
    private Task task;

    @Builder(builderMethodName = "childBuilder")
    public TaskCommentCreateDto(String message, Task task) {
        this.message = message;
        this.task = task;
    }
}
