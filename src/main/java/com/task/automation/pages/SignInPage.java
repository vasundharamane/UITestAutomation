package com.task.automation.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.task.automation.util.JsonUtil;
import com.task.automation.util.ScreenshotUtility;

public class SignInPage {

	WebDriver driver;
	WebDriverWait wait;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	}

	public void launchPage() throws InterruptedException {
		
		//driver.manage().deleteAllCookies();
		//driver.get("http://uitestpractice.com/Students/Index");
		driver.get("http://www.uitestpractice.com/Students/Index");
		//driver.get("http://test$_@gmail.com:test123@localhost:3001/signin");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		
		//waitForPageToLoad(logo);
	}
	
	public void waitForPageToLoad(){
		//explicit wait need with condition
		wait.until(ExpectedConditions.visibilityOf(logo));
	}
	
	public void waitForPageToLoad(WebElement webele){
		//explicit wait need with condition
		wait.until(ExpectedConditions.visibilityOf(webele));
	}
	
	//p[@class='error-message ng-binding' and @ng-show='showMessage']
	@FindBy(xpath="//a[contains(text(),'Create New')]")
	public WebElement createNewButton;
	
	@FindBy(xpath="//input[@name='input_username']")
	public WebElement glewisusername;
	
	@FindBy(xpath="//input[@name='input_password']")
	public WebElement glewispassword; 
	
	@FindBy(xpath="//button[@id='btn-submit']")
	public WebElement glewissubmit;
	
	@FindBy(xpath="//input[@id='Search_Data']")
	public WebElement searchInputBox; 
	
	@FindBy(xpath="//input[contains(@class,'btn')]")
	public WebElement findButton;
	
	@FindBy(xpath="//tbody[1]//tr[2]//td[1]")
	public WebElement firstCellValue;
	
	@FindBy(xpath="//input[@id='FirstName']")
	public WebElement firstNameStu;
	
	@FindBy(xpath="//input[@id='LastName']")
	public WebElement lastNameStu;
	
	@FindBy(xpath="//input[@id='EnrollmentDate']")
	public WebElement enrolDateStu;
	
	@FindBy(xpath="//input[@value='Create']")
	public WebElement createButton;
	
	@FindBy(xpath="//input[@ng-model='user.name']")
	public WebElement USERNAME;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@ng-model='user.name']")
	public WebElement username;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submit;
	
	@FindBy(xpath="//p[@ng-click='logout()']")
	public WebElement logout;
	
	@FindBy(xpath="//p[@class='error-message ng-binding']")
	public WebElement errorMessage;
	
	@FindBy(xpath="//p[@id='greetings']")
	public WebElement greetingsmsg;
	
	@FindBy(xpath="//div[@class='main-view-wrapper main-view-wrapper-loggedIn']")
	public WebElement logo;
	//div[@class='style__logo_div__24RfS']//img
	
	@FindBy(xpath="//input[@placeholder='Email']")
	public WebElement textboxUsername;

	@FindBy(xpath="//input[@placeholder='Password']")
	public WebElement textboxPassword;

	@FindBy(xpath="//span[contains(text(),'Sign in')]")
	public WebElement buttonSignIn;

	@FindBy(xpath="//span[contains(.,\"Email is required\")]")
	public WebElement errorEmailIsRequired;
	
	@FindBy(xpath="//span[contains(.,\"Password is required\")]")
	public WebElement errorPasswordIsRequired;
	
	@FindBy(xpath="//span[contains(text(),'Network error. Failed to connect with server')]")
	public WebElement errorInvalidUsernameOrPassword;
	
	@FindBy(xpath="//*[@class=\"style__errorMessage__1xJlO\"]/span[text()=\"You are not authorized user. Please contact administrator.\"]")
	public WebElement errorUnathorisedUser;

	@FindBy(xpath="//div[contains(@class,'botMinimiseCloseImg')]")
	public WebElement closeAvaChat;
	
	//div[@class='style__botMinimiseCloseImg__3D1eg']//img
	
	@FindBy(xpath="//div[@style='touch-action: none; transform: translate(0px, 0px);']")
	public WebElement chatBotFrom;
	
	@FindBy(xpath="//div[8]//div[16]")
	public WebElement chatBotTo;
	
	@FindBy (xpath="//a[@ng-click='createEmployee()']")
	public WebElement createUser;
	
	@FindBy (xpath="//input[@ng-model='selectedEmployee.firstName']")
	public WebElement FirstNameUser;
	
	@FindBy (xpath="//a[@ng-click='createEmployee()']")
	public WebElement createBtn;
	
	@FindBy (xpath="//input[@ng-model='selectedEmployee.lastName']")
	public WebElement LastNameUser;
	
	@FindBy (xpath="//input[@ng-model='selectedEmployee.startDate']")
	public WebElement StartDateUser;
	
	@FindBy (xpath="//input[@ng-model='selectedEmployee.email']")
	public WebElement EmailUser;
	
	@FindBy (xpath="//button[@ng-show='isCreateForm']")
	public WebElement AddButtonUser;
	
	@FindBy (xpath="//font[@color='red']")
	public WebElement errMessageGL;
	
	public void clearUsername() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.USERNAME.clear();
		Thread.sleep(5000);
	}
	
	public void createNewButtonClickIsDisplayed () throws Exception, IOException {
		SignInPage sip = new SignInPage(driver);
		sip.createNewButton.isDisplayed();
		sip.createNewButton.click();
		Thread.sleep(6000);
	}
	
	public void createNewUser() throws InterruptedException, IOException, ParseException {
		SignInPage sip = new SignInPage(driver);
		sip.firstNameStu.sendKeys(JsonUtil.getTestData("firstname"));
		sip.lastNameStu.sendKeys(JsonUtil.getTestData("lastname"));
		sip.enrolDateStu.sendKeys(JsonUtil.getTestData("enrolldate"));
		sip.createButton.click();
		Thread.sleep(3000);
	}

	
	public void loginButtonClick() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.submit.click();
		Thread.sleep(3000);
	}
	
	public static boolean isDialogPresent(WebDriver driver) {
        try {
            driver.getTitle();
            return false;
        } catch (UnhandledAlertException e) {
            // Modal dialog showed
            return true;
        }
    }
	public void login(String un, String pwd) throws IOException, Exception {
		SignInPage signInPage = new SignInPage(driver);
		//signInPage.signIn();
		Thread.sleep(3000);
		signInPage.glewisusername.sendKeys(JsonUtil.getTestData(un));
		signInPage.glewispassword.sendKeys(JsonUtil.getTestData(pwd));
		signInPage.glewissubmit.click();
		Thread.sleep(3000);
	}
	public void login() throws IOException, Exception {
		SignInPage signInPage = new SignInPage(driver);
		//signInPage.signIn();
		Thread.sleep(3000);
		signInPage.glewisusername.sendKeys(JsonUtil.getTestData("un"));
		signInPage.glewispassword.sendKeys(JsonUtil.getTestData("pwd"));
		signInPage.glewissubmit.click();
		Thread.sleep(3000);
	}

	public static String getTestData(String input) throws IOException, ParseException {
		String testdata;
	//	return  testdata = JsonUtil.getData().get(input).toString();
		return testdata = (String) JsonUtil.getJsonData().get(input);
	}
	public void selectAll() {
		
	}
	public void logoutclick() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		if (driver.getCurrentUrl().equalsIgnoreCase("https://cafetownsend-angular-rails.herokuapp.com/employees")==true)
		{
		signInPage.logout.click();
	     Thread.sleep(3000);
		}else {
			System.out.println("Logout button not enabled");
		}
		
	}

}
