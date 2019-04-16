package com.unitech.agile.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.unitech.agile.manager.PlaceManager;
import com.unitech.agile.model.request.AddPlaceRequest;

@RestController
public class PlaceController {	
	
	@Autowired
	PlaceManager placeManager;

    @ApiOperation(value = "Get places", tags="Agile")
	@GetMapping(value = "/places")
	public String getPlaces(@RequestHeader(value="token") String token) {
		return placeManager.getPlaces(token).toString();
	}

    @ApiOperation(value="Get place details", tags="Agile")
	@GetMapping(value = "/place_details/{id}")
	public String getPlaceDetails(@RequestHeader(value="token") String token, @PathVariable("id") int id) {
		return placeManager.getPlaceDetails(token, id).toString();
	}

    @ApiOperation(value="Add place", tags="Agile")
	@PostMapping(value = "/places")
	public String addPlace(@RequestHeader(value="token") String token, @RequestBody AddPlaceRequest request) {
		return placeManager.addPlace(token, request).toString();
	}

    @ApiOperation(value="Delete place", tags="Agile")
	@DeleteMapping(value = "/places/{id}")
	public String deletePlace(@RequestHeader(value="token") String token, @PathVariable("id") int id) {
		return placeManager.deletePlace(token, id).toString();
	}
}
