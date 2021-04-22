Feature: Login into aplication


Scenario: Positive test validating login 
Given Initialize the browser with chrome
And navigate to "QAClickAcademy" site
And click on login link in the home page and land on secure sigh in page
When user enters "test99@gmail.com" and "123456" and logs in
Then verify that user is successfully logged in