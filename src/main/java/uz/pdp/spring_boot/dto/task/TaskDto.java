package uz.pdp.spring_boot.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.project.ProjectColumn;
import java.time.Instant;

@Getter
@Setter
public class TaskDto extends GenericDto {
    private String tittle;
    private String description;
    private ProjectColumn projectColumn;
    private Integer orders;
    private String level;


    @Builder(builderMethodName = "childBuilder")
    public TaskDto(Long id, String tittle, String description, ProjectColumn projectColumn, Integer orders, String level) {
        super(id);
        this.tittle = tittle;
        this.description = description;
        this.projectColumn = projectColumn;
        this.orders = orders;
        this.level = level;
    }
}

