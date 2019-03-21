package com.unitech.agile.model.request;

import com.google.gson.annotations.SerializedName;

public class RegisterUserRequest {

	@SerializedName("login")
	private String login;
	
	@SerializedName("password")
	private String password;
	
	@SerializedName("name")
	private String name;

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
	
}
