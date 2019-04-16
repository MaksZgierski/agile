package com.unitech.agile.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@ApiOperation(value="Hello", tags="Agile")
	@GetMapping(value = "/")
	public String home() {
		return "hello";
	}
}
