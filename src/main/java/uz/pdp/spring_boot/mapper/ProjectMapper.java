package uz.pdp.spring_boot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.project.ProjectCreateDto;
import uz.pdp.spring_boot.dto.project.ProjectDto;
import uz.pdp.spring_boot.dto.project.ProjectUpdateDto;
import uz.pdp.spring_boot.entity.project.Project;

@Component
@Mapper(componentModel = "spring")
public interface ProjectMapper extends BaseMapper<
        Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto> {

    @Override
    @Mapping(target = "tzPath", ignore = true)
    @Mapping(target = "organization", ignore = true)
    Project fromCreateDto(ProjectCreateDto projectCreateDto);

    @Override
    @Mapping(target = "tzPath", ignore = true)
    @Mapping(target = "organization", ignore = true)
    Project fromUpdateDto(ProjectUpdateDto projectUpdateDto);
}
