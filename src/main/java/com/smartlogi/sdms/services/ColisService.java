package com.smartlogi.sdms.services;

import com.smartlogi.sdms.dto.ColisRequestDTO;
import com.smartlogi.sdms.dto.ColisResponseDTO;
import com.smartlogi.sdms.entities.*;
//import com.smartlogi.sdms.exceptions.ResourceNotFoundException;
import com.smartlogi.sdms.exceptions.ResourceNotFoundException;
import com.smartlogi.sdms.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColisService {

    private final ColisRepository colisRepository;
    private final SenderClientRepository senderClientRepository;
    private final RecipientRepository recipientRepository;
    private final ZoneRepository zoneRepository;
    private final DeliveryRepository deliveryRepository;
    private final ModelMapper modelMapper;

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

        return modelMapper.map(saved, ColisResponseDTO.class);

    }


    public List<ColisResponseDTO> getAllColis() {
        return colisRepository.findAll()
                .stream()
                .map(colis -> modelMapper.map(colis, ColisResponseDTO.class))
                .toList();
    }


    public ColisResponseDTO assignColisToDriver(String colisId, String driverId) {
        Colis colis = colisRepository.findById(colisId)
                .orElseThrow(() -> new ResourceNotFoundException("Colis not found with ID: " + colisId));

        Delivery driver = deliveryRepository.findById(driverId)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with ID: " + driverId));

        colis.setDelivery(driver);
        colis.setStatus(ColieStatus.IN_TRANSIT); // optional

        colisRepository.save(colis);

        return modelMapper.map(colis, ColisResponseDTO.class);
    }

    public List<ColisResponseDTO> getParcelsBySenderAndStatus(String senderId, ColieStatus status) {
        List<Colis> colisList;
        SenderClient senderClient = senderClientRepository.findById(senderId)
                .orElseThrow(()->new ResourceNotFoundException("Sender not found: "+senderId));

        if (status == null) {
            colisList = colisRepository.findBySenderClient_Id(senderClient.getId());
        } else {
            colisList = colisRepository.findBySenderClient_IdAndStatus(senderClient.getId(), status);
        }

        return colisList.stream()
                .map(colis -> modelMapper.map(colis, ColisResponseDTO.class))
                .toList();
    }

}
