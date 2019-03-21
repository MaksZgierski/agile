package com.unitech.agile.model.response;

import com.google.gson.annotations.SerializedName;

public class LoginUserResponse {

	@SerializedName("session_token")
	private String sessionToken;

	public LoginUserResponse(String sessionToken) {
		super();
		this.sessionToken = sessionToken;
	}
}
