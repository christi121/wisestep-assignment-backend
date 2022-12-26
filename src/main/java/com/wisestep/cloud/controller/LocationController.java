/**
 * @Project wisestep-assignment-service
 * @Package com.wisestep.cloud.controller
 * @File LocationController.java
 */
package com.wisestep.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisestep.cloud.bo.LocationBO;
import com.wisestep.cloud.service.LocationService;

import java.util.List;

/**
 * @Author Aniket Lahiri
 *
 */
@RequestMapping("location")
@RestController
@CrossOrigin(origins = {"${setting.allowedorigin}"})
public class LocationController {
	
	@Autowired
	LocationService service;
	
	@PostMapping("saveAll")
	public ResponseEntity<List<LocationBO>> saveAll(@Valid @RequestBody LocationBO location, @RequestHeader HttpHeaders httpReq){
		return new ResponseEntity<List<LocationBO>>(service.saveAll(location, getClientIp(httpReq)), HttpStatus.CREATED); 
	}
	
	@GetMapping("getAll")
	public ResponseEntity<Iterable<LocationBO>> getAll(@RequestHeader HttpHeaders httpReq){
		return new ResponseEntity<Iterable<LocationBO>>(service.getAll(getClientIp(httpReq)), HttpStatus.OK); 
	}
	
	private String getClientIp(HttpHeaders headers) {
		String clientIp = "";
		List<String> proxyIp = headers.get("X-FORWARDED-FOR");
		if(null == proxyIp || proxyIp.isEmpty()) {
			clientIp = headers.getHost().getHostString();
		} else {
			clientIp = proxyIp.get(0);
		}
		return clientIp;
    }

}
