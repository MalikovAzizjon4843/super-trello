package uz.pdp.spring_boot.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.BaseEntity;
import uz.pdp.spring_boot.entity.project.ProjectColumn;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "task", schema = "task")
public class Task implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "tittle")
    private String tittle;


    @Column(name = "description")
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_column_id")
    private ProjectColumn projectColumn;


  /*  @Convert(disableConversion = true)
    @Column(name = "deadline")
    private Instant deadline;*/


    @Lob
    @Column(name = "orders")
    private Integer orders;



   /* @Convert(disableConversion = true)
    @Column(name = "created_at")
    private Instant createdat;*/

    @Column(name = "created_by")
    private Long createby;

    @Convert(disableConversion = true)
    @Column(name = "updated_at")
    private Instant updatedat;

    @Column(name = "updated_by")
    private Long updateby;

    @OneToOne
    private TaskLevel taskLevel;
}
