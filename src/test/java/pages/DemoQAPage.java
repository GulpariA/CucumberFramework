package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class DemoQAPage {
	
	public DemoQAPage() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	//RadioPage elements
	@FindBy(xpath="//div[contains(text(),'Do you like the site')]")
	public WebElement doYouLikeText;
	
	@FindBy (xpath="//label[@for='yesRadio']")
	public WebElement yesRadioLabel;
	
	@FindBy (xpath="//label[@for='impressiveRadio']")
	public WebElement impressiveRadioLabel;
	

	public WebElement noRadio;
	
	@FindBy (css=".mt-3")
	public WebElement radioSelectText;

	
	//Alerts page element
	@FindBy(id= "alertButton")
	public WebElement AlertButton;
	
	public WebElement timerAlertButton;
	
	public WebElement confirmButton;
	
	public WebElement promtButton;
	
	
	
	
	
	
	
	
	
	
	
	
}
