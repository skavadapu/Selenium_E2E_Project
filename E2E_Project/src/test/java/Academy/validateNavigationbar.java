package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;


import pageObjects.LandingPage;
import resources.baseClass;

public class validateNavigationbar extends baseClass{
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(validateNavigationbar.class.getName());
	
	@BeforeTest
	public void startUp() throws IOException {
		driver = initializeDriver();
		log.info("Webdriver initialized");
		//driver.get("http://qaclickacademy.com");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
		
	}
	
	@Test
	public void Navcheck () throws IOException {

		LandingPage LandP = new LandingPage(driver);
		
		//Validate navigation bar presence
		Assert.assertEquals(LandP.getNavBar().isDisplayed(), true);	
		log.info("Navigation bar presennce successfully validated");
		
	}
	
	@AfterTest
	public void teardown() {  //close the driver
		driver.close();
	}
}
