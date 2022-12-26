/**
 * @Project wisestep-assignment-service
 * @Package com.wisestep.cloud.bo
 * @File LocationBO.java
 */
package com.wisestep.cloud.bo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class LocationBO {
	
	@NotBlank(message = "Location cannot be empty")
	@NotNull(message = "Location cannot be null")
	private String name;

}
