package com.unitech.agile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unitech.agile.repository.PlaceTypeRepository;

@RestController
public class HelloController {	
	
	@Autowired
	PlaceTypeRepository placeTypeRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "hello";
	}
}
