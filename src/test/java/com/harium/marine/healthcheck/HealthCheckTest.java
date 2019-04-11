package com.harium.marine.healthcheck;

import com.harium.marine.healthcheck.model.CPUStatus;
import com.harium.marine.healthcheck.model.ClockStatus;
import com.harium.marine.healthcheck.model.DiskStatus;
import com.harium.marine.healthcheck.model.MemoryStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HealthCheckTest {

    private HealthCheck service;

    @Before
    public void setUp() {
        service = new HealthCheck();
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
