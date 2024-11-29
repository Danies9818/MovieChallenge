package com.appiCorp.config;

import com.appiCorp.caller.ApiCaller;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApiRunner implements CommandLineRunner {

    private final ApiCaller apiCaller;

    public ApiRunner(ApiCaller apiCaller) {
        this.apiCaller = apiCaller;
    }

    @Override
    public void run(String... args) {
        System.out.println("Starting API call...");
        apiCaller.callApi();
        System.out.println("API call completed.");
    }
}
