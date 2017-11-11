package testNG;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.ReadExcel;
import wdMethods.ProjectMethods;



public class CreateLeadWithDataProvider extends ProjectMethods  {
	//@Test(groups= {"smoke"})
	@Test(dataProvider = "fetchData")
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
	@DataProvider(name = "fetchData")
	public Object[][] getData() throws IOException {
		ReadExcel rExcel = new ReadExcel();
		return rExcel.readExcel("CreateLead");
		
	}
	
	
	

}
