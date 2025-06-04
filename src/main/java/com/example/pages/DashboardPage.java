package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashboardPage {
    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);
    private WebDriver driver;

    @FindBy(href = "#default_personal/dashboard")
    private WebElement dashboardLink;

    @FindBy(xpath = "//button[text()='Add New Dashboard']")
    private WebElement addDashboardButton;

    @FindBy(css = "input[type='text']")
    public WebElement dashboardField;

    @FindBy(xpath = "//button[text()='Add new widget']")
    private WebElement addWidgetButton;

    @FindBy(xpath = "//li[normalize-space()='Project activity panel']")
    public WebElement projectActivityItem;

    @FindBy(xpath = "//button[text()='Next step']")
    private WebElement nextStepButton;

    @FindBy(xpath = "//button[text()='Add']")
    private WebElement saveWidgetButton;

    @FindBy(xpath = "//*[normalize-space(text())='Project activity panel']")
    WebElement projectPanel;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToDashboard() {
        logger.info("Navigating to Dashboard");
        dashboardLink.click();
    }

    public void waitForElementToLoad(WebElement element) {
        logger.info("Waiting for Dashboard page to load");
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(driver -> dashboardLink.isDisplayed());
    }

    public void addTaskProgressWidget() {
        logger.info("Adding Task Progress Widget");
        addWidgetButton.click();
        projectActivityItem.click();
        nextStepButton.click();
        nextStepButton.click();
        saveWidgetButton.click();
    }

    public boolean isWidgetDisplayed() {
        boolean displayed = projectPanel.isDisplayed();
        logger.info("Project Panel displayed: {}", displayed);
        return displayed;
    }
}
