package util;

import java.io.Externalizable;
import java.io.File;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LearnExtentReport {

	@Test
	public void report() {
	//BeforeSuite
	ExtentReports extent = new ExtentReports("./reports/result.html", false);
	extent.loadConfig(new File("./src/main/resources/extent_config.xml"));
	//BeforeMethod
	ExtentTest test = extent.startTest("createLead", "Create a new Lead");
	test.assignCategory("smoke");
	test.assignAuthor("babu");
	//SysOut
	test.log(LogStatus.PASS, "Lead is created successfully"+test.addScreenCapture("../reports/snap1.jpg"));
	test.log(LogStatus.FAIL, "Lead is not created successfully");
	test.log(LogStatus.WARNING, "Lead is created successfully");
	test.log(LogStatus.INFO, "Lead is created successfully");
	//AfterMethod
	extent.endTest(test);
	//AfterSuite
	extent.flush();
	}

}
