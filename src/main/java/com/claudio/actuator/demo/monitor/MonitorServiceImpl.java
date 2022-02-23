package com.claudio.actuator.demo.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

@Service
public class MonitorServiceImpl implements MonitorService, HealthIndicator {

    private final String DATABASE_SERVICE = "Database Service";

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        if(this.getDatabaseHealth()){
            return Health.up().withDetail(DATABASE_SERVICE, "Database service is running").build();
        }else{
            return Health.down().withDetail(DATABASE_SERVICE, "Database service is not running").build();
        }
    }

    @Override
    public Boolean getDatabaseHealth() {
        //Logic to determine if the database is UP
        return true;
    }
}
