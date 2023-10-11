/*
 * Copyright © 2020-2021 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package com.dell.dtc.edge.guard.service;

import com.dell.dtc.edge.guard.client.AnomalyDetectionClient;
import com.dell.dtc.edge.guard.model.request.ProvisioningRequest;
import com.dell.dtc.edge.guard.model.response.ProvisioningResponse;
import com.dell.dtc.edge.guard.model.TemperatureData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnomalyDetectionServiceImpl implements AnomalyDetectionService{

    public static final String ORG_ID = "2023";
    private final AnomalyDetectionClient anomalyDetectionClient;
    public ProvisioningResponse sendTemperatureData(ProvisioningRequest provisioningRequest) {

        log.info("provisioningRequest: {}", provisioningRequest.toString());

        // Generate a random temperature between 60°F and 140°F
        float temperature = generateRandomTemperature();

        // Create a TemperatureData object
        TemperatureData temperatureData = new TemperatureData();
        temperatureData.setDeviceId(provisioningRequest.getDeviceId());
        temperatureData.setOrgId(ORG_ID);
        temperatureData.setTemperature(temperature);
        temperatureData.setTimestamp(LocalDateTime.now().toString());

        log.info("temperatureData: {}", temperatureData.toString());
        ProvisioningResponse provisioningResponse = anomalyDetectionClient.sendTemperatureData(temperatureData);
        log.info("provisioningResponse: {}", provisioningResponse.toString());

        return provisioningResponse;
    }

    private float generateRandomTemperature() {
//        // Generate a random temperature between 60°F and 140°F
//        return 60 + Math.random() * 80;

        // Generate a random temperature between 53°F and 90°F
        double randomTemp = 50 + Math.random() * 45;
        return (float) randomTemp;
    }
}
