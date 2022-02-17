@Regression
Feature: Amazon Search
              As a user, I should be able to search an iteam and the searched iteams should be relavant to search
              
              @amazonSearch @SomleTests
              Scenario Outline: User is able to search multiple data set
              Given I am on amazon home page
              When I search item "<items>" 
              And I click search button
              Then searched "<items>" should be displayed in the search bar
              
              Examples: items
              |items|  
              |Coffee mug| 
              |Pretty coffee mug|
              |Cool coffee mug|
              |Cute coffee mug|
              |Ugly coffee mug|
              
              

 

 

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
