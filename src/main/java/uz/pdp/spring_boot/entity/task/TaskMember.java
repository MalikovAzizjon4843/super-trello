package uz.pdp.spring_boot.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.project.Project;

import javax.persistence.*;
import java.time.Instant;



@Getter
@Setter
@Entity
@Table(name = "task_member", schema = "task")

public class TaskMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "user_id")
    private Long userId;



    @Convert(disableConversion = true)
    @Column(name = "created_at")
    private Instant createdat;

    @Column(name = "created_by")
    private Long createby;

    @Convert(disableConversion = true)
    @Column(name = "updated_at")
    private Instant updatedat;

    @Column(name = "updated_by")
    private Long updateby;

}
