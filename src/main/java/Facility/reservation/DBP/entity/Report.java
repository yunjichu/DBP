package Facility.reservation.DBP.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "REPORT")
@Getter
@Setter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPORT_ID")
    private Long reportId;

    @Column(name = "RESERVATION_ID", length = 25)
    private String reservationId;

    @Lob
    @Column(name = "REPORT_CONTENT")
    private String reportContent;

    @Column(name = "PROCESSING_STATUS", length = 100)
    private String processingStatus;
}

