package com.task.automation.test;

import com.task.automation.components.CommonUI;
import com.task.automation.core.BaseTestCase;
import com.task.automation.core.WaitService;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GenericTestCases extends BaseTestCase {

    WaitService  waitService =  new WaitService(driver);
    @Test
    public static void validateIfMenuSelectableAndGivesRightPage() throws InterruptedException {
        CommonUI commonUI =  new CommonUI(driver);
//        commonUI.launchApp();
        commonUI.navigateTo("https://parabank.parasoft.com/parabank/index.htm");
        commonUI.SelectLeftMenu("Services");
//        Thread.sleep(5000);
//        driver.findElement(By.name("username")).sendKeys("admin");
//        Thread.sleep(50000);

    }
}
