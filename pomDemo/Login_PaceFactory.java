
package pomDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_PaceFactory {
	WebDriver driver;
	public Login_PaceFactory(WebDriver idriver) {
		driver=idriver;
		PageFactory.initElements(driver, this);
	}
	
	//Repository
	@FindBy (name="username") WebElement uname;
	@FindBy (name="password") WebElement pass;
	@FindBy (tagName="button") WebElement logInBtn;
	
	public void url()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	public void enterUname(String un) {
		uname.sendKeys(un);
	}
	public void enterPass(String pwd) {
		pass.sendKeys(pwd);
	}
	public void ClickOnBtn() {
		logInBtn.click();
	}
}
