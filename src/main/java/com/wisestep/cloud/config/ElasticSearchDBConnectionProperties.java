/**
 * @Project wisestep-assignment-service
 * @Package com.wisestep.cloud.config
 * @File ElasticDBConnectionProperties.java
 */
package com.wisestep.cloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @Author Aniket Lahiri
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "elasticsearchdb")
public class ElasticSearchDBConnectionProperties {
	
	private String host;
	private String port;
	private String username;
	private String password;
	private String fingerprint;

}
