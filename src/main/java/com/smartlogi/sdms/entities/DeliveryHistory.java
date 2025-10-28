package com.smartlogi.sdms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryHistory {

    @Id
    @UuidGenerator
    private String id;
    @ManyToOne
    @JoinColumn(name = "colis_id")
    private  Colis colis;

    private String status;
    private LocalDateTime changeDate;
    private String comment;
}
