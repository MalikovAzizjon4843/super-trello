package uz.pdp.spring_boot.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "task_level", schema = "task")
public class TaskLevel implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
