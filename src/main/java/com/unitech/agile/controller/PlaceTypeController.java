package com.unitech.agile.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.unitech.agile.manager.PlaceTypeManager;

@RestController
public class PlaceTypeController {	
	
	@Autowired
	PlaceTypeManager placeTypeManager;

	@ApiOperation(value="Get place types", tags="Agile")
	@GetMapping(value = "/place_types")
	public String getPlaceTypes(@RequestHeader(value="token") String token) {
		return placeTypeManager.getPlaceTypes(token).toString();
	}
}
