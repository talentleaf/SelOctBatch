package testNG;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class LearnAttributes {

	//@Test(priority=-1)
	@Test
	public void createLead() {
		System.out.println("CreateLead");
		throw new RuntimeException();
	}
	//@Test(successPercentage=80)
	@Test(expectedExceptions=NoSuchElementException.class)
	public void editLead() {
		System.out.println("EditLead");
	}
	@Test(enabled=false)
	public void mergeLead() {
		System.out.println("MergeLead");
	}
	//@Test(priority=3)
	@Test(dependsOnMethods= {"testcases.LearnAttributes.createLead"},alwaysRun=true)
	public void deleteLead() {
		System.out.println("DeleteLead");
	}


}
