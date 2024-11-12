package com.task.automation.core;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.task.automation.util.ExtentReport;
import com.task.automation.util.ScreenshotUtility;
import com.task.automation.util.StringUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Date;

public class BaseTestCase {
    static Date now = new Date();
    public static String TimeStamp = now.toString().replace(":", "-");
    public static WebDriver driver;

    DriverManager driverManager = new DriverManager();
    public static String baseurl = "";
    //protected static Logging log;
    ExtentReports extentReports;
    ExtentTest extentlog;

    @Parameters({"ReportName", "FlowType"})
    @BeforeSuite(alwaysRun = true)
    public void config(@Optional("Optional name Automation ") String reportname, @Optional("Automation Report") String flow)
            throws IOException {

//		ExtentReport.initialize(System.getProperty("user.dir")+"/results/"+ TimeStamp+" UI_Report.html");
         extentReports = new ExtentReports(System.getProperty("user.dir")+"/results/"+ TimeStamp+" UI_Report.html");
        extentlog = extentReports.startTest("Test Name");
        // Log path
        //	utils.Logging.setLogPath("LocusApi_logs.log");

        // create logging instance
        //	log = Logging.getInstance();

    }

    @BeforeTest
    public void beforeTest() {
        driver = driverManager.getDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        System.out.printf("Test case", "*********************************************************************");
    }


    @AfterMethod
    public void afterMethod(ITestResult result) {
		
			/*if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println(result.getMethod().getMethodName()+" :Passed");
			}
			else if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println(result.getMethod().getMethodName()+" :Failed");
			}
			else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println(result.getMethod().getMethodName()+" :Skipped");
			}
			*/
        //Reporter.log("<a href=\"" + "screenshotfile" +"\" target=\"_blank\">View Screenshot</a><br>");
        if (result.getStatus() == ITestResult.SUCCESS) {
            extentlog.log(LogStatus.PASS, "Test Case: " + result.getName() + " is passed ");

        } else if (result.getStatus() == ITestResult.FAILURE) {
            ExtentReport.extentlog.log(LogStatus.FAIL, "Test case: " + result.getName() + " is failed");
            ExtentReport.extentlog.log(LogStatus.FAIL, "Test case is failed " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentReport.extentlog.log(LogStatus.SKIP, "Test case is Skiped ");
        }
        extentReports.endTest(ExtentReport.extentlog);
        //--------------
        String methodName = StringUtil.createRandomString(result.getMethod().getMethodName());
        System.out.println("METHOD........" + methodName);
        ScreenshotUtility.captureScreenshot(driver, methodName);
        //Reporter.setCurrentTestResult(result);

    }

    @AfterTest
    public void afterTest() {
        driverManager.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void endReport() {
        //ExtentReport.extentreport.flush();
        ExtentReport.extentreport.close();
        System.out.println("Close ExtentReport");
        //Email.sendEmail();

    }

}
