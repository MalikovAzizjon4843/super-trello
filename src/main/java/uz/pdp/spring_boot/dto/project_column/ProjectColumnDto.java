package uz.pdp.spring_boot.dto.project_column;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.organization.Organization;

@Getter
@Setter
public class ProjectColumnDto extends GenericDto {

    private String name;
    private String tzPath;
    private Organization organization;
    private Boolean closed;


    @Builder(builderMethodName = "childBuilder")
    public ProjectColumnDto(Long id, String name, String tzPath, Organization organization, Boolean closed) {
        super(id);
        this.name = name;
        this.tzPath = tzPath;
        this.organization = organization;
        this.closed = closed;
        }
}

