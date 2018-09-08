package com.harium.web.healthcare.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.harium.web.json.Json;
import com.harium.web.model.ResponseModel;

public class ServerStatus implements ResponseModel {

    @Expose
    @SerializedName("time")
    private ClockStatus clock;

    @Expose
    @SerializedName("cpu")
    private CPUStatus cpu;

    @Expose
    @SerializedName("disk")
    private DiskStatus disk;

    @Expose
    @SerializedName("memory")
    private MemoryStatus memory;

    public ClockStatus getClock() {
        return clock;
    }

    public void setClock(ClockStatus clock) {
        this.clock = clock;
    }

    public CPUStatus getCpu() {
        return cpu;
    }

    public void setCpu(CPUStatus cpu) {
        this.cpu = cpu;
    }

    public DiskStatus getDisk() {
        return disk;
    }

    public void setDisk(DiskStatus disk) {
        this.disk = disk;
    }

    public MemoryStatus getMemory() {
        return memory;
    }

    public void setMemory(MemoryStatus memory) {
        this.memory = memory;
    }

    @Override
    public String asJson() {
        return Json.toJson(this);
    }
}
