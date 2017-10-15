package week1.Day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();	 
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");

		WebElement sQ = driver.findElementById("userRegistrationForm:securityQ");		
		Select dd = new Select(sQ);
		
		//	dd.selectByVisibleText("What is your all time favorite sports team?");
		
		//	dd.selectByValue("6");
		
		//dd.selectByIndex(10);
		
		List<WebElement> allOptions = dd.getOptions();
	
		/*int count = allOptions.size();
		System.out.println(count);		
		dd.selectByIndex(count-1);*/
		
		//Syntax - For Each
		/* for(dataType variable : Collections)*/
		
		for (WebElement eachOption : allOptions) {
			System.out.println(eachOption.getText());
		}
	}
}


































