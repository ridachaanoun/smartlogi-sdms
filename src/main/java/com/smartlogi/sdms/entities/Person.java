package com.smartlogi.sdms.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor

public abstract class Person {

    @Id
    @UuidGenerator
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
