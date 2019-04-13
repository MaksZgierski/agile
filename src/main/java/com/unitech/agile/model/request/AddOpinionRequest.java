package com.unitech.agile.model.request;

import com.google.gson.annotations.SerializedName;

public class AddOpinionRequest {

	@SerializedName("placeId")
	private Integer placeId;

	@SerializedName("comment")
	private String comment;

	@SerializedName("rating")
	private Integer rating;

	public Integer getPlaceId() {
		return placeId;
	}

	public String getComment() {
		return comment;
	}

	public Integer getRating() {
		return rating;
	}

}
