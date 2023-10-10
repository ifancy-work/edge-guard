package com.dell.dtc.edge.guard.controller;

import com.dell.dtc.edge.guard.model.request.ProvisioningRequest;
import com.dell.dtc.edge.guard.model.response.ProvisioningResponse;
import com.dell.dtc.edge.guard.service.AnomalyDetectionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/provision")
public class ProvisionController {

    private final AnomalyDetectionServiceImpl anomalyDetectionServiceImpl;
    
    @PostMapping
    public ResponseEntity<ProvisioningResponse> createProvisionEdgeDevice(ProvisioningRequest provisioningRequest) {

        // Call service to send temperature data and get the response
        ProvisioningResponse provisioningResponse = anomalyDetectionServiceImpl.sendTemperatureData(provisioningRequest);

        if (provisioningResponse != null) {
            // If the response is not null, return it with a 200 OK status
            return ResponseEntity.ok(provisioningResponse);
        } else {
            // If the response is null or empty, return a 404 Not Found status with an empty ProvisioningResponse object
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ProvisioningResponse.builder().build());
        }
    }
}