package com.dell.dtc.edge.guard.service.impl;

import com.dell.dtc.edge.guard.client.MoogsoftClient;
import com.dell.dtc.edge.guard.model.AlertRequest;
import com.dell.dtc.edge.guard.model.AlertResponse;
import com.dell.dtc.edge.guard.model.EventData;
import com.dell.dtc.edge.guard.model.MoogsoftAlertResponse;
import com.dell.dtc.edge.guard.service.IncidentManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class IncidentManagementServiceImpl implements IncidentManagementService {

    private static final String CHECK = "Temperature Spike";
    private static final String MAJOR_SEVERITY = "Major";
    private static final String CRITICAL_SEVERITY = "Critical";
    private static final String UNKNOWN_SEVERITY = "Unknown";

    @Value("${moogsoft.api.apiKey}")
    private String apiKey;

    private final MoogsoftClient moogsoftClient;

    @Autowired
    public IncidentManagementServiceImpl(MoogsoftClient moogsoftClient) {
        this.moogsoftClient = moogsoftClient;
    }

    @Override
    public AlertResponse createAlert(AlertRequest alertRequest) {

        String temperature = alertRequest.getTemperature();

        // Create a single EventData object
        EventData event = EventData.builder()
                .source(alertRequest.getDeviceId() + UUID.randomUUID())
                .check(CHECK)
                .severity(determineSeverity(temperature))
                .description(CHECK + " To " + temperature)
                .build();

        // Create a list containing the single Event object
        List<EventData> eventList = Collections.singletonList(event);

        // Invoke Moogsoft post event API
        ResponseEntity<MoogsoftAlertResponse> response = moogsoftClient.postEvent(apiKey, eventList);

        if (response.getBody().getStatus().equalsIgnoreCase("success")) {
            return AlertResponse.builder().message("Incident created in Moogsoft Platform.").build();
        } else {
            return AlertResponse.builder().message("Error sending alert to Moogsoft Platform.").build();
        }
    }

    /**
     * This method determines the severity of the temperature
     * @param temperatureString
     * @return severity
     */
    private String determineSeverity(String temperatureString) {

        String severity;
        int temperature = Integer.parseInt(temperatureString);

        if (temperature > 100 || temperature < 43) {
            severity = CRITICAL_SEVERITY;
        } else if (temperature > 90 || temperature < 53) {
            severity = MAJOR_SEVERITY;
        } else {
            severity = UNKNOWN_SEVERITY;
        }

        return severity;
    }
}
