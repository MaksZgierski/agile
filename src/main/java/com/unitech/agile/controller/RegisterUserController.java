package com.unitech.agile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitech.agile.manager.RegisterUserManager;
import com.unitech.agile.model.request.RegisterUserRequest;

@RestController
public class RegisterUserController {

	@Autowired
	RegisterUserManager registerUserManager;
	
	@PostMapping(value = "/register_user")
	public String registerUser(@RequestBody RegisterUserRequest request) {
		return registerUserManager.registerUser(request).toString();
	}
	
	/*
	 /register_user cURL example
	 curl -X POST \
  http://localhost:8080/register_user \
  -H 'cache-control: no-cache' \
  -H 'charset: utf-8' \
  -H 'content-type: application/json' \
  -H 'postman-token: 432d3f7c-fef6-d43c-d775-89f7aa43f15b' \
  -d '{
	"login":"test",
	"password":"password",
	"name":"name"
}'
	 */
}
