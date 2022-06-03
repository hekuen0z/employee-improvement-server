package bsuir.diplom.serverapplication.entities;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "indicators")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IndicatorsEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountsEntity accountId;

    @Column(name = "n_shifts", nullable = false)
    private Long nShifts;

    @Column(name = "n_processing_hours", nullable = false)
    private Long nProcessingHours;

    @Column(name = "n_days_off", nullable = false)
    private Long nDaysOff;

    @Column(name = "n_sick_leave", nullable = false)
    private Long nSickLeave;

    @Column(name = "n_reprimand", nullable = false)
    private Long nReprimand;

    @Column(name = "is_reprimand")
    private Boolean isReprimand;

    @Column(name = "reprimand_date")
    private LocalDate reprimandDate;

    @Column(name = "n_encouragmnet", nullable = false)
    private Long nEncouragmnet;

    @Column(name = "encouragment_date")
    private LocalDate encouragmentDate;

    @Column(name = "shooting_score")
    private Long shootingScore;

    @Column(name = "result_in_PE")
    private Double resultInPe;

    @Column(name = "reating")
    private Float reating;

    @Column(name = "reprimand_reason")
    private String reprimandReason;

    @Column(name = "encouragment_reason")
    private String encouragmentReason;

}
