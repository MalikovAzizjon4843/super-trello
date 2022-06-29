package uz.pdp.spring_boot.services.project;

import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.project.ProjectCreateDto;
import uz.pdp.spring_boot.dto.project.ProjectDto;
import uz.pdp.spring_boot.dto.project.ProjectUpdateDto;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.services.GenericCrudService;

public interface ProjectService extends GenericCrudService<
        Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        GenericCriteria,
        Long> {


}
