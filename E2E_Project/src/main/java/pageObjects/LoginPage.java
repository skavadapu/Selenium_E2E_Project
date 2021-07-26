package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;

	//Constructor which require for driver to be available throughout the project
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By username = By.id("user_email");
	By password = By.id("user_password");
	By login = By.name("commit");

	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(login);
	}
	

}
