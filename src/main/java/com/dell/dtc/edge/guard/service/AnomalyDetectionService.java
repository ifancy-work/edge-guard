/*
 * Copyright © 2020-2021 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package com.dell.dtc.edge.guard.service;

import com.dell.dtc.edge.guard.model.request.ProvisioningRequest;
import com.dell.dtc.edge.guard.model.response.ProvisionResponse;

public interface AnomalyDetectionService {
    
    ProvisionResponse sendTemperatureData(ProvisioningRequest provisioningRequest);
}
