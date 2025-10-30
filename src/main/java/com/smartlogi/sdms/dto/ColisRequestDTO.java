package com.smartlogi.sdms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ColisRequestDTO {

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Weight is required")
    @Positive(message = "Weight must be positive")
    private Double weight;

    @NotBlank(message = "Priority is required")
    private String priority;

    @NotBlank(message = "Destination city is required")
    private String destinationCity;

    @NotNull(message = "Sender ID is required")
    private String senderId;

    @NotNull(message = "Recipient ID is required")
    private String recipientId;

    @NotNull(message = "Zone ID is required")
    private String zoneId;
}
