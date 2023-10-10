package com.dell.dtc.edge.guard.client;

import com.dell.dtc.edge.guard.model.TemperatureData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "anomalyDetectionClient", url = "${anomaly.detection.service.url}")
public interface AnomalyDetectionClient {
    
    @PostMapping("/api/anomaly") // Define the endpoint and HTTP method
    void sendTemperatureData(@RequestBody TemperatureData temperatureData);
}
