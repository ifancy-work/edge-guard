/*
 * Copyright © 2020-2021 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package com.dell.dtc.edge.guard.controller;

import com.dell.dtc.edge.guard.generated.api.IncidentManagementApi;
import com.dell.dtc.edge.guard.generated.models.AlertModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidentManagementController implements IncidentManagementApi {

    @Override
    public ResponseEntity<AlertModel> createAlert() {
        // Anomaly Detection Service - If an anomaly, such as a temperature exceeding a threshold, is detected,
        // the service calls Incident Management Service.
        // temperature,
        AlertModel model = AlertModel.builder().message("alert is working").build();
        return ResponseEntity.ok(model);
    }

}
