package week2.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//ClassName objectName = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		//Load the url
		driver.get("http://legacy.crystalcruises.com/");
		//maximize the Browser
		driver.manage().window().maximize();
		driver.findElementByLinkText("GUEST CHECK-IN").click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows.size());
		ArrayList<String> allHandles = new ArrayList<String>(); 
		allHandles.addAll(allWindows);
		String secondWindow = allHandles.get(1);
		driver.switchTo().window(secondWindow);
		System.out.println(driver.getCurrentUrl());
		/*driver.close();
		driver.switchTo().window(allHandles.get(0));
		System.out.println(driver.getTitle());
		driver.close();
		*/
		driver.quit();
		
		
		
		

	}

}
