package com.dell.dtc.edge.guard.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventData {

    private String source;
    private String check;
    private String severity;
    private String description;

}
