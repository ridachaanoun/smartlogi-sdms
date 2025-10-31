package com.smartlogi.sdms.repositories;

import com.smartlogi.sdms.entities.ColieStatus;
import com.smartlogi.sdms.entities.Colis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColisRepository extends JpaRepository<Colis, String> {


    List<Colis> findBySenderClient_IdAndStatus(String senderClientId, ColieStatus status);

    List<Colis> findBySenderClient_Id(String senderClientId);
}
