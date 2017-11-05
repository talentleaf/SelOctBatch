package testNG;

import org.testng.annotations.Test;

import wdMethods.ProjectMethods;
import week4.day2.LearnDataProvider;

public class RunMethodsParallel extends ProjectMethods {
	
	@Test(dataProvider = "fetchData", dataProviderClass = LearnDataProvider.class)
	public void createLead(String fName, String lName, String cName) {	
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Create Lead"));
		type(locateElement("id", "createLeadForm_companyName"), cName);
		type(locateElement("id", "createLeadForm_firstName"), fName);
		type(locateElement("id", "createLeadForm_lastName"), lName);
		selectDropDownUsingText(locateElement("id", "createLeadForm_dataSourceId"), "Employee");
		selectDropDownUsingIndex(locateElement("id", "createLeadForm_marketingCampaignId"), 1);
		click(locateElement("name", "submitButton"));
	}
	
	@Test(groups= {"regression"})
    public void editLead() throws InterruptedException {
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Find Leads"));
		click(locateElement("xpath", "//span[text()='Phone']"));
		type(locateElement("name", "phoneNumber"),"9954");
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(5000);
		String lead = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("link", "Edit"));
		type(locateElement("id", "updateLeadForm_companyName"),"IBM");
		click(locateElement("class", "smallSubmit"));
	}

	
	
	
	
	
	
}
