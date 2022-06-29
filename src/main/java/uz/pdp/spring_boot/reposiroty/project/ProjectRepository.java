package uz.pdp.spring_boot.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.reposiroty.AbstractRepository;

import javax.transaction.Transactional;


public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository {
    @Modifying
    @Transactional
    @Query("update Project t set t.name=:name,t.tzPath=:tzPath where t.id=:id")
    void update(@Param("name") String name, @Param("tzPath") String tzPath, @Param("id") Long id);

    @Query(value ="from Organization o where o.id=:idd" )
    Organization findOrganizationById (Long idd);
}
