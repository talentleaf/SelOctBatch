package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//ClassName objectName = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		//Load the url
		driver.get("https://jqueryui.com/selectable/");
		//maximize the Browser
		driver.manage().window().maximize();
		
		WebElement element = driver.findElementByClassName("demo-frame");
		
		driver.switchTo().frame(element);
		driver.findElementByXPath("//li[text()='Item 3']").click();
		driver.switchTo().parentFrame();
		//driver.switchTo().defaultContent();
		driver.findElementByLinkText("Download").click();
		

	}

}
