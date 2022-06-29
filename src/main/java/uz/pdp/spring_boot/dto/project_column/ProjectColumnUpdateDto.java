package uz.pdp.spring_boot.dto.project_column;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProjectColumnUpdateDto extends GenericDto {
    private String name;
    private String tzPath;



    @Builder(builderMethodName = "childBuilder")
    public ProjectColumnUpdateDto(Long id, String name, String tzPath) {
        super(id);
        this.name = name;
        this.tzPath = tzPath;

        List<Integer> re = new ArrayList<>();

    }
}
