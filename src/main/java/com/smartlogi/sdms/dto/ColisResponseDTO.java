package com.smartlogi.sdms.dto;

import com.smartlogi.sdms.entities.ColieStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ColisResponseDTO {

    private String id;
    private String description;
    private double weight;
    private ColieStatus status;
    private String priority;
    private String destinationCity;

    private String senderName;
    private String recipientName;
    private String zoneName;
    private String deliveryDriverName;
}
