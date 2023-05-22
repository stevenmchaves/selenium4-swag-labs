# selenium4-swag-labs

I used maven to get the dependencies.

I ended up putting the code in the `src/test` directory

## Project structure

I put the project coding files in the test directory.

### Data
`AccountInfo` class used as the Data object to read accounts from the `accounts.yml` file
through the use of `YamlUtils` class.

### Pages
Currently only 3. An abstract `BasePage` class to support unity of the Pages using some
base methods, getting the Webdriver object and some constants related to the driver.
<br>
Two Pages Objects:
 - SauceDemoLoginPage - actions on the Login Page
 - SauceDemoMainPage - actions on the Main Page

Further work can be done to move the hard-coded selectors in the classes into yaml files.

### Steps
Currently only 3. Same concept as above. Separated based on Steps/operations on a page.
I created a small `StepDefinitions` file to define some `After/Before` actions that would
be the same no matter what Scenario is run

### Utils
I wanted to put the account information into a Yaml file. I created one static method to
read account information. I left a main basically as a Unit test. Could have created a unit test
for the method.

### Webdriver
Abstract all or most of the Selenium driver stuff in this package/class. The BasePage
as an instance of it as a member.

## Execution
You can use RunCucumberTest to execute the features found  in the
resources section of the tests. I used an IDE to execute the tests which have
available plugins. You can execute also with `mvn test`.

