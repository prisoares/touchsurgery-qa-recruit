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
The tag @regression is used to run only regression test scnearios from the project.
To run all @regression tests you need to Run As Junit the Runner class from $root/src/test/java/com/orionhealth/shop/RunCukesRegressionTest.java

#Running @Now Tests
The tag @now is used to run specific test scnearios from the project to facilitate the development.
To run all @regression tests you need to Run As Junit the Runner class from $root/src/test/java/com/orionhealth/shop/RunCukesNowTest.java

#Running @Smoke Tests
The tag @smoke is used to run only smoke test scnearios from the project.
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
To expand this project you need to create more test scenarios into feature-files.