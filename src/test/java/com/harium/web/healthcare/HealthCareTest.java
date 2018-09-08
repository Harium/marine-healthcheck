package com.harium.web.healthcare;

import com.harium.web.healthcare.model.CPUStatus;
import com.harium.web.healthcare.model.ClockStatus;
import com.harium.web.healthcare.model.DiskStatus;
import com.harium.web.healthcare.model.MemoryStatus;
import com.harium.web.json.Json;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HealthCareTest {

    private HealthCare service;

    @Before
    public void setUp() {
        service = new HealthCare();
    }

    @Test
    public void testClock() {
        ClockStatus status = service.clock();
        Assert.assertNotNull(status);
        Assert.assertTrue(status.getTime() > 0);
    }

    @Test
    public void testCPU() {
        CPUStatus status = service.cpu();
        Assert.assertNotNull(status);
        Assert.assertTrue(status.getProcessUsage() > 0);
    }

    @Test
    public void testDisk() {
        DiskStatus status = service.disk();
        Assert.assertNotNull(status);
        Assert.assertTrue(status.getTotal() > 0);
    }

    @Test
    public void testMemory() {
        MemoryStatus status = service.memory();
        Assert.assertNotNull(status);
        Assert.assertTrue(status.getTotal() > 0);
    }

}
