/**
 * @Project wisestep-assignment-service
 * @Package com.wisestep.cloud.repository
 * @File LocationRepository.java
 */
package com.wisestep.cloud.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.wisestep.cloud.model.Location;

/**
 * @Author Aniket Lahiri
 *
 */
@Repository
public interface LocationRepository extends ElasticsearchRepository<Location, String> {
	
	List<Location> findByNameAndClient(String name, String client);
	
	List<Location> findByClient(String client);

}
