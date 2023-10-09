/*
 * Copyright © 2020-2021 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package com.dell.dtc.edge.guard.controller;

import com.dell.dtc.edge.guard.model.AlertModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/v1")
public class IncidentManagementController {

    @PostMapping(value = "/alert", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlertModel> createAlert() {
        // Anomaly Detection Service - If an anomaly, such as a temperature exceeding a threshold, is detected,
        // the service calls Incident Management Service.
        // temperature,
        AlertModel model = AlertModel.builder().message("alert is working").build();
        return ResponseEntity.ok(model);
    }

    @GetMapping(value = "/alert", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAlert() {
        return ResponseEntity.ok("get alert is working");
    }

}
