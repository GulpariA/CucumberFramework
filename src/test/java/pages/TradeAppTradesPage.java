package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class TradeAppTradesPage {
	
	public TradeAppTradesPage(){
		PageFactory.initElements(Driver.getDriver(),this);
		
	}
	
	@FindBy(id="username")
	public WebElement Username;
	
	@FindBy(id="password")
	public WebElement Password;
	
	@FindBy(css=".btn-lg ")
	public WebElement loginbtn;
	
	@FindBy (xpath="//img[contains(@src, '.png')]")
	public WebElement tradeIconImage;
	
	@FindBy(css=".btn-primary")
	  public WebElement addTrade;
	
	@FindBy(css=".h4")
	public WebElement heading;
	
	@FindBy(id="longTrade")
	//@FindBy(name="longTrade")
	public WebElement buyOrSellDropdown;
	
	@FindBy (xpath="//option[contains(text(),'Buy to Open')]")
	public WebElement BuyToOpen;
	
	@FindBy(id="symbol")
	public WebElement stockSymbol;
	
	@FindBy(id="openDate")
	public WebElement openDate;
	
	@FindBy(id="entry")
	public WebElement Entry;
	
	@FindBy(id="closeDate")
	public WebElement CloseDate;
	
	@FindBy(id="exit")
	public WebElement Exit;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement saveButton;
	
	@FindBy(xpath = "//table[@class ='table table-bordered table-striped']/tbody/tr/td[2]")
	public List<WebElement> stockSymbols;
	
	@FindBy(xpath = "//table[@class ='table table-bordered table-striped']/tbody/tr/td[3]")
	public List<WebElement>stockEntryPrices ;
	
	@FindBy(xpath = "//input[@type='search']")
	public WebElement searchBox;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	public WebElement searchBtn;
	


}
