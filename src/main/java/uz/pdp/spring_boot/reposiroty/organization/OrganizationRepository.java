package uz.pdp.spring_boot.reposiroty.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.reposiroty.AbstractRepository;

import javax.transaction.Transactional;

public interface OrganizationRepository extends JpaRepository<Organization, Long>, AbstractRepository {
    @Modifying
    @Transactional
    @Query("update Organization t set t.name=:name,t.email=:email,t.code=:code where t.id = :id")
    void update(@Param("name") String name, @Param("email") String email, @Param("code") String code, @Param("id") Long id);
}
