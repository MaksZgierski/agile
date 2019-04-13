package com.unitech.agile.model.request;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AddPlaceRequest {

	@SerializedName("name")
	private String name;

	@SerializedName("placeType")
	private Integer placeType;

	@SerializedName("lat")
	private Float lat;

	@SerializedName("lng")
	private Float lng;

	@SerializedName("address")
	private String address;

	@SerializedName("description")
	private String description;

	@SerializedName("conveniences")
	private List<Integer> conveniences;

	public String getName() {
		return name;
	}

	public Integer getPlaceType() {
		return placeType;
	}

	public Float getLat() {
		return lat;
	}

	public Float getLng() {
		return lng;
	}

	public String getAddress() {
		return address;
	}

	public String getDescription() {
		return description;
	}

	public List<Integer> getConveniences() {
		return conveniences;
	}

}
