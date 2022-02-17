@Regression
Feature: As a user, I am able to perform Trade app functions
I want to add, delete and update trades

@AddTrade @SmokeTests
Scenario: As a user, I want to add a trade
Given I am on the Trade App log in page
When I enter username "Gulpari" password "SuperGulpari123!"
And I click on Trade login button
Then I should be on the Trade homepage
When I click on Add Trade button
Then I should be on Save Trade page
When I select "Buy to open" I enter symbol "kawap" entryDate "04/04/2021" entryPrice "10" exitDate "06/04/2021" exitPrice "20" 
And  I click Save button
Then The trade is displayed on the trade table
And The trade is deleted on the Database

@AddTradeDataTable @SmokeTests
Scenario: As a user, I want to add a trade
Given I am on the Trade App log in page
When I enter username"Gulpari" password"SuperGulpari123!"
And I click on Trade login button
Then I should be on the Trade homepage
When I click on Add Trade button
Then I should be on Save Trade page
When I enter the following data
|Buy to open|Kawap|04/04/2021|10.0|06/04/2021|20.0|
And  I click Save button
Then The trade is displayed on the trade table
And The trade is deleted on the Database

@AddTradeAndValidate @SmokeTests
Scenario: As a user, I want to add a trade
Given I am on the Trade App log in page
When I enter username"Gulpari" password"SuperGulpari123!"
And I click on Trade login button
Then I should be on the Trade homepage
When I click on Add Trade button
Then I should be on Save Trade page
When I enter the following data
|Buy to open|p1p1|04/04/2021|10.0|06/04/2021|20.0|
And  I click Save button
Then The trade is displayed on the trade table
And The trade data resides in database correctly
And The trade is deleted on the Database

@InsertDB @SmokeTests
Scenario: AS a user, I am able to insert a trade to Database
Given I executed insert query to database
|'5468'|'1'|'0'|'Kawap'|'2021-10-11'|'10.0'|'2022-02-12'|'20.0'|'0'|
Given I am on the Trade App log in page
When I enter username"Gulpari" password"SuperGulpari123!"
And I click on Trade login button
Then I should be on the Trade homepage
When I search the "Kawap" 
And I click the Search button
Then The trade input displayed on the trade table
And The trade is deleted on the Database

