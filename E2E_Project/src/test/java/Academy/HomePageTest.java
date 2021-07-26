package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.baseClass;


public class HomePageTest extends baseClass{
	
	//When running tests in parallely, the driver conflicts are coming up so needs local driver
	public WebDriver driver;
	
	//Initialising the logger for grabbing the logs
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeMethod  //Used BeforeMethod instead BeforeTest as due to dataProvider we need to initializeDriver for each of data
	public void startUp() throws IOException {
	
		//initializeDriver and openurl is not used here as due to dataProvider we need to initialize multiple 

		driver = initializeDriver();
		//driver.get("http://qaclickacademy.com");
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test(dataProvider="getData")
	public void HomePageNavigation(String username, String password, String text) throws IOException {
		
		//Objects and methods from other class files can be accessed using either Inheritance or 
		//creating instance of class and invoke methods
		//System.out.println(basePath);
		LandingPage landingP = new LandingPage(driver);
		
		landingP.getSignIn().click();
		
		LoginPage loginP = new LoginPage(driver);
		
		loginP.getUsername().sendKeys(username);
		loginP.getPassword().sendKeys(password);
		log.info(text);
		loginP.getLoginButton().click();
		
	}
	
	@DataProvider
	public Object[][] getData() throws InterruptedException {
		//Rows denotes how many sets of data have to be run , here two sets of data
		//Columns denotes how many variables/data to be passed , here 2 i.e. username, pwd
		Object[][] data = new Object[2][3]; //2 rows and 2 columns but indexes start with 0
		//Set 1 data
		data[0][0] = "Hello@yahoo.com";
		data[0][1] = "Hai";
		data[0][2] = "First test set data passed";
		Thread.sleep(2000);
		//Set 2 data
		data[1][0] = "randomemail@anywhere.com";
		data[1][1] = "wrong";
		data[1][2] = "Second test set data passed";
		
		return data;
		
	}
	
	@AfterTest
	public void teardown() {  //close the driver
		driver.close();
		log.info("Driver closed down");
	}
	

}
