package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentReports;

public class CreateUser {
	
	WebDriver driver;
	static ExtentReports newReport;
	
	public CreateUser(WebDriver driver){
        this.driver = driver;
	}
	
	public CreateUser(ExtentReports newReport){
        this.newReport = newReport;
	}
	
	@FindBy(id = "firstName") 
	private WebElement firstName;
	
	@FindBy(id = "middleName") 
	private WebElement middleName;
	
	@FindBy(id = "lastName") 
	private WebElement lastName;
	
	@FindBy(id = "employeeId") 
	private WebElement employeeId;
	
	@FindBy(id = "chkLogin") 
	private WebElement chkLogin;
	
	@FindBy(id = "user_name") 
	private WebElement user_name;
	
	@FindBy(id = "user_password") 
	private WebElement user_password;
	@FindBy(id = "re_password") 
	private WebElement re_password;
	
	@FindBy(id = "btnSave") 
	private WebElement btnSave;
	
	
public String whenPart1() {
	firstName.click();
	firstName.clear();
	firstName.sendKeys("Benny");
//	act1.moveToElement(lastName).click().sendKeys("Wong");
	lastName.click();
	lastName.clear();
	lastName.sendKeys("Wong");
//	if (employeeId.getAttribute("value"))
//	employeeId.clear();
//	employeeId.click();
//	employeeId.sendKeys("252");
	String employeeID = employeeId.getAttribute("value");
	return employeeID;
}

public void whenPart2() {
	chkLogin.click();
}

public void whenPart3() {
//	Actions act3 = new Actions(driver);
//	act3 = new Actions(driver);
//	act3.moveToElement(user_name).click().sendKeys("htsuna96").perform();
//	act3.moveToElement(user_password).click().sendKeys("AbcCba123321!").perform();
//	act3.moveToElement(re_password).click().sendKeys("AbcCba123321!").perform();
	user_name.click(); user_name.clear(); user_name.sendKeys("htsuna96");
	user_password.click(); user_password.clear(); user_password.sendKeys("AbcCba123321");
	re_password.click(); re_password.clear(); re_password.sendKeys("AbcCba123321");
}

public void whenPart4() {
//	Actions act4 = new Actions(driver);
//	act4 = new Actions(driver);
//	act4.moveToElement(btnSave).click();
	btnSave.click();
	//message warning fadable
	//tried doing it if warning message appears but not a good idea
	String hiddenWarning = driver.getCurrentUrl();
	String sameURL = "http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee";
	//if htsuna96 exist it moves to htsuna19
		while(hiddenWarning.equals(sameURL)) {
			firstName.click();
			firstName.clear();
			firstName.sendKeys("Benny");
			lastName.click();
			lastName.clear();
			lastName.sendKeys("Wong");
			user_name.click(); user_name.clear(); user_name.sendKeys("htsuna19");
			user_password.click(); user_password.clear(); user_password.sendKeys("AbcCba123321");
			re_password.click(); re_password.clear(); re_password.sendKeys("AbcCba123321");
			btnSave.click();
	}
}
	

public void addNewUser() {
	Actions act1 = new Actions(driver);
	act1.moveToElement(firstName).click().sendKeys("Benny").perform();
	act1.moveToElement(lastName).click().sendKeys("Wong").perform();
//	if (employeeId.getAttribute("value"))
	employeeId.clear();
	act1.moveToElement(employeeId).sendKeys("0252").perform();
	act1.moveToElement(chkLogin).click();
	act1.moveToElement(user_name).click().sendKeys("htsuna96").perform();
	act1.moveToElement(user_password).click().sendKeys("AbcCba123321!").perform();
	act1.moveToElement(re_password).click().sendKeys("AbcCba123321!").perform();
	act1.moveToElement(btnSave).click();
	sleepTest();
}

public String employeeID() {
	String employeeNumber = employeeId.getAttribute("value");
	return employeeNumber;
}

public void sleepTest() {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
