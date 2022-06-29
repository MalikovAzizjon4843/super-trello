package uz.pdp.spring_boot.dto.organization;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot.dto.GenericDto;

@Getter
@Setter
@NoArgsConstructor
public class OrganizationUpdateDto extends GenericDto {
    private String name;
    private String code;
    private String email;



    @Builder(builderMethodName = "childBuilder")
    public OrganizationUpdateDto(Long id, String name, String code, String email) {
        super(id);
        this.name = name;
        this.code = code;
        this.email = email;
    }
}
