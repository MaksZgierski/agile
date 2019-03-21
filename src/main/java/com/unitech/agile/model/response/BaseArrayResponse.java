package com.unitech.agile.model.response;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class BaseArrayResponse<T> {

	@SerializedName("code")
	private int code;
	
	@SerializedName("message")
	private String message;
	
	@SerializedName("response")
	private List<T> response;

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
	
	public List<T> getResponse() {
		return response;
	}

	public void setResponse(List<T> response) {
		this.response = response;
	}

	public String toString() {
		return new Gson().toJson(this);
	}
}

