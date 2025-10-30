package com.smartlogi.sdms.repositories;

import com.smartlogi.sdms.entities.Delivery;
import com.smartlogi.sdms.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, String> {
}
