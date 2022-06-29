package uz.pdp.spring_boot.services.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.task.TaskCreateDto;
import uz.pdp.spring_boot.dto.task.TaskDto;
import uz.pdp.spring_boot.dto.task.TaskUpdateDto;
import uz.pdp.spring_boot.entity.task.Task;
import uz.pdp.spring_boot.mapper.TaskMapper;
import uz.pdp.spring_boot.reposiroty.task.TaskRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.utils.BaseUtils;
import uz.pdp.spring_boot.utils.validators.task.TaskValidator;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractService<TaskRepository, TaskMapper, TaskValidator>
        implements TaskService {


    @Autowired
    protected TaskServiceImpl(TaskRepository repository, TaskMapper mapper, TaskValidator validator, BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }

    @Override
    public Long create(TaskCreateDto createDto) {
        Task task = mapper.fromCreateDto(createDto);
        task.setDescription(createDto.getDescription());
        task.setTaskLevel(repository.findLevelByName(createDto.getLevel()));
        task.setTittle(createDto.getTittle());
        task.setCreateby(1L);
        repository.save(task);
        return 1L;
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(TaskUpdateDto updateDto) {
        repository.update(updateDto.getTittle(), updateDto.getDescription(), updateDto.getId());
        return null;
    }

    @Override
    public List<TaskDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public TaskDto get(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });
        TaskDto dto = mapper.toDto(task);
        return dto;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
