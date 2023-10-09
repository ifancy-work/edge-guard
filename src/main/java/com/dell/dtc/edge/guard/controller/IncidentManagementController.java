/*
 * Copyright © 2020-2021 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package com.dell.dtc.edge.guard.controller;

import com.dell.dtc.edge.guard.model.AlertModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidentManagementController {

    @PostMapping("/api/v1/alert")
    public ResponseEntity<AlertModel> createAlert() {
        AlertModel model = AlertModel.builder().message("alert is working").build();
        return ResponseEntity.ok(model);
    }

}

