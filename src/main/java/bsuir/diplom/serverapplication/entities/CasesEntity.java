package bsuir.diplom.serverapplication.entities;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cases")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CasesEntity extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private AccountsEntity accountId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "cases_has_victims",
            joinColumns = @JoinColumn(name = "cases_id"),
            inverseJoinColumns = @JoinColumn(name = "victims_id")
    )
    private Set<VictimsEntity> victimsEntitySet = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "cases_has_criminals",
            joinColumns = @JoinColumn(name = "cases_id"),
            inverseJoinColumns = @JoinColumn(name = "criminals_id")
    )
    private Set<CriminalsEntity> criminalsEntitySet = new HashSet<>();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "term")
    private String term;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_complited")
    private Boolean isComplited;

    @Column(name = "is_suspended")
    private Boolean isSuspended;

    @Column(name = "is_rejected")
    private Boolean isRejected;

    @Column(name = "is_urgent")
    private Boolean isUrgent;

    @Column(name = "scene")
    private String scene;

    @Column(name = "article")
    private String article;

}
