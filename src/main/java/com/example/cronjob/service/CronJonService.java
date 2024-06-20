package com.example.cronjob.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CronJonService {

    private final RestTemplate restTemplate;

    @Value("${student_management_system_frontend_url}")
    public String studentManagementSystemFrontendUrl;

    @Value("${student_management_system_frontend_revised_url}")
    public String studentManagementSystemFrontendRevisedUrl;

    @Value("${student_management_system_backend_url}")
    public String studentManagementSystemBackendUrl;

    @Value("${online_library_frontend_url}")
    public String onlineLibraryFrontendUrl;

    @Value("${online_library_backend_url}")
    public String onlineLibraryBackendUrl;

    public CronJonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Send requests at 14 minute intervals to keep the backend server of StudentManagementSystem alive
    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void sendRequest() {
        String smsFrontendUrl = studentManagementSystemFrontendUrl;
        try {
            String smsFrontendResponse = restTemplate.getForObject(smsFrontendUrl, String.class);
            System.out.println("Response: " + smsFrontendResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String smsFrontendRevisedUrl = studentManagementSystemFrontendRevisedUrl;
        try {
            String smsFrontendRevisedResponse = restTemplate.getForObject(smsFrontendRevisedUrl, String.class);
            System.out.println("Response: " + smsFrontendRevisedResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String smsBackendUrl = studentManagementSystemBackendUrl;
        try {
            String smsBackendResponse = restTemplate.getForObject(smsBackendUrl, String.class);
            System.out.println("Response: " + smsBackendResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String olFrontendUrl = onlineLibraryFrontendUrl;
        try {
            String olFrontendResponse = restTemplate.getForObject(olFrontendUrl, String.class);
            System.out.println("Response: " + olFrontendResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String olBackendUrl = onlineLibraryBackendUrl;
        try {
            String olBackendResponse = restTemplate.getForObject(olBackendUrl, String.class);
            System.out.println("Response: " + olBackendResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
