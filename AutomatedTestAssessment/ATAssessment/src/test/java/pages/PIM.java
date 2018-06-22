package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PIM {
	
	WebDriver driver;
	public PIM(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(id = "menu_pim_addEmployee") 
	private WebElement addEmployee;

public void addNewUser() {
	addEmployee.click();
	sleepTest();
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
