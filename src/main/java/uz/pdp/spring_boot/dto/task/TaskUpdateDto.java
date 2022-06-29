package uz.pdp.spring_boot.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.project.ProjectColumn;

@Getter
@Setter
@NoArgsConstructor
public class TaskUpdateDto extends GenericDto {
    private String tittle;
    private String description;
    private ProjectColumn projectColumn;
    private String level;


    @Builder(builderMethodName = "childBuilder")

    public TaskUpdateDto(Long id, String tittle, String description, ProjectColumn projectColumn, String level) {
        super(id);
        this.tittle = tittle;
        this.description = description;
        this.projectColumn = projectColumn;
        this.level = level;
    }


}
