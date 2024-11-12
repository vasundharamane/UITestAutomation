package com.task.automation.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.task.automation.core.BaseTestCase;
import com.task.automation.core.ConfigurationManager;
import com.task.automation.core.WaitService;
import com.task.automation.pages.SignInPage;
import com.task.automation.pages.TaskPage;
import com.task.automation.util.ExtentReport;
import com.task.automation.util.JsonUtil;
import com.task.automation.util.RobotUtility;
import com.task.automation.util.ScreenshotUtility;
import com.task.automation.util.StringUtil;

//import java.awt.Point;
import org.openqa.selenium.Point;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;

public class SignIn extends BaseTestCase {
	//SignInPage sip = new SignInPage(driver);

//	@Test(description="Login with valid credentials")
//	public void verifyLoginWithValidCreds() throws InterruptedException {
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("verifyLoginWithValidCreds",
//				"Verify Login with valid credentials");
//		SignInPage sip = new SignInPage(driver);
//		sip.loginUser("Luke", "Skywalker");
//		Thread.sleep(5000);
//		assertEquals(driver.getCurrentUrl(),"");
//	}
	@Test(description = "Verify functionality to Create a new user")
	public void verifyCreateNewUserWithValid() throws Exception {
		ExtentReport.extentlog = ExtentReport.extentreport.startTest("verifyCreateNewUser",
				"Verify functionality to Create a new user");
		SignInPage sip = new SignInPage(driver);
		sip.launchPage();
		sip.createNewButtonClickIsDisplayed();
		sip.createNewUser();
		assertEquals(true, sip.createNewButton.isEnabled());	
	}
//	@Test(description="Verify functionality to Create a new user")
//	public void verifyCreateNewUserWithInValidUsername() throws InterruptedException, IOException, ParseException {
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("verifyCreateNewUser",
//				"Verify functionality to Create a new user");
//		SignInPage sip = new SignInPage(driver);
//		sip.launchPage();
//		Thread.sleep(6000);
//		sip.loginUser("invalidusername", "password");
//	}
//	@Test(description="Verify functionality to Create a new user")
//	public void verifyCreateNewUserWithInValidPwd() throws Exception {
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("verifyCreateNewUser",
//				"Verify functionality to Create a new user");
//		SignInPage sip = new SignInPage(driver);
//		sip.launchPage();
//		Thread.sleep(6000);
//		sip.login("username", "invalidpassword");
//	}
//	@Test(description="Login with valid credentials")
//	public void verifyLoginWithInValidCreds() throws InterruptedException, IOException, ParseException {
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("verifyLoginWithInValidCreds",
//				"Verify Login with Invalid credentials");
//		SignInPage sip = new SignInPage(driver);
//		sip.loginUser(sip.getTestData("username"), sip.getTestData("password"));
////		Thread.sleep(5000);
////		assertEquals(sip.errorMessage.getText(),"Invalid useame or password!");
//		String str="I love India";
//		String str1= "India";
////		boolean bol = str.contains(str1);
////		assertEquals(bol,true);
//		String[] strarr=str.split(" ");
//		for (int i=0;i<=strarr.length;i++) {
//			if (strarr[i]==str1) {
//				System.out.println("Present");				
//			}
//		}
//		
//	}

//	@Test(description="Validate Login with correct credentials",groups= "Login")
//	public void verifyLoginWithIncorrectC() throws IOException, Exception {
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("verifyLoginWithIncorrectC",
//				"Verify Login with valid credentials");
//		
//		SignInPage signip = new SignInPage(driver);
//		signip.signIn();
//		Thread.sleep(4000);
//		signip.USERNAME.sendKeys("Luke");
//		Thread.sleep(5000);
//		signip.password.sendKeys("Skywalker");
//		Thread.sleep(5000);
//		signip.submit.click();
//		Thread.sleep(5000);
//		//assertEquals(signip.submit.getText(),"Login");
//		String url = driver.getCurrentUrl();
//		String title = driver.getTitle();
//		System.out.println(url + "   " + title);
//		boolean bol1=signip.createBtn.isEnabled();
//		boolean crebtn = signip.createBtn.isDisplayed();
//		boolean crbtn =signip.createBtn.isSelected();
//		System.out.println(signip.createBtn.getText() + "****" +signip.createBtn.getAttribute("ng-click"));
//		System.out.println(crebtn + " $$$$$$$" + crbtn + "%%%%%%%%%" + bol1);
//		assertEquals(url,"https://cafetownsend-angular-rails.herokuapp.com/employees");
//		assertEquals(title, "CafeTownsend-AngularJS-Rails");
//	}
//	@Test(description="Validate Login with correct credentials",groups= "Login")
//	public void verifyLoginWithIncorrectCFailed() throws IOException, Exception {
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("verifyLoginWithIncorrectCFailed",
//				"Verify Login with valid credentials");
//		
//		SignInPage signip = new SignInPage(driver);
//		signip.launchPage();
//		signip.loginUser(JsonUtil.getdatafromjson("$.invalidusername"),JsonUtil.getdatafromjson("$.password"));
//		Thread.sleep(5000);
//		assertEquals(signip.errorMessage.isDisplayed(), true);
//		signip.logoutclick();
//	}
//	@Test(description = "Verify Login with valid credentials",priority=3,groups= {"SmokeTest","RegressionTest","User_BusinessComponent"})
//	public void TC_validateLogin() throws Exception 
//	{
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("TC_validateLogin",
//				"Verify Login with valid credentials");
//	
//			SignInPage signInPage = new SignInPage(driver);
//		
//		signInPage.signIn();
//		//signInPage.username.sendKeys("Luke");
//		Thread.sleep(5000);
//		//signInPage.clearUsername();
//		signInPage.username.sendKeys(SignInPage.getTestData("username"));
//		signInPage.password.sendKeys(SignInPage.getTestData("password"));
//		signInPage.submit.click();
//		Thread.sleep(5000);
//		String url = driver.getCurrentUrl();
//		String title = driver.getTitle();
//		String userfield = signInPage.greetingsmsg.getText();
//		assertEquals(userfield,"Hello Luke");
//		assertEquals(url,SignInPage.getTestData("loginConfirmation"));
//		System.out.println(url + "@@@@@@" + title + "*********" + userfield);
//		String id = signInPage.greetingsmsg.getAttribute("ng-click");
//		//signInPage.loginUser("Luke","Skywalker");
////		Thread.sleep(5000);
////		driver.navigate().refresh();
////		Thread.sleep(5000);
////		driver.navigate().back();
////		Thread.sleep(5000);
////		driver.navigate().forward();
//		//signInPage.logout.click();
//		//assertEquals(, t;rue)
//	}
//	
//	@Test(description = "Verify Login with valid credentials",priority=3,groups="smoke")
//	public void TC_CreateUser() throws Exception 
//	{
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("TC_validateLogin",
//				"Verify Login with valid credentials");
//	
//			SignInPage signInPage = new SignInPage(driver);
//		    WaitService wait = new WaitService(driver);
//		signInPage.signIn();
//		signInPage.loginUser("Luke","Skywalker");
//		wait.waitForElementVisible(signInPage.createUser, 10);
//		signInPage.createUser.click();
//		//wait.waitForElementVisible(signInPage.logout, 10);
//		Thread.sleep(5000);
//		signInPage.FirstNameUser.sendKeys("TestOne");
//		signInPage.LastNameUser.sendKeys("TestTwo");
//		signInPage.StartDateUser.sendKeys("1988-06-15");
//		signInPage.EmailUser.sendKeys("Training@gmail.com");
//		signInPage.AddButtonUser.click();
//		Actions ac = new Actions(driver);
//		ac.moveToElement(signInPage.createUser).build().perform();
//		
//		assertEquals(signInPage.logout.isDisplayed(), true);
//		driver.navigate().refresh();
//		driver.navigate().to("https://google.com");
//		Select technology = new Select(driver.findElement(By.xpath("//select[@id='effectTypes']")));
//		technology.selectByVisibleText("Drop");
//		technology.selectByIndex(4);
//		driver.getCurrentUrl();
//		driver.getTitle();
//		driver.getPageSource();
//		signInPage.username.getText();
//		signInPage.errorInvalidUsernameOrPassword.getAttribute("name");
//		Thread.sleep(5000);
	// }
//	
//
//	@Test(description = "Verify Login error message with invalid username",priority=2,groups="RegressionTest")
//	public void TC_validateInvalidUsernameErrMsg() throws Exception 
//	{
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("TC_validateInvalidUsernameErrMsg",
//				"Verify Login error message with invalid username");
//	
//			SignInPage signInPage = new SignInPage(driver);
//		
//		signInPage.signIn();
//		signInPage.loginUser("test", "ress");
//		//TaskPage taskpage = new TaskPage(driver);
////		signInPage.username.sendKeys(SignInPage.getTestData("invalidusername"));
////		signInPage.password.sendKeys(SignInPage.getTestData("password"));
////		signInPage.submit.click();
////		Thread.sleep(3000);
//		Assert.assertEquals(signInPage.errorMessage.isDisplayed(), true);
//	}
//	@Test
//	public void pracTestSelCom() throws InterruptedException {
//
//		SignInPage signInPage = new SignInPage(driver);
//		driver.get("https://google.com");
//		driver.navigate().to("http://uitestpractice.com/Students/Index");
//		driver.navigate().back();
//		driver.navigate().refresh();
//		Select country = new Select(signInPage.submit);
//		country.selectByVisibleText("Appliances"); // using selectByVisibleText() method
//		country.selectByValue("MX");
//		country.selectByIndex(9);
//		String text = signInPage.submit.getAttribute("text");
//		driver.switchTo().alert().accept();// handle web popups
//		driver.switchTo().alert().dismiss();// handle web popups
//		driver.switchTo().frame(1);// go to frame number one
//		driver.getTitle();// to fetch title of the webpage
//		driver.getCurrentUrl();// to getch the current url of the page
//		signInPage.buttonSignIn.clear();// to clear text
//		String currenttab = driver.getWindowHandle();
//		// perform somae action
//		driver.switchTo().window(currenttab);
//		driver.close();// close current browser window
//		// how to handle web popus/ pop ups/
//		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
//		driver.switchTo().alert().getText();
//		driver.switchTo().alert().sendKeys("test");
//		driver.switchTo().frame(1).findElement(By.id("name")).sendKeys("Test");
//		driver.switchTo().defaultContent();
//		//
//		String parentwindow = driver.getWindowHandle();
//		driver.findElement(By.id("")).click();
//		Set<String> windows = driver.getWindowHandles();
//		for (String whandles : windows) {
//			if (!whandles.equalsIgnoreCase(parentwindow)) {
//				driver.switchTo().window(parentwindow);
//			}
//
//		}
//		// wait
//		Thread.sleep(500);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		WebElement web = driver.findElement(By.name("Testing Controls "));
//		WebDriverWait wait = new WebDriverWait(driver, 300);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Testing Controls ")));
//		wait.until(ExpectedConditions.visibilityOf(web));
//		// wait for a certain condition to appear
//		Wait waitfluent = new FluentWait(driver).withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(10));
//		boolean bol = signInPage.AddButtonUser.isEnabled();
//		boolean bol1 = signInPage.chatBotFrom.isSelected();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollby(0,1000");
//
//	}
////	
//	@Test(description = "Verify Login error message with invalid password",priority=1,groups="RegressionTest")
//	public void TC_validateInvalidPasswordErrMsg() throws Exception 
//	{
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("TC_validateInvalidPasswordErrMsg",
//				"Verify Login error message with invalid password");
//	
//			SignInPage signInPage = new SignInPage(driver);
//		
//		signInPage.signIn();
//		Thread.sleep(5000);
//		TaskPage taskpage = new TaskPage(driver);
//		signInPage.username.sendKeys(SignInPage.getTestData("username"));
//		signInPage.password.sendKeys(SignInPage.getTestData("invalidpassword"));
//		signInPage.username.sendKeys("Luk");
//		signInPage.password.sendKeys("SkyWalker");
//		signInPage.submit.click();
//		Thread.sleep(3000);
//		Assert.assertEquals(signInPage.errorMessage.isDisplayed(), true);
//	}
//
//
//	@Test
//	public static void practg15ui() throws AWTException, WebDriverException, IOException {
//
//		System.setProperty("webdriver.chrome.driver", "/Users/sishukla/Downloads/Task/resources/drivers/chromedriver");
//		WebDriver driver = new ChromeDriver();
////		Proxy prx = new Proxy();
////		prx.setHttpProxy("");
////		ChromeOptions chromeOptions = new ChromeOptions();
////		chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
////		chromeOptions.setProxy(prx);
//		//DesiredCapabilities dsr = new DesiredCapabilities();
//		//dsr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
//		driver.get("http://automationpractice.com/index.php");
//		//driver.navigate().to("http://automationpractice.com/index.php");
//	//	driver.navigate().back();
//	//	driver.navigate().forward();
//		driver.navigate().refresh();
//		driver.findElement(By.id("searchbox"));
//		driver.findElement(By.name("submit_search"));
//		WebElement linkWithMys = driver.findElement(By.linkText("My orders"));
//		List<WebElement> linkWithMy = driver.findElements(By.partialLinkText("My"));
//		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("tshirt");
//		driver.findElement(By.name("submit_search")).click();
//		driver.findElement(By.xpath("//input[@id='search_query_top']")).clear();
//		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("shirt");
//		driver.findElement(By.name("submit_search")).click();
//		Select country = new Select(driver.findElement(By.id("countriesSingle")));
//		country.selectByVisibleText("England");
//		country.selectByValue("england");
//		//country.selectByIndex(3);
//		country.deselectAll();
//		country.getAllSelectedOptions();
//		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
//		driver.switchTo().alert().sendKeys("test alert input");
//		String popUpText = driver.switchTo().alert().getText();
//		driver.switchTo().frame(1);
//		driver.switchTo().frame("iframe_a");
//		WebElement frameIdentification = driver.findElement(By.name("iframe_a"));
//		driver.switchTo().frame(frameIdentification);
//		driver.switchTo().defaultContent();
//		//save our parent window handle
//		String parent = driver.getWindowHandle();
//		//click on the link which will open new window
//		driver.findElement(By.xpath("//a[contains(text(),'Opens in a new window')]")).click();
//		//getwindowhandles return set<>
//		Set<String> getwindh = driver.getWindowHandles();
//		//loop across the set and we will validate with parent window handle
//		for (String i : getwindh) {
//			if (!(i == parent)) {
//				driver.switchTo().window(i);
//				driver.close();
//			}
//		}
//		//driver.close();
//		String title = driver.getTitle();
//		String currentURL = driver.getCurrentUrl();
//		String webelementText = driver.findElement(By.id("")).getText();
//		String footerURL = driver.findElement(By.xpath("//a[contains(text(),'Ecommerce software by PrestaShop™')]")).getAttribute("href");
//		String pageSource = driver.getPageSource();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
//		WebElement logoForVisibilityValidation = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
//		explicitWait.until(ExpectedConditions.visibilityOf(logoForVisibilityValidation));
//		Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2))
//				.ignoring(Exception.class);
//		boolean bol = driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).isEnabled();
//		if (bol == true) {
//			System.out.println("button is ENABLE");
//		}else {
//			System.out.println("button is DISABLE");
//		}
//		int width = driver.manage().window().getSize().getWidth();
//		int height = driver.manage().window().getSize().getHeight();
//		Dimension size = driver.manage().window().getSize();
//		size.getHeight();
//		size.getWidth();
//		Dimension setSize = new Dimension(1020, 960);
//		driver.manage().window().setSize(setSize);
//		Point setCoordinate = new Point (1020,960);
//		driver.manage().window().setPosition(setCoordinate);
//		driver.manage().window().getPosition().getX();
//		driver.manage().window().getPosition().getY();
//		driver.manage().window().maximize();//framework
//		driver.manage().window().fullscreen();
//		driver.manage().getCookies();
//		driver.manage().getCookieNamed("SIDCC");
//		driver.manage().deleteCookieNamed("__Secure-3PSID");
//		driver.manage().deleteAllCookies();//framework
//		Cookie cookie1 = new Cookie("test2", "cookie2");
//		driver.manage().addCookie(cookie1);
//		Actions act = new Actions(driver);
//		act.contextClick();
//		act.doubleClick();
//		WebElement sourceLocation = driver.findElement(By.xpath("//img[@id='text']"));
//		WebElement destinationLocation = driver.findElement(By.xpath("//img[@id='text']"));	
//		act.dragAndDrop(sourceLocation, destinationLocation);
//		
//		Action actinterface = act
//				              .click()
//				              .clickAndHold()
//				              .doubleClick()
//				              .build();
//		actinterface.perform();
//		Robot roboKey = new Robot();
//		roboKey.keyPress(KeyEvent.VK_ENTER);
//		roboKey.keyPress(KeyEvent.VK_TAB);
//		roboKey.keyPress(KeyEvent.VK_ESCAPE);
//		TakesScreenshot screenShot =(TakesScreenshot)driver;
//		FileHandler.copy(screenShot.getScreenshotAs(OutputType.FILE), new File("/Users/sishukla/Downloads/Task/results"));
//		JavascriptExecutor js = (JavascriptExecutor) driver; 
//		js.executeScript(("window.scrollBy(100,100)"));
//		
//	}
//
//	@Test
//	public static void practicegrp3ui() throws AWTException {
//		ConfigurationManager configurationManager = new ConfigurationManager();
//		System.setProperty("webdriver.firefox.driver",
//				configurationManager.properties.getProperty("firefox.driver.path"));
//		DesiredCapabilities dsr = new DesiredCapabilities();
//		dsr.setAcceptInsecureCerts(true);
//		FirefoxOptions firefoxOptions = new FirefoxOptions();
//		firefoxOptions.addPreference("permissions.default.microphone", 1);
//		firefoxOptions.addPreference("permissions.default.camera", 1);
//		firefoxOptions.setAcceptInsecureCerts(false);
//		firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		WebDriver driver = new FirefoxDriver(firefoxOptions);
//		WebDriver driverch = new ChromeDriver();
//		driver.get("https://cafetownsend-angular-rails.herokuapp.com/login");
//		driver.navigate().to("https://cafetownsend-angular-rails.herokuapp.com/login");
//		driver.navigate().refresh();
//		driver.navigate().back();
//		driver.navigate().forward();
//		driver.findElement(By.id("countriesSingle")).click();
//		driver.findElements(By.id("user"));
//		Select slc = new Select(driver.findElement(By.id("countriesSingle")));
//		slc.selectByIndex(2);
//		slc.selectByVisibleText("China");
//		slc.selectByValue("china");
//		driver.getPageSource();
//		driver.findElement(By.id("countriesSingle")).getAttribute("class");
//		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
//		String popuptext = driver.switchTo().alert().getText();
//		driver.switchTo().alert().sendKeys("TestMsg");
//		driver.switchTo().frame("iframe1");
//		WebElement framew = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
//		driver.switchTo().frame(framew);
//		driver.switchTo().defaultContent();
//		String parent = driver.getWindowHandle();
//		Set<String> getwindh = driver.getWindowHandles();
//		for (String whd : getwindh) {
//			if (!(whd == parent)) {
//				driver.switchTo().window(whd);
//			}
//		}
//		driver.close();
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		WebDriverWait waitw = new WebDriverWait(driver, 60000);
//		waitw.until(ExpectedConditions.presenceOfElementLocated(By.name("login")));
//		waitw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@name='iframe_a']")));
//		Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(600)).pollingEvery(Duration.ofSeconds(60))
//				.ignoring(Exception.class);
//
//		SignInPage signInPage = new SignInPage(driver);
//		signInPage.buttonSignIn.isEnabled();
//		// 4th class
//		driver.manage().window().maximize();
//		driver.manage().window().setSize(new Dimension(1024, 768));
//		Dimension size = driver.manage().window().getSize();
//		int width1 = size.getWidth();
//		int height1 = size.getHeight();
//		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
//		WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));
//		Actions builder = new Actions(driver);// actions is a class-it has all the methods
//		builder.dragAndDrop(source, destination);
//		Action actio = builder// action is an interface
//				.dragAndDrop(source, destination).click().keyDown("login-textbox").sendKeys("login-textbox", "hello")
//				.keyUp("login-textbox").doubleClick().contextClick().build();
//		builder.perform();
//
//		Robot robo = new Robot();
//		robo.keyPress(KeyEvent.VK_ENTER);
//
//		driver.manage().getCookies();
//		driver.manage().getCookieNamed("APISID");
//		driver.manage().deleteCookieNamed("APISID");
//		driver.manage().deleteAllCookies();
//		Cookie cookie1 = new Cookie("test2", "cookie2");
//		driver.manage().addCookie(cookie1);
//
//	}
////   @Test
////   public static void weguipractice() throws InterruptedException, AWTException, WebDriverException, IOException {
////	   System.setProperty("webdriver.chrome.driver","C:\\Task\\resources\\drivers\\chromedriver.exe");
////	   ChromeOptions chromeOptions = new ChromeOptions();
////	   chromeOptions.setAcceptInsecureCerts(true);
////	   chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
////	   chromeOptions.addArguments("");
////	  // WebDriver driver = new ChromeDriver(chromeOptions);
////	   WebDriver driver = new ChromeDriver();
////	   driver.get("http://the-internet.herokuapp.com/");
////	   Thread.sleep(5000);
////	  // driver.navigate().to("https://www.glasslewis.com/");
////	   
//////	   driver.navigate().back();
//////	   driver.navigate().forward();
//////	   driver.navigate().refresh();
//////	   WebElement glass=  driver.findElement(By.xpath("//a[contains(text(),'Glass')]"));
//////	   glass.click();
//////	   glass.sendKeys("amazon");
//////	   glass.clear();
//////	   glass.sendKeys("flipcart");
//////	   List<WebElement> glassList = driver.findElements(By.xpath("//a[contains(text(),'Glass')]"));
////	   
//////	   SignInPage sip = new SignInPage(driver);
//////	   sip.USERNAME.sendKeys("Luke");
//////	   sip.USERNAME.clear();
//////	   sip.USERNAME.sendKeys("Luke");
//////	   sip.password.sendKeys("Skywalker");
//////	   sip.loginButtonClick();
////	   
//////	   Select slc = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
//////	   slc.selectByIndex(2);
//////	   slc.selectByVisibleText("Option 2");
//////	   slc.selectByValue("2");
//////	   slc.getAllSelectedOptions();
////	   String title = driver.getTitle();
////	   String url = driver.getCurrentUrl();
////	   System.out.println(title + " ****************" + url);
////	   driver.getPageSource();
////	   String getTextwe= driver.findElement(By.xpath("//h1[contains(text(),'Welcome')]")).getText();
////	   System.out.println(getTextwe);
////	   String attr=driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]")).getAttribute("href");
////	   System.out.println(attr);
////	   
////	   driver.switchTo().alert().accept();
////	   driver.switchTo().alert().dismiss();
////	   String popuptext = driver.switchTo().alert().getText();
////	   driver.switchTo().alert().sendKeys("TestMsg");
//////	   
////	   driver.switchTo().frame(3);
////	   driver.switchTo().frame("Iframe_a");
////	   WebElement framew = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
////       driver.switchTo().frame(framew);
////	   driver.switchTo().defaultContent();
//////	   
////	   String parent = driver.getWindowHandle();//to get parent window handle
////	   driver.findElement(By.xpath("//a[contains(text(),'Opens in a new window')]")).click();
////	   Set<String> getwindh = driver.getWindowHandles();
////	  // Set<String> str = new HashSet<String>();
////	   for (String whd:getwindh) {
////		   if ((whd==parent)) {
////			   driver.switchTo().window(whd);
////			   driver.close();
////		   }
////	   }
////	   driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//////	   
////	   WebDriverWait waitw = new WebDriverWait(driver,25);
////	   waitw.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'USERNAME')]")));
//////	   waitw.until(ExpectedConditions.visibilityOf(sip.EmailUser));
//////	   
//////	   Wait wait = new FluentWait(driver)
//////			   .withTimeout(Duration.ofSeconds(120))
//////			   .pollingEvery(Duration.ofSeconds(20))
//////			   .ignoring(Exception.class);
//////	  
////	 if (driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).isDisplayed()==true) {
////		 System.out.println("Create button is Enabled");}
////		 else {
////			 System.out.println("Create button is Not Enabled");
////		 }
////	 
////	driver.manage().window().maximize();
////	int height = driver.manage().window().getSize().getHeight();
////	int width =  driver.manage().window().getSize().getWidth();
////	Dimension size = driver.manage().window().getSize();
////	int width1 = size.getWidth();
////	int height1 = size.getHeight();
////	Dimension dms = new Dimension(111,111);
////	driver.manage().window().setSize(dms);
////	//position with point
////	int x = driver.manage().window().getPosition().getX();
////	int y = driver.manage().window().getPosition().getY();
////	Point pnt = new Point(11,11);
////	driver.manage().window().setPosition(pnt);
////
////	
////	Robot robo = new Robot();
////    robo.keyPress(KeyEvent.VK_0);
////    robo.keyPress(KeyEvent.VK_UNDERSCORE);
////   
////      WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
////	  WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));
////	  
////	  Actions builder = new Actions(driver);//actions is a class-it has all the methods
////	  builder.dragAndDrop(source, destination);
////	 
////	  Action  actio = builder//action is an interface
////      .dragAndDrop(source,destination)
////	  .click()
////	  .keyDown("login-textbox")
////	  .sendKeys("login-textbox", "hello")
////	  .keyUp("login-textbox")
////	  .doubleClick()
////	  .contextClick()
////	  .build();
////	  builder.perform();
////   
////	driver.manage().deleteAllCookies();
////	driver.manage().deleteCookieNamed("_CafeTownsend-Angular-Rails_session");
////	Set<Cookie> cookies = driver.manage().getCookies();
////	Cookie cookie = driver.manage().getCookieNamed("SSID");
////	Cookie cookie1 = new Cookie("SSID", "A1b-9CL69jfbb3iSb");
////	driver.manage().addCookie(cookie1);
////	
////
////	
////	TakesScreenshot screenShot =(TakesScreenshot)driver;
////	FileHandler.copy(screenShot.getScreenshotAs(OutputType.FILE),new File("C:\\Task\\target\\surefire-reports\\screenshots"));
////   
////	
////	JavascriptExecutor jscrp = (JavascriptExecutor) driver;
////	jscrp.executeScript("window.scrollBy(10,100)");
////	
////	ChromeOptions chrooptobject = new ChromeOptions();// Create object Proxy class - Approach 2
////	Proxy proxyobject = new Proxy();
////	proxyobject.setHttpProxy("myhttpproxy:3337");
////	proxyobject.setSocksUsername("username");
////	proxyobject.setSocksPassword("password");// register the proxy with options class - Approach 2
////	chrooptobject.setProxy(proxyobject);
////
////	
//////	
//////	 //  chromeOptions.setProxy("");
//////	    //chromeOptions.addPreference("permissions.default.microphone", 1);
//////	    DesiredCapabilities caps = new DesiredCapabilities(); 
//////	    caps.setCapability("browserName", "firefox"); 
//////	    caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//////	    
//////	    
//////	    WebDriver driver1 = new FirefoxDriver();
//////	    WebDriver driver2 = new InternetExplorerDriver();
////	   
////   }
////	@Test
////	public void pracg6ui() throws AWTException, WebDriverException, IOException {
////		System.getProperty("webdriver.chrome.driver","path of driver exe for chrome");
////		ChromeOptions cmdts = new ChromeOptions();
////		cmdts.setAcceptInsecureCerts(false);
////		cmdts.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
////		cmdts.setCapability("permissions.default.microphone", true);
////		cmdts.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
////		WebDriver driver1 = new ChromeDriver(cmdts);
////		
////		driver1.get("https://www.google.com");
////		driver1.navigate().to("https://www.google.com");
////		
////		System.getProperty("webdriver.gecko.driver","path of driver exe for firefox");
////		WebDriver driver = new FirefoxDriver();
////		WebDriver driver2 = new InternetExplorerDriver();
////		WebElement countryID = driver.findElement(By.xpath("//select[@id='sel1']"));
////		List<WebElement> searchDataTexts = driver.findElements(By.id("idFromPage"));
////		countryID.sendKeys("iuy");
////		countryID.click();
////		countryID.clear();
////		Select country = new Select(countryID);
////		country.deselectAll();
////		country.selectByIndex(14);
////		country.selectByValue("Canada");
////		country.selectByVisibleText("Canada");
////		String currURL = driver.getCurrentUrl();
////		String title = driver.getTitle();
////		driver.getPageSource();
////		countryID.getText();
////		String getattri = countryID.getAttribute("ng-click");
////		country.getOptions();
////		driver.switchTo().alert().accept();
////		driver.switchTo().alert().dismiss();
////		driver.switchTo().alert().sendKeys("sidharth");
////		driver.switchTo().alert().getText();
////		driver.switchTo().frame(1);
////		driver.switchTo().frame("iframe_a");
////		WebElement frame = driver.findElement(By.xpath("//h1[contains(text(),'Iframe')]"));
////		driver.switchTo().frame(frame);
////		driver.switchTo().defaultContent();
////		
////		String parentwindow = driver.getWindowHandle();
////		driver.findElement(By.id("")).click();
////		Set<String> windows = driver.getWindowHandles();
////		for (String whandles:windows) {
////			if (!whandles.equalsIgnoreCase(parentwindow))
////			{
////			//perform action in child window
////			driver.switchTo().window(parentwindow);	
////			}
////			
////		}
////		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
////		WebDriverWait wait = new WebDriverWait(driver,60);
////		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='navbar-brand']")));
////		wait.until(ExpectedConditions.alertIsPresent());
////		
////		Wait waitf = new FluentWait(driver)
////				.withTimeout(Duration.ofSeconds(60))
////				.pollingEvery(Duration.ofSeconds(10))
////				.ignoring(Exception.class);
////		
////		WebElement foo=(WebElement) waitf.until(new Function<WebDriver, WebElement>() {
////			public WebElement apply(WebDriver driver) 
////			{
////			return driver.findElement(By.xpath("//a[@class='navbar-brand']"));
////			}
////			});
////
////          int width = driver.manage().window().getSize().getWidth();
////          int height = driver.manage().window().getSize().getHeight();
////          Dimension sizes = driver.manage().window().getSize();
////          int width1 = sizes.getWidth();
////          int height1 = sizes.getHeight();
////          int xcord = driver.manage().window().getPosition().getX();
////          int ycord = driver.manage().window().getPosition().getY();
////          Point coordinates = driver.manage().window().getPosition();
////          int xcord1 = coordinates.getX();
////          int ycord1 = coordinates.getX();
////          driver.manage().window().maximize();
////          driver.manage().window().fullscreen();
////          Robot robo = new Robot();
////   	      robo.keyPress(KeyEvent.VK_ENTER);
////   	      robo.keyPress(KeyEvent.VK_F5);
////   	   WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
////   	  WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));
//// 	  Actions builder = new Actions(driver);//actions is a class-it has all the methods
//// 	 builder.dragAndDrop(source, destination);
////	  Action  actio = builder//action is an interface
////      .dragAndDrop(source,destination)
//// 	  .click()
//// 	  .keyDown("login-textbox")
////// 	  .sendKeys("login-textbox", "hello")
////// 	  .keyUp("login-textbox")
//// 	  .doubleClick()
////// 	  .contextClick()
//// 	  .build();
//// 	  builder.perform();
//// 	 driver.manage().deleteAllCookies(); 
//// 	driver.manage().deleteCookieNamed("SSID");
//// 	 Set<Cookie> allcookies = driver.manage().getCookies();
//// 	 Cookie ssidvalue = driver.manage().getCookieNamed("SSID");
//// 	Cookie cookie1 = new Cookie("test2", "cookie2");
//// 	driver.manage().addCookie(cookie1);
//// 	driver.manage().deleteCookie(cookie1); 
//// 	
//// 	TakesScreenshot screenShot =(TakesScreenshot)driver;
//// 	File filefrom =screenShot.getScreenshotAs(OutputType.FILE);
//// 	File fileto = new File("path/to/destination/folder/screenshot.png");
//// 	FileHandler.copy(filefrom, fileto );
////
//// 	Proxy proxy = new Proxy();
//// 	proxy.setHttpProxy("username:password.myhttpproxy:3337");
//// 	proxy.getHttpProxy();
//// 	proxy.setSslProxy("");
//// 	
//// 	JavascriptExecutor js = (JavascriptExecutor) driver;
////	js.executeScript("window.scrollby(0,1000)");
//// 	  
////   	      
////	}
////	@Test(description="Verify the login with valid credentials")
////	public void verifyLogin() throws InterruptedException, IOException {
////		ExtentReport.extentlog = ExtentReport.extentreport.startTest("verifyLogin",
////				"Verify Login with valid credentials");
////		
////	     SignInPage signin = new SignInPage(driver);
////	     signin.launchPage();
////	     signin.loginUser(JsonUtil.getdatafromjson("$.username"),JsonUtil.getdatafromjson("$.password"));//JsonUtil.getdatafromjson("$.password")
////	     SoftAssert sft = new SoftAssert();
////	     sft.assertEquals(driver.getCurrentUrl(),JsonUtil.getdatafromjson("$.loginConfirmation"));
////	     sft.assertEquals("test", "test");
////	     sft.assertEquals("test", "est");
////	     sft.assertEquals("test", "test");
////	     System.out.println("test");
////	     sft.assertAll();
////	     signin.logoutclick();
////	     
////	}
//////	@Test
//////	public void sum() {
//////		ExtentReport.extentlog = ExtentReport.extentreport.startTest("verifyLogin",
//////				"Verify Login with valid credentials");
//////		
//////		int output = suminteger(2,3);
//////		System.out.println("Sum of both the integers is: " + output);
//////		String email =  StringUtil.createRandomString("test") + "@gmail.com";
//////		System.out.println(email);
//////	}
//////	
//////	public static int suminteger(int a, int b) {
//////		int sumint= a+b;
//////		return sumint;
//////		
//////	}
////	public static void testone() {
////		List<String> ldt1= new ArrayList<String>();
////		int[] arr1= {1,2,3,4,5};
////		
////		String str="string";
////		int n=str.length();
////		String rev="";
////		for(int i=n-1;i>=0;i--) {
////			System.out.println(str.charAt(i));
////			rev=rev+str.charAt(i);
////		}System.out.println(rev);
////		
////	}
////	public static void main (String[] args) {
////		testone();
////	}
////	
//	
//	@Test(description = "Verify Login error message with invalid password",priority=1,groups="RegressionTest")
//	public void TC_validate() throws Exception 
//	{
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("TC_validateInvalidPasswordErrMsg",
//				"Verify Login error message with invalid password");
//	
//		
//		System.setProperty("webdriver.chrome.driver","/path");
//		
////		ChromeOptions chromeOptions = new ChromeOptions(); 
////		chromeOptions.setAcceptInsecureCerts(false);
////		chromeOptions.setCapability("Audio", "true");
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://google.com");
//		driver.navigate().to("http://google.com");
//		driver.findElements(null);
//		driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).click();
//		driver.findElement(By.id("Search_Data")).sendKeys("test");
//		driver.findElement(By.id("Search_Data")).clear();
//		driver.findElement(By.id("Search_Data")).sendKeys("testone");
//		Select dropdown = new Select(driver.findElement(By.id("countriesSingle")));
//		dropdown.selectByVisibleText("China");
//		dropdown.selectByValue("china");
//		driver.getCurrentUrl();
//		driver.getTitle();
//		driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).getText();
//		driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).getAttribute("type");
//		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
//		driver.switchTo().alert().sendKeys("text on the pop up");
//		driver.switchTo().alert().getText();
//		WebElement frame = driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/iframe[1]"));
//		driver.switchTo().frame(frame);
//		driver.switchTo().defaultContent();
//		 String parent = driver.getWindowHandle();//to get parent window handle
//		   driver.findElement(By.xpath("//a[contains(text(),'Opens in a new window')]")).click();
//		   Set<String> getwindh = driver.getWindowHandles();
//		  // Set<String> str = new HashSet<String>();
//		   for (String whd:getwindh) {
//			   if ((whd==parent)) {
//				   driver.switchTo().window(whd);
//				   //perform actions on child window
//				   driver.close();
//			   }
//		   }
//		   Dimension size = driver.manage().window().getSize();
//		   size.getHeight();
//		   size.getWidth();
//		   driver.manage().window().setSize(new Dimension(1024, 768));
//		   
//		   Point position = driver.manage().window().getPosition();
//		   position.getX();
//		   position.getY();
//		   driver.manage().window().setPosition(new Point(0, 0));
//		   
//		   driver.manage().window().maximize();
//		   
//		   Proxy proxy = new Proxy();
//		   proxy.setSslProxy("");
//		   proxy.setSocksUsername("");
//		  // chromeOptions.setProxy(proxy);
//		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		   WebDriverWait wait = new WebDriverWait(driver,10);
//		   wait.until(ExpectedConditions.presenceOfElementLocated(By.name("login")));
//		   Wait waitfluent = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
//					         .pollingEvery(Duration.ofSeconds(3));
//
//		   Actions builder = new Actions(driver);
//		   builder.doubleClick();
//		   
//		   Action actions = builder
//		    .moveToElement(frame)
//		    .click()
//		    .contextClick()
//		    .build();
//		   
//		   actions.perform() ;
//		   
//		   Robot robokey = new Robot();
//		   robokey.keyPress(KeyEvent.VK_CAPS_LOCK);
//           robokey.keyPress(KeyEvent.VK_CONTROL);
//           robokey.keyPress(KeyEvent.VK_S);
//           robokey.keyRelease(KeyEvent.VK_CONTROL);
//           robokey.keyRelease(KeyEvent.VK_S);
//
//           
//
//		   
//		   
//	
//	}
}
