package com.unitech.agile.model.request;

import com.google.gson.annotations.SerializedName;

public class RateOpinionRequest {

    @SerializedName("opinionId")
    private Integer opinionId;

    @SerializedName("rating")
    private Integer rating;

    public Integer getOpinionId() {
        return opinionId;
    }

    public Integer getRating() {
        return rating;
    }

}
