package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCarPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.util.Map;

public class CreateCarStepDefinitions {
    CreateCarPage createCarPage = new CreateCarPage();

    @Given("user clicks on create car button")
    public void user_clicks_on_create_car_button() {
        createCarPage.clickOnCreateCar();

    }


    /*  When user adds new vehicle information
       #for to enter the data, we enter as following
      # left side parameter, , right side value
       |License Plate | SDET |
       |Model Year    | 2021 |

       dataTable.get("License Plate") --> SDET
       dataTable.get("Model Year") --> 2012

       Map: is a data structure where every value is referenced by key.
       (in arraylist is it always index)
       dataTable = {Licence Plate = SDET,
                     Model Year = 2021}

       If you want to turn data table into map, it must be excatly 2 columns

      If it is a 1 column, it can be just list:
      eg:
      Then user verifies following list:
      |10|
      |20|
      |50|

      @Then("user verifies foloowing list:")
      public void user_verifies_following_list(List<String> dataTable){}

      DataTable - cucumber data structure/data type. We convert it into Map, List or List <Map<>>
     */
    @When("user adds new vehicle information")
    // this line is the snip provided by dryrun
    // we have to change the data table part to the Map<>
    // public void user_adds_new_vehicle_information(io.cucumber.datatable.DataTable dataTable) {
    public void user_adds_new_vehicle_information(Map<String, String> dataTable) {
        //to get all the keys and vaules one by one, we can write like this.
        //lambda expression
        dataTable.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        //if you do not want to use for each loop , you cna write like this:
      //  for (Map.Entry<String, String> entry: dataTable.entrySet()){
      //      System.out.println("Key: "+entry.getKey() + ", value: "+entry.getValue());
      //  }

        System.out.println("License Plate: " + dataTable.get("License Plate"));
        System.out.println("Model Year: " + dataTable.get("Model Year"));

        createCarPage.enterLicencePlate(dataTable.get("License Plate"));
        createCarPage.enterModelYear(dataTable.get("Model Year"));



    }


}
