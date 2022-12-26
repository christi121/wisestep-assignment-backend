/**
 * @Project wisestep-assignment-service
 * @Package com.wisestep.cloud.service.impl
 * @File LocationServiceImpl.java
 */
package com.wisestep.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisestep.cloud.bo.LocationBO;
import com.wisestep.cloud.model.Location;
import com.wisestep.cloud.repository.LocationRepository;
import com.wisestep.cloud.service.LocationService;

/**
 * @Author Aniket Lahiri
 *
 */
@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	LocationRepository repository;

	@Override
	public List<LocationBO> saveAll(LocationBO locationBO, String clientIp) {
		List<Location> exsitingLocation = repository.findByNameAndClient(locationBO.getName(), clientIp);
		if(exsitingLocation.isEmpty()) {
			Location newLocation = new Location();
			BeanUtils.copyProperties(locationBO, newLocation);
			newLocation.setClient(clientIp);
			repository.save(newLocation);
		}
		return getAll(clientIp);
	}

	@Override
	public List<LocationBO> getAll(String clientIp) {
		List<LocationBO> allLocations = new ArrayList<LocationBO>();
		repository.findByClient(clientIp).forEach(location -> {
			LocationBO locationBO = new LocationBO();
			BeanUtils.copyProperties(location, locationBO);
			allLocations.add(locationBO);
		});
		return allLocations;
	}

}
