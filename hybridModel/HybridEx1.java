package hybridModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import pomDemo.LogOut_PageFactory;
import pomDemo.Login_PaceFactory;

public class HybridEx1 {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Login_PaceFactory lin = new Login_PaceFactory(driver);
		LogOut_PageFactory lout = new LogOut_PageFactory(driver);
		
		String filePath = "E:\\Testing\\Selenium\\data.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet datasheet = workbook.getSheet("data");
		XSSFSheet keysheet = workbook.getSheet("Keyword");

		int drows = datasheet.getLastRowNum();

		int krows = keysheet.getLastRowNum();

		for (int dr = 1; dr <= drows; dr++) 
		{
			XSSFRow drow = datasheet.getRow(dr);
			XSSFCell uname = drow.getCell(0);
			XSSFCell pass = drow.getCell(1);
			XSSFCell dres= drow.createCell(2); 
			
			System.out.println("Username::" + uname + " Password::" + pass);
			try {
			
			for (int kr = 1;kr <= krows; kr++) 
			{
				XSSFRow krow = keysheet.getRow(kr);
				XSSFCell key = krow.getCell(1);
				XSSFCell kres = krow.createCell(2);

				System.out.println("KeyWord::" + key);

				switch (key.toString()) {
				case "url":
					lin.url();
					System.out.println("url matched");
					kres.setCellValue("url matched");
					break;
				case "enterUname":
					lin.enterUname(uname.toString());
					System.out.println("enterUname matched");
					kres.setCellValue("enterUname matched");
					break;
				case "enterPass":
					lin.enterPass(pass.toString());
					System.out.println("enterPass matched");
					kres.setCellValue("enterPass matched");
					break;
				case "ClickOnBtn":
					lin.ClickOnBtn();
					System.out.println("ClickOnBtn matched");
					kres.setCellValue("ClickOnBtn matched");
					break;
				case "profile":
					lout.profile();
					System.out.println("profile matched");
					kres.setCellValue("profile matched");
					break;
				case "logOut":
					lout.logOut();
					System.out.println("logOut matched");
					kres.setCellValue("logOut matched");
					break;
				}
			}
			System.out.println("Valid Credentials");
			dres.setCellValue("Valid Credentials");
			}
			catch(Exception e) {
				System.out.println("Invalid Credentials");
				dres.setCellValue("Invalid Credentials");
			}
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
	}

}
