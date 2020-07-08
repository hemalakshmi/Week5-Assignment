package week5.day1;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.testing.base.LearnAnnotations;

public class EditLead extends LearnAnnotations{
	@BeforeTest
	public void setData() {
		excelFileName="TC004";
	}
	@Test(dataProvider="sendData")
	public void runTC004(String phoneNumb,String updateName) throws InterruptedException {
		System.out.println("@Test started-Editlead");
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phoneNumb);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").sendKeys(updateName);
		driver.findElementByName("submitButton").click();
		System.out.println("@Test Ended-Editlead");
}
}






