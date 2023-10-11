package com.dell.dtc.edge.guard.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvisionResponse {

    private String deviceId;
    private String timestamp;
    private int temperature;
    private String deviceType;
    private String location;
}