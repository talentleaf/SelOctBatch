package week4.day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class LearnDataProvider {
	
	@DataProvider(name = "fetchData")
	public static Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "Babu";
		data[0][1] = "M";
		data[0][2] = "TestLeaf";
		data[1][0] = "Nesa";
		data[1][1] = "kumar";
		data[1][2] = "TestLeaf";
		return data;	
	}
	
	
	

}
