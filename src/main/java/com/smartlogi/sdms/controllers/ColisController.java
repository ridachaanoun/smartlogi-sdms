package com.smartlogi.sdms.controllers;

import com.smartlogi.sdms.dto.ColisRequestDTO;
import com.smartlogi.sdms.dto.ColisResponseDTO;
import com.smartlogi.sdms.services.ColisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colis")
@RequiredArgsConstructor
public class ColisController {

    private final ColisService colisService;

    @PostMapping
    public ResponseEntity<ColisResponseDTO> createColis(@Valid @RequestBody ColisRequestDTO requestDTO) {
        ColisResponseDTO response = colisService.createColis(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ColisResponseDTO>> getAllColis() {
        return ResponseEntity.ok(colisService.getAllColis());
    }

    @PutMapping("/{colisId}/assign/{driverId}")
    public ResponseEntity<ColisResponseDTO> assignColisToDriver(
            @PathVariable String colisId,
            @PathVariable String driverId) {
        return ResponseEntity.ok(colisService.assignColisToDriver(colisId, driverId));
    }
}
