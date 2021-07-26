package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;  //Variable and method declared as static so that i can call directly in other classes without creating object
	public static ExtentReports getReportObject() {
		
		//ExtentSparkReporter, ExtentReports, ExtentTest - key extent reports objects
		
				String Report_path = System.getProperty("user.dir") + "//Reports//index.html";
				
				ExtentSparkReporter reporter = new ExtentSparkReporter(Report_path);
				reporter.config().setReportName("Sreeni Web Reports");
				reporter.config().setDocumentTitle("Awesome Reports");
				
				extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Sreeni Kava");
				
				return extent;
				
	}

}
