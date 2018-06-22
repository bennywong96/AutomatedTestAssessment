package com.qa.quickstart.ATAssessment;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.CreateUser;
import pages.*;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;

public class AssessmentSteps {
	
	/*
	 * Main tests involved making sure the start and end are showing the right URL
	 * Another important one is the checkbox, ensuring that it is displayed
	 * I believe that in CreateUser.java I could actually log tests as well to then bring it back
	 * over to AssessmentStep.
	 * Talking about CreateUser.java, I tried making one function that does everything
	 * which worked but would have been hard to implement into here so in the end I split them apart
	 * 
	 * Also tried using Actions which didn't work at all. So overall this all looks just a tad messy.
	 * Taken into account if username already exists (it will try using another username)
	 * only works once as 2nd username was also hardcoded, but idea was random word generator thats
	 * pass 5letters.
	 * 
	 */
	ChromeDriver driver;
	String url;
	WebElement adminUserU;
	WebElement adminUserP;
	String currentURL;
	String employeeID;
	ExtentReports newReport = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automated Test\\Reports\\ATAReport.html",
			false);
	ExtentTest test;
	
	
	@Before
	public void init() {
		chromeDriver();
	}
	
	@After
	public void after() {
		newReport.flush();
		
	}
	
	
	
  @Given("^the Add Employee Tab$")
  public void given() throws Throwable {
	  File report = new File ("C:\\Users\\Admin\\Desktop\\Automated Test\\Reports\\ATAReport.html");
	  if (report.exists()) {
		  report.delete();
	  }
	  //if the file exists delete it
	  test = newReport.startTest("Yahoo the start of something new");
	  test.log(LogStatus.INFO, "@before runs chromedriver function which sets chromedriver");
	  test.log(LogStatus.INFO, "run adminLogin()");
	  adminLogin();
	  test.log(LogStatus.INFO, "run navigateToPIM");
	  navigateToPIM();
	  currentURL = driver.getCurrentUrl();
	  String aeURL = "http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee";
	  
	  try {assertEquals(aeURL,currentURL);
	  	test.log(LogStatus.PASS, "Made it to Add an Employee Page");
		  
	  }
	  catch (AssertionError e) {
		  test.log(LogStatus.FAIL, "Something went wrong didn't make it to Add employee page");
		  fail();
	  }
  }

  @When("^I fill out the Employee Details correctly$")
  public void when() throws Throwable {
	  CreateUser demoCreate1 = PageFactory.initElements(driver, CreateUser.class);
	  employeeID = demoCreate1.whenPart1();
  }
  
  @And("^I choose to create Login Details$")
  public void and1() throws Throwable {
	  CreateUser demoCreate2 = PageFactory.initElements(driver, CreateUser.class);
	  demoCreate2.whenPart2();
	  WebElement checkLogin = driver.findElement(By.className("loginSection"));
	  String style1 = checkLogin.getAttribute("style");
	  try {
		  assertEquals("display: list-item;",style1);
		  test.log(LogStatus.PASS, "Checkbox is ticked");
	  }
	  catch (AssertionError e) {
		  test.log(LogStatus.FAIL, "Checkbox isn't ticked");
		  fail();
		  
	  }
	 
  }
  
  @And("^I fill out the Login Details correctly$")
  public void and2() throws Throwable {
	  CreateUser demoCreate3 = PageFactory.initElements(driver, CreateUser.class);
	  demoCreate3.whenPart3();
  }
  
  @And("^I click the Save button$")
  public void and3() throws Throwable {
	  CreateUser demoCreate4 = PageFactory.initElements(driver, CreateUser.class);
	  demoCreate4.whenPart4();
  }

  @Then("^I can see information about the user$")
  public void then() throws Throwable {
	
	  System.out.println(employeeID);
	  currentURL = driver.getCurrentUrl();
	  String expectedURL = "http://opensource.demo.orangehrmlive.com/index.php/pim/viewPersonalDetails/empNumber/"
			  + employeeID;
	  try {
		  assertEquals(expectedURL, currentURL);
		  test.log(LogStatus.PASS, "Viewing new employee");
	  }
	  catch (AssertionError e) {
		  test.log(LogStatus.FAIL, "Error");
		  fail();
		  
	  }
	  
	  
	  
  }


  
  
  public void chromeDriver() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		assertNotNull(driver);
  }
  
  public void adminLogin() {
	  url = "http://opensource.demo.orangehrmlive.com/index.php/dashboard";
	  driver.navigate().to(url);
	  test.log(LogStatus.INFO, "");
	  	adminUserU = driver.findElement(By.id("txtUsername"));
		adminUserU.click();
		adminUserU.clear();
		adminUserU.sendKeys("Admin");
		adminUserP = driver.findElement(By.id("txtPassword"));
		adminUserP.click();
		adminUserP.clear();
		adminUserP.sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
	  //txtUsername
	  //txtPassword
	  //btnLogin
  }
  
  public void navigateToPIM() {
	 Home newHome = PageFactory.initElements(driver, Home.class);
	 newHome.clickPIMMenu();
	 PIM demoPIM = PageFactory.initElements(driver, PIM.class);
	 demoPIM.addNewUser();
  }
  
  //check for validation on names class validation-error (maybe isDisplayed)
//  public void addNewEmployee() {
//	  CreateUser demoCreate = PageFactory.initElements(driver, CreateUser.class);
//	  demoCreate.addNewUser();
//  }
  
  //http://opensource.demo.orangehrmlive.com/index.php/pim/viewPersonalDetails/empNumber/0138
  //directed to new admin info page
  //compare THEN with this newly directed page

}
