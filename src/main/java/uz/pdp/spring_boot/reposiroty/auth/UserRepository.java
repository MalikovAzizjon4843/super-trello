package uz.pdp.spring_boot.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.spring_boot.entity.auth.AuthRole;
import uz.pdp.spring_boot.entity.auth.AuthUser;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.reposiroty.AbstractRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {

    @Query(value = "from  AuthRole r where r.code=:roleName")
    AuthRole findRoleByName(String roleName);

    @Query(value = "from Organization o where o.id=:idd")
    Organization findOrganizationById(Long idd);

    @Modifying
    @Transactional
    @Query("update AuthUser t set t.username=:username,t.phone=:phone, t.email=:email,t.language=:language where t.id=:id")
    void update(@Param("username") String username,
                @Param("phone") String phone,
                @Param("email") String email,
                @Param("language") String language,
               /* @Param("role") String role,*/
                @Param("id") Long id);
}
