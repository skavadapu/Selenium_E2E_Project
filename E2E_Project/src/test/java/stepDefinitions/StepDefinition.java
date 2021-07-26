package stepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.baseClass;



public class StepDefinition extends baseClass{
	
	@Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
    }
	
	@And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

    @And("^Click on Login link in home page to land on Secure sign in Page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
    	LandingPage landingP = new LandingPage(driver);
		
		landingP.getSignIn().click();
    }
    
    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPage loginP = new LoginPage(driver);
		
		loginP.getUsername().sendKeys(username);
		loginP.getPassword().sendKeys(password);
		loginP.getLoginButton().click();
    }

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
      
    }

    @And("^Close the browsers$")
    public void close_the_browsers() throws Throwable {
    	driver.quit();
    }


}
