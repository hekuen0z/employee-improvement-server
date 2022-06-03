package bsuir.diplom.serverapplication.entities;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "criminals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CriminalsEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(mappedBy = "criminalsEntitySet")
    private Set<CasesEntity> casesEntitySet = new HashSet<>();

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "third_name")
    private String thirdName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "mobile_phone")
    private Long mobilePhone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "location")
    private String location;

    @Column(name = "is_hiding")
    private Boolean isHiding;

    @Column(name = "is_detained")
    private Boolean isDetained;

    @Column(name = "is_justified")
    private Boolean isJustified;

}
