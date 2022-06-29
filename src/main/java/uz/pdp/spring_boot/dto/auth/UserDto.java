package uz.pdp.spring_boot.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.auth.AuthRole;
import uz.pdp.spring_boot.entity.organization.Organization;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;


@Getter
@Setter
public class UserDto extends GenericDto {
    private String username;
    private String password;
    private String language;
    private String phone;
    private String email;
    private String fullName;
    private String profileImage;
    private Timestamp created_at;
    private boolean active;
    private boolean blocked;
    private Organization organization;
    private AuthRole role;

    @Builder(builderMethodName = "childBuilder")
    public UserDto(Long id, String username, String password, String language, String phone, String email, String fullName, String profileImage, Timestamp created_at, boolean active, boolean blocked, Organization organization, AuthRole role) {
        super(id);
        this.username = username;
        this.password = password;
        this.language = language;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.profileImage = profileImage;
        this.created_at = created_at;
        this.active = active;
        this.blocked = blocked;
        this.organization = organization;
        this.role = role;
    }
}
