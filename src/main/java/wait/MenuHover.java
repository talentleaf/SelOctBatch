package wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MenuHover {
	
	@Test
	public void tryExample() throws InterruptedException {
		
		// launch and load browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> sweets = driver.findElementsByXPath("//button[text()='✕']");
		if(sweets.size() > 0) {
			sweets.get(0).click();
			Thread.sleep(5000);
		}
		
		
		// locate menu and sub menu
		WebElement electronics = driver.findElementByXPath("//span[text()='Electronics']");
		WebElement apple = driver.findElementByXPath("//span[text()='Apple']");
		Actions builder = new Actions(driver);
		builder.moveToElement(electronics).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(apple));

		
		apple.click();
		
		
		
		
		
		
		
		

	}
}