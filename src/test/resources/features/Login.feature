@login
Feature: As user I want to be able to login under different roles

  #this is a comment

Background: common steps
  Given user is on the login page

  @smoke
  Scenario: Login as a sales manager
    When user logs in
  Then user should see dashboard page

# for to run this scenario separate, we create customized tag for this scenario
  @parametrized_test @smoke_test
  Scenario: Parametrized login
 # Given user is on the login page--> this line moved to the background
  When user logs in as a "store manager"
  Then user should see dashboard page
    # "driver" is a parameter. this " " allows us to do test parametrization
    # which helps to re-use test steps.

  @parametrized_test @smoke_test
  Scenario: Parametrized login
    When user logs in as a "sales manager"
    Then user should see dashboard page

   @s_o
    Scenario Outline: Parametrized login as <role>
      When user logs in as a "<role>"
      Then user should see dashboard page
      Examples:
      |role         |
      |sales manager|
      |store manager|

  #what if we add one more role "driver"
  # he does not sees dashboard  but quicklaunchPad
  # so if we want differnt page title for different users , how do we change the outline?

  @s_o @with_two_columns
  Scenario Outline: Parametrized login as <role>
    When user logs in as a "<role>"
    Then user should see "<page_title>" page
    Examples:
      |role         |page_title       |
      |sales manager|Dashboard        |
      |store manager|Dashboard        |
      | driver      |Quick Launchpad  |
 # we have to make another column to parametize the page title.
  # put dashboard in the " " . after this step, that line of scenario will turn yellow
  # that mean there is no code implementation for this step in the step definition,
  #we have to dry run and get unimplemented steps to write in the step definition
 # we can also create new tag for this scenario  @with_two_columns.
  #When we dry run, we have to give the tags like this:
  # tags = "@s_o  and @with_two_columns",  --> put " and " in between of the tags
  #this means run the scenario with these both tags.

  # tags = "@s_o  and @with_two_columns",
  #scenario must have both tags
  #same as in java: @s_o  &&  @with_two_columns

  #tags = "@s_o  and @with_two_columns",
  #scenario must have Either OR tags
  #same as in java: @s_o  ||  @with_two_columns




  @negative_login  @ie @smoke
  Scenario: Invalid password
   # Given user is on the login page--> This line moved to the background
    When user logs in with "storemanager85" username and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed
    # everything in " " in this scenario become parameter. So that it can easy t use and
   # change in the future.

  @negative_scenario_outline
  Scenario Outline: Invalid login with <username> and <password>
    When user logs in with "<username>" username and "<password>" password
    Then user verifies that "<message>" message is displayed
    Examples: data set
      | username | password | message                       |
      | wrong    | bad      | Invalid user name or password |
      | wrong    | bad      | Invalid user name or password |