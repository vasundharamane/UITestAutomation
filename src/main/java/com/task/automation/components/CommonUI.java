package com.task.automation.components;

import com.task.automation.core.DriverManager;
import com.task.automation.core.WaitService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonUI {
    @FindBy(xpath = "//ul[@class='leftmenu']")
    public WebElement leftMenu;

    @FindBy(name = "username")
    public WebElement username;

    WebDriver driver;
    WebDriverWait wait;
    WaitService waitService;

    public CommonUI(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         waitService =  new WaitService(driver);
    }

    public void SelectLeftMenu(String leftMenuOption) {
        waitService.waitForElementVisible(leftMenu, 100);
        WebElement item = leftMenu.findElement(By.linkText(leftMenuOption));
        item.click();  // Perform click or another action as required
    }

    public void launchApp() {
//        DriverManager driverManager = new DriverManager();
//        this.driver = driverManager.getDriver();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }
}
