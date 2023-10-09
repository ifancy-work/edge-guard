/*
 * Copyright © 2020-2021 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package com.dell.dtc.edge.guard.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Initial ConfigurationProperties to be used for dynamic property compliant changes.
 * Inject this bean throughout the application to use application properties.
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "com.dell.dtc.edge.guard")
public class ConfigProperties {
}