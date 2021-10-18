package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    //running before and after each scenario
    //we set hook class that has a methods so it can run
    //before or after each scenario

    @Before("@ui")
    public void setupDriver(){
        //set up implicit wait
        System.out.println("This is from @Before inside hooks class");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @After("@ui")
    public void tearDown(Scenario scenario){
        System.out.println("This is from @After inside hooks class");
        if(scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot,"image/png", scenario.getName());
        }
       Driver.closeBrowser();
    }

}
