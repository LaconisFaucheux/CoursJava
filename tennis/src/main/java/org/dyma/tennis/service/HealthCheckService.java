package org.dyma.tennis.service;

import org.dyma.tennis.rest.ApplicationStatus;
import org.dyma.tennis.rest.HealthCheck;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    public HealthCheck healthCheck() {
        return new HealthCheck(ApplicationStatus.OK, "Welcome to Dyma Tennis!");
    }

}
