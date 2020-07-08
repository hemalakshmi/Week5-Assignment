package week5.day1;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.testing.base.LearnAnnotations;

public class CreateLead extends LearnAnnotations {
	@BeforeTest
	public void setData() {
		excelFileName="TC001";
	}
@Test(dataProvider="sendData")
	public void runTC001(String cName,String fName,String lName) {
		
	    System.out.println("@Test started-Createlead");
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(cName);
		driver.findElementById("createLeadForm_firstName").sendKeys(fName);
		driver.findElementById("createLeadForm_lastName").sendKeys(lName);
		driver.findElementByName("submitButton").click();
		System.out.println("@Test Ended-Createlead");
}
}






