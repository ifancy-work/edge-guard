/*
 * Copyright © 2020-2021 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package com.dell.dtc.edge.guard.service;

import com.dell.dtc.edge.guard.model.request.ProvisioningRequest;
import com.dell.dtc.edge.guard.model.response.ProvisioningResponse;
import com.dell.dtc.edge.guard.model.TemperatureData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnomalyDetectionServiceImpl implements AnomalyDetectionService{
    
    private DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    public ProvisioningResponse sendTemperatureData(ProvisioningRequest provisioningRequest) {

        String currentTimestamp = LocalDateTime.now().format(formatter);

        log.debug("provisioningRequest: {}", provisioningRequest.toString());

        //Initialize ProvisioningResponse
        ProvisioningResponse provisioningResponse = ProvisioningResponse.builder()
                .isTemperatureAnomaly(Boolean.FALSE)
                .timestamp(currentTimestamp)
                .deviceId(provisioningRequest.getDeviceId())
                .build();

        log.debug("provisioningResponse: {}", provisioningResponse.toString());
        // Generate a random temperature between 60°F and 140°F
        double temperature = generateRandomTemperature();

        // Create a TemperatureData object
        TemperatureData temperatureData = new TemperatureData();
        temperatureData.setDeviceId(provisioningRequest.getDeviceId());
        temperatureData.setOrgId(provisioningRequest.getOrgId());
        temperatureData.setTemperature(temperature);

        if (temperature >= 60 && temperature <= 100) {
            log.debug("Warning temperature {}", temperature);
            // Use the Feign client to send temperature data to the Anomaly Detection Service
            provisioningResponse.setIsTemperatureAnomaly(Boolean.TRUE);
            //TODO: once we have ready anomaly detection service we will uncomment the call
            log.debug("Calling anomaly detection client...");
//            anomalyDetectionClient.sendTemperatureData(temperatureData);
        } else if (temperature > 100 && temperature <= 140) {
            log.debug("Critical temperature {}", temperature);
            // Use the Feign client to send temperature data to the Anomaly Detection Service
            provisioningResponse.setIsTemperatureAnomaly(Boolean.TRUE);
            //TODO: once we have ready anomaly detection service we will uncomment the call
            log.debug("Calling anomaly detection client...");
//            anomalyDetectionClient.sendTemperatureData(temperatureData);
        } else {
            log.debug("Normal temperature {}", temperature);
        }

        return provisioningResponse;
    }

    private double generateRandomTemperature() {
        // Generate a random temperature between 60°F and 140°F
        return 60 + Math.random() * 80;
    }
}
