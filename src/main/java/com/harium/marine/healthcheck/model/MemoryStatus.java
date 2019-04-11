package com.harium.marine.healthcheck.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.harium.marine.json.Json;
import com.harium.marine.model.ResponseModel;

public class MemoryStatus implements ResponseModel {

    @Expose
    @SerializedName("current")
    private float current;

    @Expose
    @SerializedName("total")
    private float total;

    @Expose
    @SerializedName("percentage")
    private float percentage;

    public float getCurrent() {
        return current;
    }

    public void setCurrent(float current) {
        this.current = current;
        calculatePercentage();
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
        calculatePercentage();
    }

    private void calculatePercentage() {
        if (total == 0) {
            percentage = 0;
            return;
        }
        percentage = (current * 100) / total;
    }

    public float getPercentage() {
        return percentage;
    }

    public String asJson() {
        return Json.toJson(this);
    }
}
