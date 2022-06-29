package uz.pdp.spring_boot.dto.project;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.organization.Organization;

@Getter
@Setter
@NoArgsConstructor
public class ProjectUpdateDto extends GenericDto {
    private String name;
    private String tzPath;



    @Builder(builderMethodName = "childBuilder")
    public ProjectUpdateDto(Long id, String name, String tzPath) {
        super(id);
        this.name = name;
        this.tzPath = tzPath;
    }
}
