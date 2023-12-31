package com.dell.dtc.edge.guard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlertRequest {

    @JsonProperty("temperature")
    private String temperature;
    @JsonProperty("device_id")
    private String deviceId;

}
