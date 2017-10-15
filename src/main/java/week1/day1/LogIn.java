package week1.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//ClassName objectName = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
	
		//Load URL 
		driver.get("http://leaftaps.com/opentaps");
	
	
		//Locate user name webElement and pass user Name
		driver.findElementById("username").sendKeys("DemoSalesManager");
			
		//Locate password webElement and pass password
		driver.findElementById("password").sendKeys("crmsfa");
		
		//click on logIn button
		driver.findElementByClassName("decorativeSubmit").click();
	
		//click on logOut button
		driver.findElementByClassName("decorativeSubmit").click();
		





















	}

}
