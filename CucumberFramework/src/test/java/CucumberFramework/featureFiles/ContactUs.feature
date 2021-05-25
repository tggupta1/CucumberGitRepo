Feature: Submit data to webdriveruniversity using Contact us form

Scenario: Submit valid data via contact us form
 Given I access webdriveruniversity.com
 When I click on Contact us button
 And I enter a valid username and password
 And I enter valid email address
 And I enter comments
 | example comment one | example comment two|
 When I click on Submit button
 Then Information should be successfully be submitted to contact us page