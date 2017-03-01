This project is for the purpose of recruitment of a QA person.

# Project Description
It is a simple test project, which has actually 11 test scenarios implemented.
It runs only using Chrome browser, but it can be improved in the next versions to run in other browsers. 
For Mac OS, you need to use chromedriver from $root/MacOS_driver/chromedriver.
This web application simulates a shop with two kinds of products. Initially there are 20 items of the 1st product and 10 items of the 2nd product. User can choose how many items of each product he wants to buy and clicks the "Buy" button. Application can check if there is enough items left and show the summary of the shopping (or an error page if there is not enough items left).

The tests were based on the following User Stories:
	As an User I want to see current number of two kinds of items.
	As an User I want to buy specified number of items.
	As an User I want to see summary of my shopping.
	
#Running the Project
You need to have maven install in your system.
Also, you need to run the following command in your terminal `mvn spring-boot:run`. (This command will download all the required dependencies and will start the server.) 
The application will be available at `http://localhost:8080`. 

#Running the Tests
To run all the tests you need to run the following command in your terminal `mvn test`. (This command will run all the tests scenarios already implemented.) 
Or, you can also Run As Junit the Runner class from $root/src/test/java/com/orionhealth/shop/RunCukesTest.java 

#Running @Regression Tests
The tag @regression is used to run only regression test scenarios from the project.
To run all @regression tests you need to Run As Junit the Runner class from $root/src/test/java/com/orionhealth/shop/RunCukesRegressionTest.java

#Running @Now Tests
The tag @now is used to run specific test scenarios from the project to facilitate the development.
To run all @regression tests you need to Run As Junit the Runner class from $root/src/test/java/com/orionhealth/shop/RunCukesNowTest.java

#Running @Smoke Tests
The tag @smoke is used to run only smoke test scenarios from the project.
To run all @smoke tests you need to Run As Junit the Runner class from $root/src/test/java/com/orionhealth/shop/RunCukesSmokeTest.java

#Reseting the project
At the moment the only way to reset the values is by stopping and starting the server.
After that, you need to do right click on RunCukesTest.java class (src/test/java into the package com.orionhealth.shop) and select Run As/2 Junit Test.

#Changing URL 
The default URL is http://localhost:8080.
To change this URL you need to use an environment variable named as "shop.host" and assign your URL.

#Missing implementation
The WaitUtils.java still needs to be completed.
	
#Expanding this framework
To expand this project you can create new test scenarios into the Shop.feature file already created in $root/src/test/resources/com/orionhealth/shop/ or, you can create new feature-files for each new system's functionality, or also, you can expand this project just creating new validations. 

If you have to expand creating new scenarios, use the structure below:
   - $feature file = $root/src/test/resources/com/orionhealth/shop -> Here you need to create your scenario in a feature-file (To learn how to use BDD to write scenarios you can use https://cucumber.io/training)
   - $Shop class =  $root/src/test/java/com/orionhealth/shop/pageobject/Shop.java -> Here you need to create or reuse the steps to interact with the page according your scenario. This class has only the responsibility of mapping the fields. (If any question on how to create a correct page object pattern you can go to http://stackoverflow.com/questions/10315894/selenium-webdriver-page-object.)
   - $ShopStepDefs class =  $root/src/test/java/com/orionhealth/shop/stedefs/ShopStepDefs.java -> Here you need to implement the steps of your scenario.



If you have to expand creating new assertions, use the structure below:
   - $ShopStepDefs class =  $root/src/test/java/com/orionhealth/shop/stedefs/ShopStepDefs.java -> Here you need to implement the steps of your scenario and add your assertions.



If you have to expand creating new feature-files, use the structure below:
   - $feature-file class= $root/src/test/resources/com/orionhealth/shop/ -> Here you need to create your feature-file.
To create a new feaure-file you need to do right click on  Shop folder, choose New> File, write your feature name and don't forget to write this exactly  ".feature" in the end of your feature's name. After that, you can save this file. Now you have to write your feature, write a description for your feature and create your scenarios according your necessity. (To learn how to use BDD for writing features and scenarios you can go to https://cucumber.io/training)
   - $Shop class =  $root/src/test/java/com/orionhealth/shop/pageobject/Shop.java -> Here you need to create or reuse the steps to interact with the page according your scenario. This class has only the responsibility of mapping the fields. (If any question on how to create a correct page object pattern you can go to http://stackoverflow.com/questions/10315894/selenium-webdriver-page-object.)
   - $ShopStepDefs class =  $root/src/test/java/com/orionhealth/shop/stedefs/ShopStepDefs.java -> Here you need to implement the steps of your scenario.

