package week5.day1;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.testing.base.LearnAnnotations;

public class DuplicateLead extends LearnAnnotations{
	@BeforeTest
	public void setData() {
		excelFileName="TC002";
	}
	@Test(dataProvider="sendData")
	public void runTC003(String phoneNumb) throws InterruptedException {
		System.out.println("@Test started-Duplicatelead");
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phoneNumb);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Duplicate Lead").click();
		driver.findElementByName("submitButton").click();
		System.out.println("@Test Ended-Duplicatelead");
	}
}






