package com.dell.dtc.edge.guard.model;

import lombok.Data;

@Data
public class TemperatureData {
    private String deviceId;
    private String orgId;
    private double temperature;
}