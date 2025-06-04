package com.example.tests.api;

import com.example.api.ApiClient;
import com.example.utils.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("API Tests")
public class DashboardCreationTest {

    @Test
    @Description("Test to verify creating a new Dashboard via API")
    public void testCreateDashboard() {
        // Arrange
        String apiKey = ConfigReader.getProperty("api.key");
        String dashboardName = "TestDashboard_" + System.currentTimeMillis();

        // Act
        Response response = ApiClient.createDashboard(apiKey, dashboardName);

        // Assert
        Assert.assertEquals(response.getStatusCode(), 201, "Dashboard creation failed");
        Response dashboards = ApiClient.getDashboards(apiKey);
        String responseBody = dashboards.getBody().asString();
        Assert.assertTrue(responseBody.contains(dashboardName), "Dashboard not found in the list");
    }
}
