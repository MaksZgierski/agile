package com.unitech.agile.model.request;

import com.google.gson.annotations.SerializedName;

public class LoginUserRequest {

	@SerializedName("login")
	private String login;
	
	@SerializedName("password")
	private String password;
	
	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
}
