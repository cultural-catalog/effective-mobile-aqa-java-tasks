package com.example.tests.ui;

import com.example.pages.LoginPage;
import com.example.pages.DashboardPage;
import com.example.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("UI Tests")
public class WidgetTest extends BaseTest {

    @Test
    @Description("Test to verify adding a Task Progress Widget")
    public void testAddTaskProgressWidget() {
        // Arrange
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        // Act
        loginPage.login("default", "1q2w3e");
        dashboardPage.navigateToDashboard();
        dashboardPage.addTaskProgressWidget();

        // Assert
        Assert.assertTrue(dashboardPage.isWidgetDisplayed(), "Project activity panel is not displayed");
    }
}
