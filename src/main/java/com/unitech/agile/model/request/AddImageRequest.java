package com.unitech.agile.model.request;

import com.google.gson.annotations.SerializedName;

public class AddImageRequest {

	@SerializedName("placeId")
	private Integer placeId;

	@SerializedName("imageData")
	private String imageData;

	public Integer getPlaceId() {
		return placeId;
	}

	public String getImageData() {
		return imageData;
	}

}
