package com.dell.dtc.edge.guard.service;

import com.dell.dtc.edge.guard.model.AlertRequest;
import com.dell.dtc.edge.guard.model.AlertResponse;

public interface IncidentManagementService {

    AlertResponse createAlert(AlertRequest alertRequest);

}
