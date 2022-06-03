package bsuir.diplom.serverapplication.entities;

import lombok.*;
import org.hibernate.annotations.Proxy;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "victims")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VictimsEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(mappedBy = "victimsEntitySet")
    private Set<CasesEntity> casesEntitySet = new HashSet<>();

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "third_name", nullable = false)
    private String thirdName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "mobile_phone", nullable = false)
    private Integer mobilePhone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "place_of_work")
    private String placeOfWork;

    @Column(name = "place_of_study")
    private String placeOfStudy;

    @Column(name = "education", nullable = false)
    private String education;

    @Column(name = "manital_status", nullable = false)
    private String manitalStatus;

}
