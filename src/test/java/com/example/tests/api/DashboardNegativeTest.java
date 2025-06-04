package com.example.tests.api;

import com.example.api.ApiClient;
import com.example.utils.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("API Tests")
public class DashboardNegativeTest {

    @Test
    @Description("Test to verify Dashboard creation fails with missing parameters")
    public void testCreateDashboardWithMissingParams() {
        // Arrange
        String apiKey = ConfigReader.getProperty("api.key");

        // Act
        Response response = ApiClient.createDashboardWithMissingParams(apiKey);

        // Assert
        Assert.assertEquals(response.getStatusCode(), 400, "Expected 400 status code for missing parameters");
        Response dashboards = ApiClient.getDashboards(apiKey);
        String responseBody = dashboards.getBody().asString();
        Assert.assertFalse(responseBody.contains("null"), "Dashboard with missing parameters found in list");
    }
}
