package com.unitech.agile.dto;

import com.google.gson.annotations.SerializedName;

public class OpinionDTO {

	@SerializedName("opinion")
	private String opinion;

	public OpinionDTO(String opinion) {
		super();
		this.opinion = opinion;
	}

	public String getOpinion() {
		return opinion;
	}

}
