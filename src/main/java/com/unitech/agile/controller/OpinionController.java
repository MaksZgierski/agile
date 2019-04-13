package com.unitech.agile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.unitech.agile.manager.OpinionManager;
import com.unitech.agile.model.request.AddOpinionRequest;

@RestController
public class OpinionController {
	
	@Autowired
	OpinionManager opinionManager;
	
	@PostMapping(value = "/opinion")
	public String addOpinion(@RequestHeader(value="token") String token, @RequestBody AddOpinionRequest request) {
		return opinionManager.addOpinion(token, request).toString();
	}

}
