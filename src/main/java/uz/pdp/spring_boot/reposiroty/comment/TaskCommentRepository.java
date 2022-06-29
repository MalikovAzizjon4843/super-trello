package uz.pdp.spring_boot.reposiroty.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_boot.entity.task.TaskComment;
import uz.pdp.spring_boot.reposiroty.AbstractRepository;

public interface TaskCommentRepository extends JpaRepository<TaskComment, Long>, AbstractRepository {
}
