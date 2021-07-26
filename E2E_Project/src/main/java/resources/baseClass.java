package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class baseClass {  //BaseClasess has driver, Browser. take screenshot and TimeWait features which applicable to all test cases
	
	public WebDriver driver; 
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
	    prop = new Properties();  //Properties class for accessing global varibles in data.properties file
		
		String basePath = System.getProperty("user.dir");  //This will gives path until E2E project i.e. /Users/a9854551/Desktop/Udemy/E2E_Project
		
		FileInputStream fis = new FileInputStream(basePath+"/src/main/java/resources/data.properties");
		prop.load(fis);  //File system accessing the properties file
		
		// Getting the property name i.e. browsername from property file and run the tests on that browser is
		// not feasible when you want to run on different browsers from Maven or Jenkins (as managers got access to command prompt and Jenkins
		// In order to overcome this use System.getproperty for getting browser name.
		//mvn test -Dbrowser=chrome   //browser is the variabe pulling from the propeties file and overriding the browsername while running
		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");  //Get the global varibale i.e browser name from properties file
		
		
		//Connect to relevant browser driver
		
		if (browserName.contains("chrome")) 
		
		{
			System.setProperty("webdriver.chrome.driver", "//Users//a9854551//Desktop//Udemy//Drivers//chromedriver 2");
			//Headless browser allows to run tests without opening the browsers which enhances the performance
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "//Users//a9854551//Desktop//Udemy//Drivers//geckodriver 2");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.gecko.driver", "//Users//a9854551//Desktop//Udemy//Drivers//ie");
		//	driver = new ieDriver();
		}
		
		//Setting up the Implicit wait for all tests
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		}
	//Take Screenshots method
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot takeShot=(TakesScreenshot) driver;
		File source = takeShot.getScreenshotAs(OutputType.FILE);
		//reports folder will be created and takes screenshot of defect and save it as with testcasename.png
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));	
		
		return destinationFile;  //we need this dest file for attaching screen capture path to the reports
		
	}
	
}
