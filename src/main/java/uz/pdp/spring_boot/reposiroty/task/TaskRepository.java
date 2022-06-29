package uz.pdp.spring_boot.reposiroty.task;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.spring_boot.entity.task.Task;
import uz.pdp.spring_boot.entity.task.TaskLevel;
import uz.pdp.spring_boot.reposiroty.AbstractRepository;

import javax.transaction.Transactional;

public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {
    @Modifying
    @Transactional
    @Query("update Task t set t.tittle=:tittle,t.description=:description where t.id=:id")
    void update(@Param("tittle") String tittle,
                @Param("description") String description,
                // @Param("deadline") Instant deadline,
            /*@Param("level") Level level,*/
                @Param("id") Long id);


    @Query(value = "from  TaskLevel r where r.code=:taskLevelName")
    TaskLevel findLevelByName(String taskLevelName);

}
