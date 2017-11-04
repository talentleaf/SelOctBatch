package testcases;

import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class DeleteLead extends ProjectMethods {
	
	@Test
	public void deleteLead() throws InterruptedException {
	
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Find Leads"));
		click(locateElement("xpath", "//span[text()='Email']"));
		type(locateElement("name", "emailAddress"),"@");
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(5000);
		String lead = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("link", "Delete"));
		
		
		click(locateElement("link", "Find Leads"));
		type(locateElement("name", "id"),lead);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(5000);

		verifyExactText(locateElement("class", "x-paging-info") , "error message is displayed as expected");

		
	}
}














