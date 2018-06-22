package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

	public class Home {
		WebDriver driver;
		public Home(WebDriver driver){
	        this.driver = driver;
		}
		
		@FindBy(id = "menu_pim_viewPimModule") 
		private WebElement menuPIM;
		
		public void clickPIMMenu() {
			sleepTest();
			menuPIM.click();	
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
