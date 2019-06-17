package com.unitech.agile.model.request;

import com.google.gson.annotations.SerializedName;

public class RateOpinionRequest {

    @SerializedName("opinionId")
    private Integer opinionId;

    @SerializedName("rating")
    private Integer rating;

    @SerializedName("user_id")
    private Integer user_id;

    public Integer getOpinionId() {
        return opinionId;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getUser_id()
    {
        return user_id;
    }

}
