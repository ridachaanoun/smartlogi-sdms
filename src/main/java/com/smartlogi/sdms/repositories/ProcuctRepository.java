package com.smartlogi.sdms.repositories;

import com.smartlogi.sdms.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcuctRepository extends JpaRepository<Delivery, String> {
}
