package uz.pdp.spring_boot.services.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.comment.TaskCommentCreateDto;
import uz.pdp.spring_boot.dto.comment.TaskCommentDto;
import uz.pdp.spring_boot.dto.comment.TaskCommentUpdateDto;
import uz.pdp.spring_boot.entity.task.TaskComment;
import uz.pdp.spring_boot.mapper.TaskCommentMapper;
import uz.pdp.spring_boot.reposiroty.comment.TaskCommentRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.utils.BaseUtils;
import uz.pdp.spring_boot.utils.validators.TaskCommentValidator;

import java.util.List;

@Service
public class TaskCommentServiceImpl extends AbstractService<TaskCommentRepository, TaskCommentMapper, TaskCommentValidator
        >
        implements TaskCommentService {


    @Autowired
    protected TaskCommentServiceImpl(TaskCommentRepository repository, TaskCommentMapper mapper, TaskCommentValidator validator, BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }


    @Override
    public List<TaskCommentDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }


    @Override
    public TaskCommentDto get(Long id) {
        return mapper.toDto(repository.getById(id));
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    @Override
    public Long create(TaskCommentCreateDto createDto) {
        TaskComment taskComment = mapper.fromCreateDto(createDto);

        repository.save(taskComment);
        return null;
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(TaskCommentUpdateDto updateDto) {
        TaskComment taskComment = mapper.fromUpdateDto(updateDto);
        repository.save(taskComment);
        return null;
    }
}
