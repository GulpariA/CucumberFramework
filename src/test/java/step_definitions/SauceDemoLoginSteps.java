package step_definitions;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SauceDemoLoginPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class SauceDemoLoginSteps {
	
	SauceDemoLoginPage page = new SauceDemoLoginPage();
	BrowserUtils utils = new BrowserUtils();
	@Given("I am on the SauceDemo login page")
	public void I_am_on_the_SauceDemologin_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("sauceURL"));
	}
	@When("I enter valid username {string} password {string}")
	public void i_enter_valid_username_password(String username, String password) {
		page.username.sendKeys(username);
		page.password.sendKeys(password);
	
	}
	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		page.loginButton.click();
	 
	}
	@Then("I should be directed to inventory page")
	public void i_should_be_directed_to_inventory_homepage() {
	  Assert.assertTrue(page.inventoryPageProductText.isDisplayed());
		
	}
	@Then("There should be {int} items in the page")
	public void there_should_be_iteams_in_the_page(Integer number) {
		Assert.assertTrue(number==	page.inventoryItems.size());
		//Assert.assertSame(number, page.inventoryIteams.size());

	}
	//valid tests #ends
	
// invalid test #starts
	@When("I enter invalid username {string} password {string}")
	public void i_enter_invalid_username_password(String username, String invalidPassword) {
		page.username.sendKeys(username);
		page.password.sendKeys(invalidPassword);
	}
	@Then("I should not be logged in")
	public void i_should_not_be_logged_in() {
		Assert.assertTrue(page.username.isDisplayed());
		Assert.assertFalse(utils.isElementPresent(page.inventoryPageProductText));
	
	}
	
	   
	
	@Then("Error message should display {string}")
	public void error_message_should_display(String errorMessage) {
		Assert.assertEquals(page.errorMessage.getText(),errorMessage);

	}
			
	


}
