package uz.pdp.spring_boot.dto.project_column;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.Dto;

@Getter
@Setter
@Builder
public class ProjectColumnCreateDto implements Dto {
    private String name;
    private String tzPath;

    @Builder(builderMethodName = "childBuilder")
    public ProjectColumnCreateDto(String name, String tzPath) {
        this.name = name;
        this.tzPath = tzPath;
    }
}