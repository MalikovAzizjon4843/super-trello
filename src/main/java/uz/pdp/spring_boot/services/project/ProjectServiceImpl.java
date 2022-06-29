package uz.pdp.spring_boot.services.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot.configs.security.UserDetails;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.project.ProjectCreateDto;
import uz.pdp.spring_boot.dto.project.ProjectDto;
import uz.pdp.spring_boot.dto.project.ProjectUpdateDto;
import uz.pdp.spring_boot.entity.auth.AuthUser;
import uz.pdp.spring_boot.entity.project.*;
import uz.pdp.spring_boot.mapper.ProjectMapper;
import uz.pdp.spring_boot.reposiroty.project.ProjectRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.services.organization.file.FileStorageService;
import uz.pdp.spring_boot.utils.BaseUtils;
import uz.pdp.spring_boot.utils.validators.project.ProjectValidator;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractService<ProjectRepository, ProjectMapper, ProjectValidator
        >
        implements ProjectService {

    private final FileStorageService fileStorageService;

    @Autowired
    protected ProjectServiceImpl(ProjectRepository repository, ProjectMapper mapper, ProjectValidator validator, BaseUtils baseUtils, FileStorageService fileStorageService) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Long create(ProjectCreateDto createDto) {
        MultipartFile file = createDto.getTzPath();
        String tzPath = fileStorageService.store(file);
        Project project = mapper.fromCreateDto(createDto);
        project.setTzPath(tzPath);
        AuthUser authUser  = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        project.setOrganization(authUser.getOrganization());
        project.setCreateby(authUser.getId());
        repository.save(project);
        return project.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(ProjectUpdateDto updateDto) {
        repository.update(updateDto.getName(), updateDto.getTzPath(), updateDto.getId());
        return null;
    }

    @Override
    public List<ProjectDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ProjectDto get(Long id) {
        Project project = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });
        ProjectDto dto = mapper.toDto(project);
        return dto;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
