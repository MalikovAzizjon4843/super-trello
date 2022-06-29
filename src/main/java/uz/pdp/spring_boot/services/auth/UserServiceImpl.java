package uz.pdp.spring_boot.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.UserCreateDto;
import uz.pdp.spring_boot.dto.auth.UserDto;
import uz.pdp.spring_boot.dto.auth.UserUpdateDto;
import uz.pdp.spring_boot.entity.auth.AuthUser;
import uz.pdp.spring_boot.mapper.UserMapper;
import uz.pdp.spring_boot.reposiroty.auth.UserRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.services.organization.file.FileStorageService;
import uz.pdp.spring_boot.utils.BaseUtils;
import uz.pdp.spring_boot.utils.validators.auth.UserValidator;

import java.util.List;



@Service
public class UserServiceImpl extends AbstractService<UserRepository, UserMapper, UserValidator> implements UserService {

    private final FileStorageService fileStorageService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    protected UserServiceImpl(UserRepository repository, UserMapper mapper, UserValidator validator, BaseUtils baseUtils, FileStorageService fileStorageService, PasswordEncoder passwordEncoder) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Long create(UserCreateDto createDto) {
        MultipartFile file = createDto.getProfileImage();
        String imgPath = fileStorageService.store(file);
        AuthUser authUser = mapper.fromCreateDto(createDto);
        authUser.setProfileImage(imgPath);
        authUser.setOrganization(repository.findOrganizationById(createDto.getOrganizationId()));
        authUser.setPassword(passwordEncoder.encode(createDto.getPassword()));
//        authUser.setActive(true);
        authUser.setRole(repository.findRoleByName(createDto.getRole()));
        repository.save(authUser);
        return authUser.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(UserUpdateDto updateDto) {
        repository.update
                        (updateDto.getUsername(),
                        updateDto.getPhone(),
                        updateDto.getEmail(),
                        updateDto.getLanguage(),
                        /* updateDto.getRole(),*/
                        updateDto.getId());
        return null;
    }

    @Override
    public List<UserDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public UserDto get(Long id) {
        AuthUser user = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("User Topilmadi");
        });
        UserDto dto = mapper.toDto(user);
        return dto;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
