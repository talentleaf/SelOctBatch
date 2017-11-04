package testcases;


import org.testng.annotations.Test;

import wdMethods.ProjectMethods;
import wdMethods.SeMethods;

public class MergeLeads extends ProjectMethods  {

	@Test(enabled=false)
	public void mergeLead() throws InterruptedException {
		
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Merge Leads"));
		click(locateElement("xpath", "(//img[@alt='Lookup'])[1]"));
		switchToWindow(1);
		type(locateElement("name", "firstName"),"Test");
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(5000);
		String lead = getText(locateElement("xpath", "//a[@class='linktext']"));
		clickWithNoSnap(locateElement("xpath", "//a[@class='linktext']"));
		switchToWindow(0);
		click(locateElement("xpath", "(//img[@alt='Lookup'])[2]"));
		switchToWindow(1);
		type(locateElement("name", "firstName"),"Ga");
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(5000);
		clickWithNoSnap(locateElement("xpath", "//a[@class='linktext']"));
		switchToWindow(0);
		clickWithNoSnap(locateElement("link", "Merge"));
		acceptAlert();
		click(locateElement("link", "Find Leads"));
		type(locateElement("xpath", "//input[@name='id']"),lead);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(5000);
		verifyExactText(locateElement("class", "x-paging-info") , "error message is displayed as expected");

	}

}
