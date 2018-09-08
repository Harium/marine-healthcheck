package com.harium.web.healthcare.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.harium.web.json.Json;
import com.harium.web.model.ResponseModel;

public class ClockStatus implements ResponseModel {

    @Expose
    @SerializedName("time")
    private long time;

    public float getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String asJson() {
        return Json.toJson(this);
    }
}
