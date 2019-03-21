package com.unitech.agile.model.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class BaseObjectResponse<T> {

	@SerializedName("code")
	private int code;
	
	@SerializedName("message")
	private String message;
	
	@SerializedName("response")
	private T response;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
	
	public String toString() {
		return new Gson().toJson(this);
	}
}
