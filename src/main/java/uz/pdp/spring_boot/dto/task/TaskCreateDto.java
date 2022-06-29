package uz.pdp.spring_boot.dto.task;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.Dto;
import java.time.Instant;

@Getter
@Setter
@Builder
public class TaskCreateDto implements Dto {
    private String tittle;
    private String description;
    private String level;

    @Builder(builderMethodName = "childBuilder")
    public TaskCreateDto(String tittle, String description,  String level) {
        this.tittle = tittle;
        this.description = description;
        this.level = level;
    }

}
