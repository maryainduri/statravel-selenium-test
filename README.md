# STA TRAVEL SELENIUM TEST

Sta Travel Selenium UI automation test has been written in Java Selenium Cucumber-JVM, have used Gradle build tool.

### Note:
 
 * BDD cucumber feature files will be goes under `src/resources/featurefiles`
 
 * Cucumber step definition under `src/test/java/com.statravel.automation/stepdefinitions`
 
 * Cucumber Test Runner under `src/test/java/com.statravel.automation/testrunners`
 
# How to run tests

`gradle clean test`

or

Right click on Test runner and Run As Junit

# Framework improvements
* we can keep environment specific property files (dev,stag,prod).properties under ```test/resources``` and read environment specific details using propertyreader
* we can keep browser configuration out of the project and pass browser & environment details on command line Ex: ````gradle clean test -Pbrowser=chrome -Penv=prod````



# Contact
* marya.induri@gmail.com
 




