package com.harium.web.healthcare.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.harium.web.json.Json;
import com.harium.web.model.ResponseModel;

public class DiskStatus implements ResponseModel {

    @Expose
    @SerializedName("current")
    private int current;

    @Expose
    @SerializedName("total")
    private int total;

    @Expose
    @SerializedName("percentage")
    private float percentage;

    public float getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
        calculatePercentage();
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(int total) {
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
