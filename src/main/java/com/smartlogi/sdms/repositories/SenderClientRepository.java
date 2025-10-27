package com.smartlogi.sdms.repositories;

import com.smartlogi.sdms.entities.SenderClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderClientRepository extends JpaRepository<SenderClient, String> {
}
