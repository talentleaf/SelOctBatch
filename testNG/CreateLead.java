package testNG;

import org.testng.annotations.Test;

import wdMethods.ProjectMethods;
import week4.day2.LearnDataProvider;

public class CreateLead extends ProjectMethods  {
	//@Test(groups= {"smoke"})
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

}
