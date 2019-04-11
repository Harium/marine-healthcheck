package com.harium.marine.healthcheck.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.harium.marine.json.Json;
import com.harium.marine.model.ResponseModel;

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
