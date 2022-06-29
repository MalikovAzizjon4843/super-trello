package uz.pdp.spring_boot.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_boot.entity.auth.AuthRole;

public interface RoleRepository extends JpaRepository<AuthRole,Long> {
}
