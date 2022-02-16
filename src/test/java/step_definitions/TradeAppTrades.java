package step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeAppTradesPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.Driver;
import utilities.PropertiesReader;

public class TradeAppTrades {

	TradeAppTradesPage tradePage = new TradeAppTradesPage();
	DButils dbUtils = new DButils();
	String stockSymbol;
	String StockentryPrice;
	BrowserUtils utils = new BrowserUtils();
	List<String> addTradeDate;

	@Given("I am on the Trade App log in page")
	public void i_am_on_the_trade_app_log_in_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("TradeAppURL"));
	}

	@When("I enter username{string} password{string}")
	public void i_enter_username_gulpari_password_super_gulpari123(String username, String password) {
		tradePage.Username.sendKeys(username);
		tradePage.Password.sendKeys(password);
	}

	@When("I click on Trade login button")
	public void i_click_on_trade_login_button() {
		tradePage.loginbtn.click();
	}

	@Then("I should be on the Trade homepage")
	public void i_should_be_on_the_trade_homepage() {
		Assert.assertTrue(tradePage.tradeIconImage.isDisplayed());

	}

	@When("I click on Add Trade button")
	public void i_click_on_add_trade_button() {
		tradePage.addTrade.click();

	}

	@Then("I should be on Save Trade page")
	public void i_should_be_on_save_trade_page() {
		Assert.assertTrue(tradePage.heading.isDisplayed());

	}

	@When("I select {string} I enter symbol {string} entryDate {string} entryPrice {string} exitDate {string} exitPrice {string}")
	public void i_select_and_i_enter_symbol_entry_date_entry_price_exit_date_exit_price(String buyOrsell, String symbol,
			String entryDate, String entryPrice, String exitDate, String exitPrice) {
		stockSymbol = symbol;
		StockentryPrice = entryPrice;

		tradePage.buyOrSellDropdown.click();
		tradePage.BuyToOpen.click();
		// select from the dropdown
		// utils.selectByVisibleText(tradePage.buyOrSellDropdown, buyOrsell);

		tradePage.stockSymbol.sendKeys(symbol);
		tradePage.openDate.sendKeys(entryDate);
		tradePage.Entry.sendKeys(entryPrice);
		tradePage.CloseDate.sendKeys(exitDate);
		tradePage.Exit.sendKeys(exitPrice);
	}

	@When("I click Save button")
	public void i_click_save_button() {
		tradePage.saveButton.click();

	}

	@Then("The trade is displayed on the trade table")
	public void the_trade_is_displayed_on_the_trade_table() {
		Assert.assertTrue(tradePage.tradeIconImage.isDisplayed());

		for (WebElement singleSymbol : tradePage.stockSymbols) {
			if (singleSymbol.getText().equals(singleSymbol))
				Assert.assertEquals(singleSymbol.getText(), stockSymbol);

		}

	}

	@Then("The trade is deleted on the Database")
	public void the_trade_is_deleted_on_the_database() {
		String sql = "DELETE FROM records WHERE symbol = " + "'" + stockSymbol + "'";
		dbUtils.deleteRecord(sql);
	}

//data table
	@When("I enter the following data")
	public void i_enter_the_following_data(DataTable dataTable) {
		addTradeDate = dataTable.transpose().asList();

		stockSymbol = addTradeDate.get(1);
		StockentryPrice = addTradeDate.get(3);

		tradePage.buyOrSellDropdown.click();
		tradePage.BuyToOpen.click();
		// utils.selectByVisibleText(tradePage.buyOrSellDropdown, addTradeDate.get(0));
		tradePage.stockSymbol.sendKeys(addTradeDate.get(1));
		tradePage.openDate.sendKeys(addTradeDate.get(2));
		tradePage.Entry.sendKeys(addTradeDate.get(3));
		tradePage.CloseDate.sendKeys(addTradeDate.get(4));
		tradePage.Exit.sendKeys(addTradeDate.get(5));
	}

//AddTradeAndValidate start
	@Then("The trade data resides in database correctly")
	public void the_trade_data_resides_in_database_correctly() {
		String buyorsell = addTradeDate.get(0);
		String symbol = addTradeDate.get(1);
		String entryPrice = addTradeDate.get(3);
		String exitPrice = addTradeDate.get(5);

		String selectQuery = "SELECT long_short, symbol, entry_price, exit_price FROM records WHERE symbol=" + "'"
				+ stockSymbol + "'";
		List<String> dataFromDB = dbUtils.selectARecord(selectQuery);
		String buyOrSellDB = dataFromDB.get(0);
		System.out.println("Buy ot sell" + buyOrSellDB);
		String symbolDB = dataFromDB.get(1);
		System.out.println("symbol" + symbolDB);
		String entryPriceDB = dataFromDB.get(2);
		System.out.println("Entry price" + entryPriceDB);
		String eixtPriceDB = dataFromDB.get(3);
		System.out.println("Exit Price" + eixtPriceDB);

		Assert.assertTrue(buyOrSellDB.equals("1"));
		Assert.assertEquals(symbol, symbolDB);
		Assert.assertEquals(entryPrice, entryPriceDB);
		Assert.assertEquals(exitPrice, eixtPriceDB);

	}

	// insertDatebase
	@Given("I executed insert query to database")
	public void i_executed_insert_query_to_database(DataTable dataTable) {
		addTradeDate = dataTable.transpose().asList();

		stockSymbol = addTradeDate.get(3).substring(1, addTradeDate.get(3).length() - 1);

		String id = addTradeDate.get(0);
		String uer_id = addTradeDate.get(1);
		String long_short = addTradeDate.get(2);
		String symbol = addTradeDate.get(3);
		String opendate = addTradeDate.get(4);
		String entryPrice = addTradeDate.get(5);
		String exitdate = addTradeDate.get(6);
		String exitPrice = addTradeDate.get(7);
		String gain = addTradeDate.get(8);

		String insertQuery = "INSERT INTO records VALUES(" + id + "," + uer_id + "," + long_short + "," + symbol + ","
				+ opendate + "," + entryPrice + "," + exitdate + "," + exitPrice + "," + gain + ")";
		System.out.println(insertQuery);
		dbUtils.insertRecord(insertQuery);

	}

	@When("I search the {string}")
	public void i_search_the(String tradeSymbol) {
		utils.waitUntilElementVisible(tradePage.searchBtn);
		stockSymbol = tradeSymbol;
		tradePage.searchBox.sendKeys(tradeSymbol);

	}

	@When("I click the Search button")
	public void i_click_the_search_button() {
		tradePage.searchBtn.click();

	}

	@Then("The trade input displayed on the trade table")
	public void the_trade_input_displayed_on_the_trade_table() {
		Assert.assertTrue(tradePage.addTrade.isDisplayed());
		Assert.assertEquals(stockSymbol, tradePage.stockSymbols.get(0).getText());
	}

}
