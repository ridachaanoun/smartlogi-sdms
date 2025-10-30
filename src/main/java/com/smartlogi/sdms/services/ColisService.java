package com.smartlogi.sdms.services;

import com.smartlogi.sdms.dto.ColisRequestDTO;
import com.smartlogi.sdms.dto.ColisResponseDTO;
import com.smartlogi.sdms.entities.*;
//import com.smartlogi.sdms.exceptions.ResourceNotFoundException;
import com.smartlogi.sdms.exceptions.ResourceNotFoundException;
import com.smartlogi.sdms.repositories.ColisRepository;
import com.smartlogi.sdms.repositories.RecipientRepository;
import com.smartlogi.sdms.repositories.SenderClientRepository;
import com.smartlogi.sdms.repositories.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColisService {

    private final ColisRepository colisRepository;
    private final SenderClientRepository senderClientRepository;
    private final RecipientRepository recipientRepository;
    private final ZoneRepository zoneRepository;

    public ColisResponseDTO createColis(ColisRequestDTO dto) {

        SenderClient sender = senderClientRepository.findById(dto.getSenderId())
                .orElseThrow(() -> new ResourceNotFoundException("Sender not found with ID: " + dto.getSenderId()));

        Recipient recipient = recipientRepository.findById(dto.getRecipientId())
                .orElseThrow(() -> new ResourceNotFoundException("Recipient not found with ID: " + dto.getRecipientId()));

        Zone zone = zoneRepository.findById(dto.getZoneId())
                .orElseThrow(()->new ResourceNotFoundException("Zone not found with Id" + dto.getZoneId()));

        Colis colis = new Colis();
        colis.setDescription(dto.getDescription());
        colis.setWeight(dto.getWeight());
        colis.setPriority(dto.getPriority());
        colis.setDestinationCity(dto.getDestinationCity());
        colis.setStatus(ColieStatus.CREATED);
        colis.setSenderClient(sender);
        colis.setRecipient(recipient);
        colis.setZone(zone);

        Colis saved = colisRepository.save(colis);

        return ColisResponseDTO.builder()
                .id(saved.getId())
                .description(saved.getDescription())
                .weight(saved.getWeight())
                .status(saved.getStatus())
                .priority(saved.getPriority())
                .destinationCity(saved.getDestinationCity())
                .senderName(saved.getSenderClient().getFirstName() + " " + saved.getSenderClient().getLastName())
                .recipientName(saved.getRecipient().getFirstName() + " " + saved.getRecipient().getLastName())
                .zoneName(saved.getZone().getName())
                .build();
    }
}
