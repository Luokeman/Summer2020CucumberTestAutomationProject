package com.vytrack.step_definitions;
//Hooks triggered based on tags, not class name or their location.
//These methods can be a part of any step definition class.
//common practice is to store them in the separate class.
import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.internal.com.google.protobuf.ByteString;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;
//when select the @before and @after annotations, select from cucumber method,
//not from junit.
public class Hooks {
    //hook @Before = @BeforeMethod in TestNG
     //hook @After = @AfterMethod in TestNG
    //Its not a good idea to mix implicit and explicit waits.
    // It can lead to unexpectedly long waits.
    //usually we just use explicit and fluent waits.

    @Before //runs before every test scenarios.
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println("::: Starting Automation:::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario){
        //this is a hook after
        //runs automatically after every test
        // this @After hook used for close browser, closeDB connection
        //close tunnel connection, capture screenShot of the errors, etc.

        //These step is for to take screenshot
        if(scenario.isFailed()){
            byte[] data =((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data,"image/png", scenario.getName());


        }

        Driver.closeDriver();
        System.out.println(" ::: End of test Execution :::");
    }

   // this hook will only run before the scenarios with a tag @db
    @Before("@db")
    public void dbSetup(){
        System.out.println(":::Connecting to the database:::");
    }

        // this hook will only run after the scenarios with a tag @db
        @After("@db")
        public void dbTearDown() {
            System.out.println(":::Disconnecting from the database:::");
        }


}
