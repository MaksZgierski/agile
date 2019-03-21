package com.unitech.agile.dto;

import com.google.gson.annotations.SerializedName;

public class PlaceTypeDTO {

	@SerializedName("id")
	private int id;
	
	@SerializedName("name")
	private String name;

	public PlaceTypeDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
