package com.example.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.utils.ConfigReader;

public class ApiClient {
    private static final Logger logger = LoggerFactory.getLogger(ApiClient.class);
    private static final String BASE_URI = ConfigReader.getProperty("base.uri");

    public static Response createDashboard(String apiKey, String dashboardName) {
        logger.info("Creating Dashboard with name: {}", dashboardName);
        String payload = String.format("{\"name\": \"%s\", \"description\": \"Auto-generated dashboard\"}", dashboardName);
        return RestAssured.given()
                .header("Authorization", "Bearer " + apiKey)
                .contentType(ContentType.JSON)
                .body(payload)
                .post(BASE_URI + "/api/v1/dashboards");
    }

    public static Response createDashboardWithMissingParams(String apiKey) {
        logger.info("Attempting to create Dashboard with missing parameters");
        String payload = "{}";
        return RestAssured.given()
                .header("Authorization", "Bearer " + apiKey)
                .contentType(ContentType.JSON)
                .body(payload)
                .post(BASE_URI + "/api/v1/dashboards");
    }

    public static Response getDashboards(String apiKey) {
        logger.info("Fetching list of Dashboards");
        return RestAssured.given()
                .header("Authorization", "Bearer " + apiKey)
                .get(BASE_URI + "/api/v1/dashboards");
    }
}
