package uz.pdp.spring_boot.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.organization.Organization;

import javax.persistence.*;
import java.time.Instant;

@Setter
@Getter
@Entity
@Table(name = "project_column", schema = "project")
public class ProjectColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;



    @Column(name = "name")
    private String name;

    @Column(name = "orders")
    private Integer orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id" , referencedColumnName = "id")
    private Project project;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Convert(disableConversion = true)
    @Column(name = "createdat")
    private Instant createdat;

    @Column(name = "createby", nullable = false)
    private Long createby;

    @Convert(disableConversion = true)
    @Column(name = "updatedat")
    private Instant updatedat;

    @Column(name = "updateby")
    private Long updateby;


}