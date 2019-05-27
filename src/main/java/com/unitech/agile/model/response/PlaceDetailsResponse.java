package com.unitech.agile.model.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.unitech.agile.dto.ConvenienceDTO;
import com.unitech.agile.dto.OpinionDTO;
import com.unitech.agile.dto.PlaceTypeDTO;

public class PlaceDetailsResponse {

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	@SerializedName("latitude")
	private float latitude;

	@SerializedName("longitude")
	private float longitude;

	@SerializedName("description")
	private String description;

	@SerializedName("address")
	private String address;

	@SerializedName("conveniences")
	private List<ConvenienceDTO> conveniences;

	@SerializedName("place_type")
	private PlaceTypeDTO placeType;

	@SerializedName("opinions")
	private List<OpinionDTO> opinions;
	
	@SerializedName("images")
	private List<Integer> images;

	@SerializedName("rating")
	private float rating;

	@SerializedName("number_of_opinions")
	private int numberOfOpinions;

	public PlaceDetailsResponse(int id, String name, float latitude, float longitude, String description,
			String address, List<ConvenienceDTO> conveniences, PlaceTypeDTO placeType, List<OpinionDTO> opinions,
			float rating, int numberOfOpinions, List<Integer> images) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.address = address;
		this.conveniences = conveniences;
		this.placeType = placeType;
		this.opinions = opinions;
		this.rating = rating;
		this.numberOfOpinions = numberOfOpinions;
		this.images = images;
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

	public String getDescription() {
		return description;
	}

	public String getAddress() {
		return address;
	}

	public List<ConvenienceDTO> getConveniences() {
		return conveniences;
	}

	public PlaceTypeDTO getPlaceType() {
		return placeType;
	}

	public List<OpinionDTO> getOpinions() {
		return opinions;
	}

	public float getRating() {
		return rating;
	}

	public int getNumberOfOpinions() {
		return numberOfOpinions;
	}

}
