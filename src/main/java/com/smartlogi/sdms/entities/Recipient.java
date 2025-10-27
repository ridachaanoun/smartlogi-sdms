package com.smartlogi.sdms.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Recipient extends Person {
    
}
