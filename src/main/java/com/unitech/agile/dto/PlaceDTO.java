package com.unitech.agile.dto;

import com.google.gson.annotations.SerializedName;

public class PlaceDTO {

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	@SerializedName("latitude")
	private float latitude;

	@SerializedName("longitude")
	private float longitude;

	@SerializedName("place_type")
	private PlaceTypeDTO placeType;

	@SerializedName("rating")
	private double rating;

	public PlaceDTO(int id, String name, float latitude, float longitude, PlaceTypeDTO placeType, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.placeType = placeType;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public PlaceTypeDTO getPlaceType() {
		return placeType;
	}

	public double getRating() {
		return rating;
	}

}
