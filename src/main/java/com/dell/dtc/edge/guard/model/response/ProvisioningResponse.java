package com.dell.dtc.edge.guard.model.response;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvisioningResponse {

  @JsonProperty("device_id")
  private String deviceId;
  private String timestamp;
  @JsonProperty("is_temperature_anomaly")
  private boolean isTemperatureAnomaly;
}