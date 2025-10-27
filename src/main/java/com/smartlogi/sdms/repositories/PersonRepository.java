package com.smartlogi.sdms.repositories;

import com.smartlogi.sdms.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
