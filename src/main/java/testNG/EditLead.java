package testNG;



import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class EditLead extends ProjectMethods  {	
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
