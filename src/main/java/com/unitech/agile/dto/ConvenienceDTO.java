package com.unitech.agile.dto;

import com.google.gson.annotations.SerializedName;

public class ConvenienceDTO {

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	public ConvenienceDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
