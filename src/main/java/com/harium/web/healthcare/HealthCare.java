package com.harium.web.healthcare;

/**
 * A service to report server status
 */

import com.harium.web.model.WebModule;
import com.harium.web.healthcare.model.*;
import com.sun.management.OperatingSystemMXBean;
import spark.Request;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.path;

public class HealthCare implements WebModule {

    private static final float MB = (float) 1 / (1024 * 1024);
    private static final float GB = MB / 1024;

    public void init() {
        path("/health", () -> {
            get("", (request, response) -> all().asJson());
            get("/memory", (request, response) -> memory().asJson());
            get("/cpu", (request, response) -> cpu().asJson());
            get("/disk", (request, response) -> disk().asJson());
            get("/clock", (request, response) -> clock().asJson());
        });
    }

    /*package*/ ServerStatus all() {
        ServerStatus serverStatus = new ServerStatus();
        serverStatus.setCpu(cpu());
        serverStatus.setDisk(disk());
        serverStatus.setMemory(memory());
        serverStatus.setClock(clock());

        return serverStatus;
    }

    /*package*/ MemoryStatus memory() {
        Runtime rt = Runtime.getRuntime();

        float totalMB = rt.totalMemory() * MB;
        float usedMB = totalMB - (rt.freeMemory() * MB);

        MemoryStatus memory = new MemoryStatus();
        memory.setCurrent(usedMB);
        memory.setTotal(totalMB);

        return memory;
    }

    /*package*/ CPUStatus cpu() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);

        CPUStatus cpuStatus = new CPUStatus();
        cpuStatus.setProcessUsage((float) osBean.getProcessCpuLoad() * 100);
        cpuStatus.setSystemUsage((float) osBean.getSystemCpuLoad() * 100);

        return cpuStatus;
    }

    /*package*/ DiskStatus disk() {
        File root = new File("/");

        DiskStatus diskStatus = new DiskStatus();
        diskStatus.setCurrent((int) ((root.getTotalSpace() - root.getFreeSpace()) * GB));
        diskStatus.setTotal((int) (root.getTotalSpace() * GB));

        return diskStatus;
    }

    /*package*/ ClockStatus clock() {
        ClockStatus clockStatus = new ClockStatus();
        clockStatus.setTime(System.currentTimeMillis());

        return clockStatus;
    }

    @Override
    public void buildModel(Request request, Map<String, Object> model) {

    }
}
