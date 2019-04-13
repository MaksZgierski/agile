package com.unitech.agile.controller;

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
	
	@GetMapping(value = "/places")
	public String getPlaces(@RequestHeader(value="token") String token) {
		return placeManager.getPlaces(token).toString();
	}
	
	@GetMapping(value = "/place_details/{id}")
	public String getPlaceDetails(@RequestHeader(value="token") String token, @PathVariable("id") int id) {
		return placeManager.getPlaceDetails(token, id).toString();
	}
	
	@PostMapping(value = "/places")
	public String addPlace(@RequestHeader(value="token") String token, @RequestBody AddPlaceRequest request) {
		return placeManager.addPlace(token, request).toString();
	}
	
	@DeleteMapping(value = "/places/{id}")
	public String deletePlace(@RequestHeader(value="token") String token, @PathVariable("id") int id) {
		return placeManager.deletePlace(token, id).toString();
	}
}
