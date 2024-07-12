package pomDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginByClass {
	WebDriver driver;
	public LoginByClass(WebDriver driver) {
		this.driver=driver;
	}
	
	//Repository
	By uname=By.name("username");
	By pass=By.name("password");
	By submitBtn=By.id("submit");
	
	public void url()
	{
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	public void enterUname(String un) {
		driver.findElement(uname).sendKeys(un);
	}
	public void enterPass(String pwd) {
		driver.findElement(pass).sendKeys(pwd);
	}
	public void ClickOnBtn() {
		driver.findElement(submitBtn).click();
	}
}
