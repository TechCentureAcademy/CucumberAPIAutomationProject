<<<<<<< HEAD
@getCurrentWeatherByCityname
Feature: call getCurrentWeatherName

Background: 

     Given base URL "https://api.openweathermap.org/data/2.5/weather"

Scenario: call get request to the service
When service is being called
Then validate cityName and status code


Scenario: call get method to find weather by zip code
When service is being called by get request with query parameters
Then validate country and status code

=======
@getCurrentWeatherByCityname
Feature: call getCurrentWeatherName

Background: 

     Given base URL "https://api.openweathermap.org/data/2.5/weather"

Scenario: call get request to the service
When service is being called
Then validate cityName and status code


Scenario: call get method to find weather by zip code
When service is being called by get request with query parameters
Then validate country and status code

>>>>>>> branch 'master' of https://github.com/TechCentureAcademy/CucumberAPIAutomationProject.git
 