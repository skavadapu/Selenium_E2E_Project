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

public class validateFeatureTitle extends baseClass{
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(validateFeatureTitle.class.getName());
	
	@BeforeTest
	public void startUp() throws IOException {
		driver = initializeDriver();
		//driver.get("http://qaclickacademy.com");
		driver.get(prop.getProperty("url"));
		
	}
	
	

	@Test
	public void featureCheck() throws IOException {
	
		LandingPage LandP = new LandingPage(driver);
		LandP.getFeatureTitle().getText();
		
		//Validating the feature title
		Assert.assertEquals(LandP.getFeatureTitle().getText(), "FEATURED123 COURSES");
		log.info("Featured Course text validated successfully");
		
		//Validate navigation bar presence
		Assert.assertEquals(LandP.getNavBar().isDisplayed(), true);	
		
	}
	@AfterTest
	public void teardown() {  //close the driver
		driver.close();
	}
}
