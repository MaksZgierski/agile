package com.unitech.agile.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpinionDTO {

	@SerializedName("id")
	private int id;

	@SerializedName("opinion")
	private String opinion;

	@SerializedName("date")
	private long date;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("user_login")
	private String userLogin;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("rating")
	private int rating;

	@SerializedName("cantrate")
	private List<Integer> cantrate;

	public OpinionDTO(int id, String opinion, long date, String userName, String userLogin, int userId, int rating, List<Integer> cantrate) {
		super();
		this.id = id;
		this.opinion = opinion;
		this.date = date;
		this.userName = userName;
		this.userLogin = userLogin;
		this.userId = userId;
		this.rating = rating;
		this.cantrate = cantrate;
	}

	public int getId() {
		return id;
	}

	public String getOpinion() {
		return opinion;
	}

	public long getDate() {
		return date;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public int getUserId() {
		return userId;
	}

	public int getRating() { return rating; }

	public List<Integer> getCantrate() { return cantrate; }
}
