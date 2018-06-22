package com.qa.quickstart.ATAssessment;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import pages.CreateUser;
import pages.Home;
import pages.PIM;

public class AppTest1 {

//
//	ChromeDriver driver;
//	String url = "http://opensource.demo.orangehrmlive.com/index.php/auth/login";
//	WebElement adminUserU;
//	WebElement adminUserP;
//	Home newHome;
//	
//	
//	@BeforeClass
//	public static void init() {
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
//	}
//	@Before
//	public void before() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.navigate().to(url);
//	}
//	
//	  
// @Test
// public void test() {
//	 sleepTest();
//	 adminLogin1();
//	 sleepTest();
//	 navigateToPIM();
//	 sleepTest();
//	 addNewEmployee();
//	 sleepTest();
// }
// 
// public void chromeDriver() {
//		
//		assertNotNull(driver);
// }
// 
// public void adminLogin1() {
//	  	adminUserU = driver.findElement(By.id("txtUsername"));
//		adminUserU.click();
//		adminUserU.clear();
//		adminUserU.sendKeys("Admin");
//		adminUserP = driver.findElement(By.id("txtPassword"));
//		adminUserP.click();
//		adminUserP.clear();
//		adminUserP.sendKeys("admin");
//		driver.findElement(By.id("btnLogin")).click();
//	  //txtUsername
//	  //txtPassword
//	  //btnLogin
// }
// 
// public void navigateToPIM() {
//	 newHome = PageFactory.initElements(driver, Home.class);
//	 newHome.clickPIMMenu();
//	 PIM demoPIM = PageFactory.initElements(driver, PIM.class);
//	 demoPIM.addNewUser();
// }
// 
// //check for validation on names class validation-error (maybe isDisplayed)
// public void addNewEmployee() {
//	  CreateUser demoCreate = PageFactory.initElements(driver, CreateUser.class);
//	  demoCreate.addNewUser();
// }
// 
// public void sleepTest() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
// }
}
