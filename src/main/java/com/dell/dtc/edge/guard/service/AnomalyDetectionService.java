/*
 * Copyright © 2020-2021 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package com.dell.dtc.edge.guard.service;

import com.dell.dtc.edge.guard.model.request.ProvisioningRequest;
import com.dell.dtc.edge.guard.model.response.ProvisioningResponse;

public interface AnomalyDetectionService {
    
    ProvisioningResponse sendTemperatureData(ProvisioningRequest provisioningRequest);
}
