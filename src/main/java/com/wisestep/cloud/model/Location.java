/**
 * @Project wisestep-assignment-service
 * @Package com.wisestep.cloud
 * @File Location.java
 */
package com.wisestep.cloud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Aniket Lahiri
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "location")
public class Location {

	@Id
	private String name;
	private String client;
}
