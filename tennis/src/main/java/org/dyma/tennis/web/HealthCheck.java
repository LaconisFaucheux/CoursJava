package org.dyma.tennis.web;

public record HealthCheck(ApplicationStatus status, String message) {
}
