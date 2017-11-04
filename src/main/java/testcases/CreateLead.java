package testcases;

import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class CreateLead extends ProjectMethods  {

	@Test(invocationCount=2)
	public void createLead() {
	
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Create Lead"));
		type(locateElement("id", "createLeadForm_companyName"), "Testleaf");
		type(locateElement("id", "createLeadForm_firstName"), "Gayatri");
		type(locateElement("id", "createLeadForm_lastName"), "Krishna");
		selectDropDownUsingText(locateElement("id", "createLeadForm_dataSourceId"), "Employee");
		selectDropDownUsingIndex(locateElement("id", "createLeadForm_marketingCampaignId"), 1);
		click(locateElement("name", "submitButton"));


	}

}
