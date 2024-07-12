package pomDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut_PageFactory {
	WebDriver driver;
	public LogOut_PageFactory(WebDriver idriver) {
		driver=idriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="oxd-userdropdown-tab")WebElement profile;
	@FindBy(linkText="Logout")WebElement logOutBtn;
	
	public void profile() {
		profile.click();
	}
	public void logOut() {
		logOutBtn.click();
	}
}
