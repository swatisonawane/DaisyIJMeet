Feature: This feature describes the parameterization in cucumber
Scenario: Passing numeric parameter to the Gherkin step
	Given I have 5 and 6
    When I add them
    Then Print result
    
@Regression
Scenario: Passing string parameter to the gherkin step
	Given I have "India" and "China"
	Then Print them in alphabetic order
	
Scenario: Passing float parameter to the gherkin step
	Given I have two float numbers 3.14 and 5.34
	When I add two float numbers
	Then Print result od addition
	
Scenario: Passing list of parameter to the Ghirkin step
	Given I have list of integer numbers
	|10|
	|11|
	|12|
	|13|
	Then Print the list of numbers
	
Scenario: Passing table of parameters to the gherkin step
	Given I have following table
	|firstrow|15|16|17|18|19|
	|secondrow|20|21|22|23|24|
	Then print them in row column format
	
Scenario Outline:
	Given I have <num1> and <num2>
	When We add them
	Then Verify if the result is prime
	
Examples:
|num1|num2|
|2|9|
|13|12|
|2|7|
|4|3|
|8|8|


Scenario Outline:
	Given I have two numbers from <row-number>
	When We add them
	Then Verify if the result is prime
	
Examples:
|row-number|
|1|
|2|
|3|
|4|
|5|
