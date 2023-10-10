package com.dell.dtc.edge.guard.model.response;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvisioningResponse {
    
  private String deviceId;
  private String timestamp;
  private Boolean isTemperatureAnomaly;
}
