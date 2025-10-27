package com.smartlogi.sdms.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Delivery {

    @Id
    @UuidGenerator
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String vehicle;
    private String assignedZone;
}

