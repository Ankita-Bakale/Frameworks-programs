package dataDrivenModelFramework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import pomDemo.LogOut_PageFactory;
import pomDemo.Login_PaceFactory;

public class DataDriven_POM 
{

	public static void main(String[] args) throws IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Login_PaceFactory lin = new Login_PaceFactory(driver);
		LogOut_PageFactory lout = new LogOut_PageFactory(driver);
		lin.url();

		String filePath = "E:\\Testing\\Selenium\\data.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("data");

		int rows = sheet.getLastRowNum();

		for (int i = 1; i <= rows; i++) 
		{
			XSSFRow row = sheet.getRow(i);
			XSSFCell uname = row.getCell(0);
			XSSFCell pass = row.getCell(1);
			XSSFCell res= row.createCell(2); 
			
			System.out.println("Username::" + uname + " Password::" + pass);
			try {
				lin.enterUname(uname.toString());
				lin.enterPass(pass.toString());
				lin.ClickOnBtn();
				lout.profile();
				lout.logOut();
				
				System.out.println("Valid Data");
				res.setCellValue("Valid Data");
			} 
			catch (Exception e) {
				String errorMsg = driver.findElement(By.xpath("//div[@id='app']/descendant::p[1]")).getText();				
				System.out.println("Invalid Data");
				res.setCellValue(errorMsg);
			}
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
	}
	
}