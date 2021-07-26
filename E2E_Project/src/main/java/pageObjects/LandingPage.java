package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
	
			this.driver = driver;
	}

	
	By signIn = By.linkText("Login");
	By featureTitle = By.xpath("//section[@id='content'] //h2");  //FeaturedCourse text
	By navBar = By.xpath("//div[@role='navigation']//nav"); //Navigation bar
	
	
	public WebElement getSignIn() {
		
		return driver.findElement(signIn);
		
	}
	
	public WebElement getFeatureTitle() {
		
		return driver.findElement(featureTitle);
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);
		
	}
	
}
