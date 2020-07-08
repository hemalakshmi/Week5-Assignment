package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.testing.base.LearnAnnotations;

public class MergeLead extends LearnAnnotations {
	@BeforeTest
	public void setData() {
		excelFileName="TC005";
	}
@Test(dataProvider="sendData")
	public void runTC005(String fName1,String fName2) throws InterruptedException {
	    System.out.println("@Test started-Mergelead");
		driver.findElementByLinkText("Merge Leads").click();
		driver.findElementByXPath("//img[@alt='Lookup']").click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElementByXPath("//input[@name='firstName']").sendKeys(fName1);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(1000);
		String leadID = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").getText();
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.switchTo().window(allhandles.get(0));
		
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
		driver.findElementByXPath("//input[@name='firstName']").sendKeys(fName2);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
		driver.switchTo().window(allhandles2.get(0));
		driver.findElementByXPath("//a[text()='Merge']").click();
		driver.switchTo().alert().accept();
		
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		String text = driver.findElementByClassName("x-paging-info").getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		System.out.println("@Test started-Mergelead");
		
		
	}
}






