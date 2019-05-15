Feature: Pets 

Scenario Outline: Add a pet with valid data 

	Given A valid name, photoUrls and "<expectedStatus>" are available for JSON Body 
	When A Request for "POST" method is made to the PET API with valid JSON body 
	Then PET API should return status 200 
	And Response should have same data as Body
	
	Examples: 
		|expectedStatus |
		|available		|
		|pending		|
		|sold           |
		
Scenario: Access Pet API with get request 
	Given A valid name, photoUrls and "sold" are available for JSON Body 
	When A Request for "GET" method is made to the PET API with valid JSON body 
	Then PET API should return status 405 
	
	

