package aui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
		ChromeDriver driver = new ChromeDriver();	
		driver.get("https://jqueryui.com/selectable/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement demo = driver.findElementByClassName("demo-frame");
		
		driver.switchTo().frame(demo);
		
		Actions builder = new Actions(driver);
		
		WebElement it1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement it2 = driver.findElementByXPath("//li[text()='Item 4']");
	
		builder.clickAndHold(it1)/*.release(it2)*/.build().perform();

	}

}
