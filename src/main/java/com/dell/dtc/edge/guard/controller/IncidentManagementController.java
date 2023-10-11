/*
 * Copyright © 2020-2021 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package com.dell.dtc.edge.guard.controller;

import com.dell.dtc.edge.guard.model.AlertRequest;
import com.dell.dtc.edge.guard.model.AlertResponse;
import com.dell.dtc.edge.guard.service.impl.IncidentManagementServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class IncidentManagementController {

    private final IncidentManagementServiceImpl incidentManagementService;

    @PostMapping("/alert")
    public ResponseEntity<AlertResponse> createAlert(@RequestBody AlertRequest alertRequest) {

        // Call service to send alert data and get the response
        AlertResponse alertResponse = incidentManagementService.createAlert(alertRequest);

        if (alertResponse != null) {
            // If the response is not null, return it with a 200 OK status
            return ResponseEntity.ok(alertResponse);
        } else {
            // If the response is null or empty, return a 404 Not Found status with an empty AlertResponse object
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AlertResponse.builder().build());
        }

    }

}

