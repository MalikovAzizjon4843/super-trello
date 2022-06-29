package uz.pdp.spring_boot.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;

@Getter
@Setter
public class OrganizationDto extends GenericDto {

    private String name;
    private String logo;
    private String code;
    private String email;
    private String location;
    private Long owner;


    @Builder(builderMethodName = "childBuilder")
    public OrganizationDto(Long id, String name, String logo, String code, String location, String email, Long owner) {
        super(id);
        this.name = name;
        this.logo = logo;
        this.code = code;
        this.email = email;
        this.location = location;
        this.owner = owner;
    }
}

