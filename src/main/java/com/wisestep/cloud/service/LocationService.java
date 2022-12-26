/**
 * @Project wisestep-assignment-service
 * @Package com.wisestep.cloud.service
 * @File LocationService.java
 */
package com.wisestep.cloud.service;

import java.util.List;

import com.wisestep.cloud.bo.LocationBO;

/**
 * @Author Aniket Lahiri
 *
 */
public interface LocationService {
	
	public List<LocationBO> saveAll(LocationBO locations, String string);
	
	public List<LocationBO> getAll(String string);

}
