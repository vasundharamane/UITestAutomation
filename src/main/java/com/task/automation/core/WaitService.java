package com.task.automation.core;

import java.awt.TrayIcon.MessageType;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WaitService {

	private WebDriver driver;

	public WaitService(WebDriver driver) {

		this.driver = driver;
	}

	public void waitForElementVisible(WebElement element, long timeout) {

		try {
			new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Reporter.log(element.toString() + "is not visible");
			Reporter.log(e.getStackTrace().toString());
//			System.out.println(e.printStackTrace());
		}

	}

	public void waitForElementPresent(WebElement element, long timeout) {

		try {
			new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated((By) element));
		} catch (NoSuchElementException e) {
			Reporter.log(element.toString() + "is not present");
			Reporter.log(e.getStackTrace().toString());
		}
	}

}
