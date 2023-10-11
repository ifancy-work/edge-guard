package com.dell.dtc.edge.guard.client;

import com.dell.dtc.edge.guard.model.EventData;
import com.dell.dtc.edge.guard.model.MoogsoftAlertResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "moogsoftClient", url = "${moogsoft.url}")
public interface MoogsoftClient {

    @PostMapping(value = "/events", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MoogsoftAlertResponse> postEvent(@RequestHeader("apiKey") String apiKey, @RequestBody List<EventData> events);

}
