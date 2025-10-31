package com.smartlogi.sdms.dto;

import com.smartlogi.sdms.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ColisResponseDTO {

    private String id;
    private String description;
    private double weight;
    private ColieStatus status;
    private String priority;
    private String destinationCity;

    private SenderClient senderClient;
    private Recipient recipient;
    private Zone zone;
    private Delivery delivery;
}
