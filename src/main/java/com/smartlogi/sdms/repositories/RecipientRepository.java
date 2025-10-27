package com.smartlogi.sdms.repositories;

import com.smartlogi.sdms.entities.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient, String> {
}
