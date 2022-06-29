package uz.pdp.spring_boot.services.task;

import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.project.ProjectCreateDto;
import uz.pdp.spring_boot.dto.project.ProjectDto;
import uz.pdp.spring_boot.dto.project.ProjectUpdateDto;
import uz.pdp.spring_boot.dto.task.TaskCreateDto;
import uz.pdp.spring_boot.dto.task.TaskDto;
import uz.pdp.spring_boot.dto.task.TaskUpdateDto;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.entity.task.Task;
import uz.pdp.spring_boot.services.GenericCrudService;

public interface TaskService extends GenericCrudService<
        Task,
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto,
        GenericCriteria,
        Long> {


}
