package uz.pdp.spring_boot.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.BaseEntity;
import uz.pdp.spring_boot.entity.organization.Organization;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "project", schema = "project")
public class Project implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "tz_path")
    private String tzPath;

    @OneToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(name = "closed")
    private Boolean closed;

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