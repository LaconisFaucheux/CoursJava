package org.dyma.tennis.service;

import org.dyma.tennis.repository.HealthCheckRepository;
import org.dyma.tennis.web.ApplicationStatus;
import org.dyma.tennis.web.HealthCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    @Autowired
    private HealthCheckRepository healthCheckRepository;

    public HealthCheck healthCheck() {
        Long activeSessions = healthCheckRepository.countApplicationConnections();

        if(activeSessions > 0){
            return new HealthCheck(ApplicationStatus.OK, "Welcome to Dyma Tennis! " + activeSessions + " sessions running");
        } else {
            return new HealthCheck(ApplicationStatus.KO, "Dyma Tennis is not fully functionnal. Please check your configuration.");
        }
    }
}
