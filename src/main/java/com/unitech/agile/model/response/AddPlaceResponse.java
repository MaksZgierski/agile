package com.unitech.agile.model.response;

import com.google.gson.annotations.SerializedName;

public class AddPlaceResponse {

	@SerializedName("id")
	private int id;

	public AddPlaceResponse(int id) {
		super();
		this.id = id;
	}

}
