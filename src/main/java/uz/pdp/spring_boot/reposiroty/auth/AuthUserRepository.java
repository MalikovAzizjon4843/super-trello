package uz.pdp.spring_boot.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.spring_boot.entity.auth.AuthRole;
import uz.pdp.spring_boot.entity.auth.AuthUser;


public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findAuthUserByUsername(String username);


}
