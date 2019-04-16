package com.unitech.agile.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitech.agile.manager.RegulationsManager;

@RestController
public class RegulationsController {

	@Autowired
	RegulationsManager regulationsManager;

	@ApiOperation(value="Get regulations", tags="Agile")
	@GetMapping(value = "/regulations")
	public String regulations() {
		final String regulations = regulationsManager.getRegulations();
		if(regulations != null) {
			return regulations;
		} else {
			return "";
		}
	}
}
