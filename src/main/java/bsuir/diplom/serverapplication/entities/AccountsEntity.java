package bsuir.diplom.serverapplication.entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AccountsEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "integer auto_increment")
    private Integer id;

    @OneToMany(mappedBy = "accountId", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @ToString.Exclude
    private Set<InformationEntity> informationEntitySet = new HashSet<>();

    @OneToMany(mappedBy = "accountId", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @ToString.Exclude
    private Set<IndicatorsEntity> indicatorsEntitySet = new HashSet<>();

    @OneToMany(mappedBy = "accountId", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @ToString.Exclude
    private Set<CasesEntity> casesEntitySet = new HashSet<>();

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "third_name")
    private String thirdName;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "work_phone", nullable = false)
    private Long workPhone;

    @Column(name = "is_online")
    private Boolean isOnline;

    @Column(name = "is_officer")
    private Boolean isOfficer;

    @Column(name = "is_chief")
    private Boolean isChief;
}
