package wdMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectMethods extends SeMethods{
	
	@BeforeMethod
	public void login() {
		
		startApp("chrome", "http://leaftaps.com/opentaps");
		type(locateElement("id", "username"), "DemoSalesManager");
		type(locateElement("id", "password"), "crmsfa");
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("link", "CRM/SFA"));
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApp() {
		closeBrowser();
	}

}
