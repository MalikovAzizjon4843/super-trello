package uz.pdp.spring_boot.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.auth.AuthRole;

import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
public class UserUpdateDto extends GenericDto {
    private String username;
    private String phone;
    private String email;
    private String language;
    //private String profileImage;
   /* private String role;*/

    @Builder(builderMethodName = "childBuilder")
    public UserUpdateDto(Long id, String username,/* String language,*/ String phone, String email/* String fullName,*/ /*String profileImage,*/ /* String role*/) {
        super(id);
        this.username = username;
        /*this.language = language;*/
        this.phone = phone;
        this.email = email;
//        this.fullName = fullName;
       // this.profileImage = profileImage;
      /*  this.role = role;*/
    }
}
