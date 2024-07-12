package pomDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutByClass {
	WebDriver driver;

	public LogOutByClass(WebDriver driver) {
		this.driver = driver;
	}

	// Repository
	By logOutBtn=By.linkText("Log out");
	
	public void logOut() {
		driver.findElement(logOutBtn).click();
	}
}
