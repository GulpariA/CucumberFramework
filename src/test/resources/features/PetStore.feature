Feature: As a user I am able to perform HTTP request
  I want to perform GET, POST, PUT, and DELETE requests on Pet Store API

  @CreateAPet
  Scenario: I am able to create a Pet using Post request
    When I am able to perform Post request to create a pet with valid request body
    
     @PostToAddPet
    Scenario: As a user, I should be able to perform POST request to add new pet to store
    Given I have the POST request URL and valid request body
    When I perform POST request to URL with request body
    Then Response status code should be 200
    And Content type is "application/json"
    And Response body match the request body
