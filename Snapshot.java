package week5.day2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Snapshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/hemas/MavenProject/test-output/index.html#");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElementByXPath("//a[text()=' (show)']").click();
	    File snap= driver.getScreenshotAs(OutputType.FILE);
	    File img=new File("./snaps/Entirepage.jpg");
	    FileUtils.copyFile(snap, img);
	    driver.close();
	}

}
