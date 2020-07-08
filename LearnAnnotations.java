package com.leaftaps.testing.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week5.day2.ReadExcel;

public class LearnAnnotations {
public ChromeDriver driver;
public String excelFileName;

@Parameters({"url","username","password"})
@BeforeMethod
public void openApp(String url,String username,String password) {
	System.out.println("@BeforeMethod started");
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElementById("username").sendKeys(username);
	driver.findElementById("password").sendKeys(password);
	driver.findElementByClassName("decorativeSubmit").click();
	driver.findElementByLinkText("CRM/SFA").click();
	driver.findElementByLinkText("Leads").click();
	System.out.println("@BeforeMethod Ended");
}
@AfterMethod
public void closeApp() {
	System.out.println("@AfterMethod started");
	driver.close();
	System.out.println("@AfterMethod Ended");
}
@DataProvider 
public String[][] sendData() throws IOException{
	String[][] array= ReadExcel.readExcelData(excelFileName);
		/*
		 * //create a 2-D Array String[][] array=new String[2][3];
		 * array[0][0]="Testleaf"; array[0][1]="Balaji"; array[0][2]="C";
		 * 
		 * array[1][0]="Testleaf"; array[1][1]="Dhivya"; array[1][2]="Prabha";
		 */
	return array;
}
	}

