package keywordDrivenFramework;

import java.io.FileInputStream;
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

public class KeywordDrivenEx1 {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Login_PaceFactory lin = new Login_PaceFactory(driver);
		LogOut_PageFactory lout = new LogOut_PageFactory(driver);

		String filePath = "E:\\Testing\\Selenium\\data.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Keyword");

		int rows = sheet.getLastRowNum();

		for (int i = 1; i <= rows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell key = row.getCell(1);
			XSSFCell res = row.createCell(2);

			System.out.println("KeyWord::" + key);

			switch (key.toString()) {
			case "url":
				lin.url();
				System.out.println("url matched");
				res.setCellValue("url matched");
				break;
			case "enterUname":
				lin.enterUname("Admin");
				System.out.println("enterUname matched");
				res.setCellValue("enterUname matched");
				break;
			case "enterPass":
				lin.enterPass("admin123");
				System.out.println("enterPass matched");
				res.setCellValue("enterPass matched");
				break;
			case "ClickOnBtn":
				lin.ClickOnBtn();
				System.out.println("ClickOnBtn matched");
				res.setCellValue("ClickOnBtn matched");
				break;
			case "profile":
				lout.profile();
				System.out.println("profile matched");
				res.setCellValue("profile matched");
				break;
			case "logOut":
				lout.logOut();
				System.out.println("logOut matched");
				res.setCellValue("logOut matched");
				break;
			}
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);

	}

}
