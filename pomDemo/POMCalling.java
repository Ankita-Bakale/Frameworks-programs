package pomDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class POMCalling {
	@Test
	public void callingMethod() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Login_PaceFactory lgn= new Login_PaceFactory(driver);
		LogOut_PageFactory lgout=new LogOut_PageFactory(driver);
		
		lgn.url();
		lgn.enterUname("Admin");
		Thread.sleep(1500);
		lgn.enterPass("Admin123");
		Thread.sleep(1500);
		lgn.ClickOnBtn();
		Thread.sleep(1500);
		
		lgout.logOut();
		Thread.sleep(1500);
		
		driver.close();
		
	}

}
