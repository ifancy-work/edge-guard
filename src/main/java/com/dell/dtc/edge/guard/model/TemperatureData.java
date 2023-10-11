package com.dell.dtc.edge.guard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TemperatureData {

    @JsonProperty("device_id")
    private String deviceId;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("org_id")
    private String orgId;

    @JsonProperty("temperature")
    private int temperature;
}