//package com.task.automation.test;
//
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.io.IOException;
//import java.text.NumberFormat;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.xml.parsers.ParserConfigurationException;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.xml.sax.SAXException;
//
//import SFCV2.Agency.SchemesScreen;
//import utils.Common_Functions;
//import utils.Constants;
//
//public class appav {
//
//	
//	private Common_Functions commfunct_Obj = new Common_Functions();
//	// private Application_Common_Functions Appcommfunct_Obj = new
//	// Application_Common_Functions();
//
//	public ArrayList<String> MsgList = new ArrayList<String>();
//	private static final Logger lowlevellogsobj = Logger.getLogger(SchemesScreen.class);
//
//	public appav(WebDriver driver) {
//	}
//	
//	
//	@FindBy(xpath = "(//*[starts-with(@role,'button')])[1]")
//	private WebElement btnarrow;
//	
//	//div[contains(text(),'Account Details')]//following::div[2]/span[3]
//	
//
//	@FindBy(xpath = "//div[contains(text(),'Account Details')]//following::div[2]/span[3]")
//	private WebElement txtvalue;
//	
//
//	@FindBy(xpath = "/button[contains(text(),' Submit a Claim ')]")
//	private WebElement btnSubmitClaim;
//	
//	@FindBy(xpath = "(//input[@role='combobox'])[1]")
//	private WebElement drpdwnSortBy;
//	//div[contains(text(),'Sort By')]
//			
//	@FindBy(xpath = "(//input[@role='combobox'])[2]")
//	private WebElement drpdwnFilterByYr;
//	
//	@FindBy(xpath = "(//input[@role='combobox'])[3]")
//	private WebElement drpdwnFilterBy;
//	
//	@FindBy(xpath = "(//div[@role='option']//input//following::span)[1]")
//	private WebElement drpdwnPending;
//	
//	@FindBy(xpath = "//*[contains(text(),'Credit Transaction History')]")
//	private WebElement tabcredithistory;
//	
//	@FindBy(xpath = "//*[contains(text(),'Claim Applications')]")
//	private WebElement tabclaimapplication;
//	
//	/*@FindBy(xpath = "(//span[contains(text(),'Available Credits')]//following::span[@class='AvalCreditAmt float-right'])[1]")
//	private WebElement txtAvailableCredits;
//	
//	@FindBy(xpath = "(//div[contains(text(),'Available Credits')]//following::span)[1]")
//	private WebElement txtAvailableCredits;*/
//	
//	
//	
//	@FindBy(xpath = "(//span[@id='creDetamount'])[1]")
//	private WebElement txtSkillsFutureCredit;
//	
//
//	public String xpbtnarrow = "(//*[starts-with(@role,'button')])[1]";
//	public String xpSubmitClaim = "/button[contains(text(),' Submit a Claim ')]";
//	public String xpdrpdwnSortBy = "(//input[@role='combobox'])[1]";
//	public String xpdrpdwnFilterByYr = "(//input[@role='combobox'])[2]";
//	public String xpdrpdwnFilterBy = "(//input[@role='combobox'])[3]";
//	public String xpdrpdwnPending = "(//div[@role='option']//input//following::span)[1]";
//	public String xpclaimapplication = "//*[contains(text(),'Claim Applications')]";
//	
//
//
//	public boolean individualdashboard(WebDriver driver, List<String> testArray_Data, HashMap<String, Integer> headerMap_Data)
//			throws InterruptedException, IOException, SAXException, ParserConfigurationException {
//		
//		WebDriverWait wait = new WebDriverWait(driver, 100);
//		boolean result = true;
//		boolean result1=false;
//
///*		String sSortBy = commfunct_Obj.getParameter(testArray_Data, headerMap_Data, Constants.C_Individual_SortBy);
//		String sFilterbyYear = commfunct_Obj.getParameter(testArray_Data, headerMap_Data, Constants.C_Individual_FilterbyYear);*/
//		
//		String sSkillsFutureCredit = commfunct_Obj.getParameter(testArray_Data, headerMap_Data, Constants.C_Individual_SkillsFutureCredit);
//		String sSkillsFutureCreditTopup = commfunct_Obj.getParameter(testArray_Data, headerMap_Data, Constants.C_Individual_SkillsFutureCreditTopUp);
//		String sAvailableCredits = commfunct_Obj.getParameter(testArray_Data, headerMap_Data, Constants.C_Individual_Available);
//		
//		
//		
//
//		try {
//
//			lowlevellogsobj.info("User Successfully landed on Individual Dashboard :");
//			
//			Thread.sleep(3000);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpbtnarrow)));
//			commfunct_Obj.commonClick(btnarrow, "Yes");
//			
//			String regExp = "[$,]";
//			
//			String SkillsFutureCredit= driver.findElement(By.xpath("(//span[@id='creDetamount'])[1]")).getText().replaceAll(regExp, "").trim();
//			System.out.println("SkillsFutureCredit value is : '"+SkillsFutureCredit+"' ");
//			
//			String SkillsFutureCreditTopUp= driver.findElement(By.xpath("(//span[@id='creDetamount'])[2]")).getText().replaceAll(regExp, "").trim();
//			System.out.println("SkillsFutureCreditTopUpvalue is : '"+SkillsFutureCreditTopUp+"' ");
//			
//			String CareerTransitionPrograme= driver.findElement(By.xpath("(//div[contains(text(),'Career Transition Programe Credit')]//following::span)[1]")).getText().replaceAll(regExp, "").trim();
//			System.out.println("CareerTransitionPrograme is : '"+CareerTransitionPrograme+"' ");
//			
//			String OpenClaims= driver.findElement(By.xpath("(//div[contains(text(),'Open Claims')]//following::span)[1]")).getText().replaceAll(regExp, "").trim();
//			System.out.println("OpenClaims is : '"+OpenClaims+"' ");
//			
//			String AvailableCredits= driver.findElement(By.xpath("(//div[contains(text(),'Available Credits')]//following::span)[1]")).getText().replaceAll(regExp, "").trim();
//			System.out.println("AvailableCredits value is : '"+AvailableCredits+"' ");
//			
//			
//			int sumVal = Math.round(Float.parseFloat(SkillsFutureCredit))+Math.round(Float.parseFloat(SkillsFutureCreditTopUp));
//			System.out.println("Total of SF01 and SFC02 is :'"+sumVal+"' ");
//			
//			
//			Thread.sleep(3000);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpdrpdwnFilterBy)));
//			commfunct_Obj.commonClick(drpdwnFilterBy, "Yes");
//			
//			Thread.sleep(3000);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpdrpdwnPending)));
//			commfunct_Obj.commonClick(drpdwnPending, "Yes");
//			
//			
//			//String status = driver.findElement(By.xpath("//span[contains(text(),'Pending')]")).getText();
//			 
//		
//			List<WebElement> elems= driver.findElements(By.xpath("//span[contains(text(),'Pending')]//following::div/span/span"));
//
//			Iterator<WebElement> itr = elems.iterator();
//			
//			while(itr.hasNext()) {
//			    System.out.println(itr.next().getText().replaceAll(regExp, "").trim());
//			}
//			
//			
//			int availableCredits = Math.round(Float.parseFloat(AvailableCredits.replaceAll(regExp, "").trim()));
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			if(SkillsFutureCredit.contains(sSkillsFutureCredit)) {
//				lowlevellogsobj.info("SF01 value is '"+SkillsFutureCredit+"' ");
//				System.out.println("value is : '"+SkillsFutureCredit+"' ");
//			}
//			
//
//		
//			
//			if(SkillsFutureCreditTopUp.contains(sSkillsFutureCreditTopup)) {
//				
//				lowlevellogsobj.info("SF02 value is '"+SkillsFutureCredit+"' ");
//				System.out.println("value is : '"+SkillsFutureCredit+"' ");
//			}
//			
//			if(sumVal == availableCredits) {
//				
//				lowlevellogsobj.info("Available credits is sum of SFC01 and SFC02 :'"+availableCredits+"'is matched ");
//				System.out.println("passed ");
//				
//				Thread.sleep(3000);
//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpclaimapplication)));
//				commfunct_Obj.commonClick(tabclaimapplication, "Yes");
//				lowlevellogsobj.info("User Clicked on Claim application Tab:");
//				
//			}
//			
//			
//			
//			
//			
//			/*String AvailableCredits= driver.findElement(By.xpath("(//div[contains(text(),'Available Credits')]//following::span)[1]")).getText();
//			System.out.println("value is : '"+AvailableCredits+"' ");
//			  
//			
//			String SkillsFutureCredit= driver.findElement(By.xpath("(//span[@id='creDetamount'])[1]")).getText();
//			System.out.println("value is : '"+SkillsFutureCredit+"' ");
//			
//			
//			String SkillsFutureCreditTopUp= driver.findElement(By.xpath("(//span[@id='creDetamount'])[2]")).getText();
//			System.out.println("value is : '"+SkillsFutureCreditTopUp+"' ");
//			
//			String regExp = "[$,]";
//			
//			
//			
//			int sumVal = Math.round(Float.parseFloat(SkillsFutureCredit.replaceAll(regExp, "").trim()))+Math.round(Float.parseFloat(SkillsFutureCreditTopUp.replaceAll(regExp, "").trim()));
//			System.out.println(sumVal);
//			
//			int availableCredits = Math.round(Float.parseFloat(AvailableCredits.replaceAll(regExp, "").trim()));
//			
//			if(availableCredits == sumVal) {
//				
//				lowlevellogsobj.info("passed ");
//				System.out.println("passed ");
//				
//			}
//
//			
//			if(SkillsFutureCredit.contains(sSkillsFutureCredit)) {
//				lowlevellogsobj.info("user '"+SkillsFutureCredit+"' ");
//				System.out.println("value is : '"+SkillsFutureCredit+"' ");
//			}
//			
//			
//		
//			
//			if(SkillsFutureCreditTopUp.equalsIgnoreCase(sSkillsFutureCreditTopup)) {
//				
//				System.out.println("value is : '"+SkillsFutureCredit+"' ");
//			}
//			*/
//			
//			
//			/*Thread.sleep(3000);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpbtnarrow)));
//			commfunct_Obj.commonClick(btnarrow, "Yes");
//			
//			
//			String amtvalue = driver.findElement(By.xpath("//div[contains(text(),'Account Details')]//following::div[2]/span[3]")).getText();
//			
//			System.out.println("value is : '"+amtvalue+"' ");
//			
//			if(amtvalue.contains("$1000")) {
//				
//				Thread.sleep(3000);
//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpdrpdwnSortBy)));
//				commfunct_Obj.commonClick(drpdwnSortBy, "Yes");
//				
//				Thread.sleep(3000);
//				WebElement  drpdwnsortby = driver.findElement(By.xpath("//span[contains(text(),'"+sSortBy+"')]"));
//				commfunct_Obj.commonClick(drpdwnsortby, "Yes");
//				lowlevellogsobj.info("User Filter the status to "+sSortBy+" value in Sort BY:");
//				
//				Thread.sleep(3000);
//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpdrpdwnFilterByYr)));
//				commfunct_Obj.commonClick(drpdwnFilterByYr, "Yes");
//				
//				Thread.sleep(3000);
//				WebElement  drpdwnfilterbyyr = driver.findElement(By.xpath("//div[contains(text(),'"+sFilterbyYear+"')]"));
//				commfunct_Obj.commonClick(drpdwnfilterbyyr, "Yes");
//				lowlevellogsobj.info("User Filter the status to "+sFilterbyYear+" value in Sort BY:");
//				
//				Thread.sleep(3000);
//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpdrpdwnFilterBy)));
//				commfunct_Obj.commonClick(drpdwnFilterBy, "Yes");
//				
//				
//				
//			}
//			
//*/
//			
//			
//			
//			
//		
//			
//			
//			Thread.sleep(5000);
//
//
//
//		} catch (Exception e) {
//			lowlevellogsobj.error("Exception in  Individual Dashboard Page:  " + e.getMessage(), e);
//			result = false;
//		} 
//		
//
//		return result;
//
//	}
//
//}
