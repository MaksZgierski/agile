package com.unitech.agile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitech.agile.manager.LoginUserManager;
import com.unitech.agile.model.request.LoginUserRequest;

@RestController
public class LoginUserController {

	@Autowired
	LoginUserManager loginUserManager;
	
	@PostMapping(value = "/login")
	public String registerUser(@RequestBody LoginUserRequest request) {
		return loginUserManager.login(request).toString();
	}
	
	/*
	 /login cURL example
	 curl -X POST \
  http://localhost:8080/login \
  -H 'cache-control: no-cache' \
  -H 'charset: utf-8' \
  -H 'content-type: application/json' \
  -H 'postman-token: 5d37c58d-170b-3533-819a-6721dfaf36e6' \
  -d '{
	"login":"test",
	"password":"password"
}'
	 */
}
