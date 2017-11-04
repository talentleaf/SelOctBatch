package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeMethods implements WdMethods{

	RemoteWebDriver driver;
	int i = 1;
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/internetexplorerserver.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().window().maximize();	
			takeSnap();
			System.out.println("The browser:"+browser+" launched successfully");
		} catch (Exception e) {
			System.err.println("The browser:"+browser+" could not be launched");
			throw new RuntimeException();
		}
	}

	public void startApp(String url) {
		startApp("chrome",url);
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case("id"): return driver.findElementById(locValue);
			case("link"): return driver.findElementByLinkText(locValue);
			case("xpath"):return driver.findElementByXPath(locValue);
			case("name"): return driver.findElementByName(locValue);
			case("class"): return driver.findElementByClassName(locValue);
			case("tag"):return driver.findElementByTagName(locValue);
			}
		} catch (NoSuchElementException e) {
			System.out.println("The element with locator "+locator+" and with value "+locValue+" not found.");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			System.err.println("The browser got closed");
			throw new RuntimeException();
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		return locateElement("id", locValue);
	}

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The text field entered with text "+data);
		} catch (InvalidElementStateException e) {
			System.err.println("The element: "+ele+" is not interactable");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void click(WebElement ele) {
		String text = "";
		try {
			text = ele.getText();
			ele.click();
			System.out.println("The element:"+text+" is clicked");
		} catch (InvalidElementStateException e) {
			System.err.println("The element: "+text+" is not interactable");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}

	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			text = ele.getText();
			ele.click();
			System.out.println("The element:"+text+" is clicked");
		} catch (InvalidElementStateException e) {
			System.err.println("The element: "+text+" is not interactable");
			throw new RuntimeException();
		} 

	}

	public String getText(WebElement ele) {		
		return ele.getText();
	}

	public String getTitle() {		
		return driver.getTitle();
	}

	public String getAttribute(WebElement ele, String attribute) {		
		return ele.getAttribute(attribute);
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			System.out.println("The dropdown is selected with text "+value);
		} catch (WebDriverException e) {
			System.err.println("The dropdown could not be selected with text "+value);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			System.out.println("The dropdown is selected with index "+index);
		} catch (WebDriverException e) {
			System.err.println("The dropdown could not be selected with index "+index);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}

	}

	public void verifyTitle(String expectedTitle) {
		if(getTitle().equals(expectedTitle)) {
			System.out.println("The expected title matches the actual "+expectedTitle);
		}else {
			System.err.println("The expected title doesn't matches the actual "+expectedTitle);
		}

	}

	public void verifyExactText(WebElement ele, String expectedText) {
		if(getText(ele).equals(expectedText)) {
			System.out.println("The expected text matches the actual "+expectedText);
		}else {
			System.err.println("The expected text doesn't matches the actual "+expectedText);
		}

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		if(getText(ele).contains(expectedText)) {
			System.out.println("The expected text contains the actual "+expectedText);
		}else {
			System.err.println("The expected text doesn't contain the actual "+expectedText);
		}
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		if(getAttribute(ele, attribute).equals(value)) {
			System.out.println("The expected attribute :"+attribute+" value matches the actual "+value);
		}else {
			System.err.println("The expected attribute :"+attribute+" value does not matches the actual "+value);
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		if(getAttribute(ele, attribute).contains(value)) {
			System.out.println("The expected attribute :"+attribute+" value contains the actual "+value);
		}else {
			System.err.println("The expected attribute :"+attribute+" value does not contains the actual "+value);
		}

	}

	public void verifySelected(WebElement ele) {
		if(ele.isSelected()) {
			System.out.println("The element "+ele+" is selected");
		} else {
			System.err.println("The element "+ele+" is not selected");
		}

	}

	public void verifyDisplayed(WebElement ele) {
		if(ele.isDisplayed()) {
			System.out.println("The element "+ele+" is visible");
		} else {
			System.err.println("The element "+ele+" is not visible");
		}

	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			System.err.println("The driver could not move to the given window by index "+index);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public void acceptAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			System.out.println("The alert "+text+" is accepted.");
		} catch (NoAlertPresentException e) {
			System.err.println("There is no alert present.");
		} finally {
			takeSnap();
		}
	}

	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			System.out.println("The alert "+text+" is dismissed.");
		} catch (NoAlertPresentException e) {
			System.err.println("There is no alert present.");
		} finally {
			takeSnap();
		}

	}

	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			System.err.println("There is no alert present.");
		}
		return text;
	}

	public void takeSnap() {
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./snaps/snap"+i+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;

	}

	public void closeBrowser() {
		try {
			driver.close();
			System.out.println("The browser is closed");
		} catch (Exception e) {
			System.err.println("The browser could not be closed");
		}

	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("The opened browsers are closed");
		} catch (Exception e) {
			System.err.println("The browsers could not be closed");
		}

	}

}
