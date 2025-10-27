package com.smartlogi.sdms.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Zone {

    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String postalCode;
}

