package com.harium.web.healthcare.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.harium.web.json.Json;
import com.harium.web.model.ResponseModel;

public class CPUStatus implements ResponseModel {

    @Expose
    @SerializedName("process_usage")
    private float processUsage;

    @Expose
    @SerializedName("system_usage")
    private float systemUsage;

    public float getProcessUsage() {
        return processUsage;
    }

    public void setProcessUsage(float processUsage) {
        this.processUsage = processUsage;
    }

    public float getSystemUsage() {
        return systemUsage;
    }

    public void setSystemUsage(float systemUsage) {
        this.systemUsage = systemUsage;
    }

    @Override
    public String asJson() {
        return Json.toJson(this);
    }
}
