package com.dell.dtc.edge.guard.model.request;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.OffsetDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvisioningRequest {
    
  private String deviceId;
  private String deviceType;
  private String location;
}
