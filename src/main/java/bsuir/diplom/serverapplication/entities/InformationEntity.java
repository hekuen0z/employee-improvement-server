package bsuir.diplom.serverapplication.entities;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "information")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InformationEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountsEntity accountId;

    @Column(name = "is_personal")
    private Boolean isPersonal;

    @Column(name = "is_visible")
    private Boolean isVisible;

    @Column(name = "ads")
    private String ads;

    @Column(name = "feedbacks")
    private String feedbacks;

    @Column(name = "manuals")
    private String manuals;

    @Column(name = "notes")
    private String notes;

    @Column(name = "remarks")
    private String remarks;

}
