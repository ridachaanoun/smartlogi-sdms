package com.smartlogi.sdms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Colis {

    @Id
    @UuidGenerator
    private String id;

    private String description;
    private double weight;
    private ColieStatus status;
    private String priority;
    private String destinationCity;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private SenderClient senderClient;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;
}
