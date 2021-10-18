package com.cydeo.runner;

//this class has just one purpose, and that is to instruct how and what feature
//you wont to run, where are step definitions, do we wont to generate missing step definition, do we wont
//to get html report, do we wont to get json
//do we wont to filter the test run according to certain tag
//it has special annotation

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(  features = "src/test/resources/features" , //alternatively "classpath:features"
        glue = "com/cydeo/step_definitions" ,
        publish = true,
        plugin = {"pretty", "html:target/cucumber.html","rerun:target/rerun.txt" ,
                  "me.jvt.cucumber.report.PrettyReports:target"} ,
        dryRun = false,
        tags = "@calculator and  @non_ui"
)
public class TestRunner {
}
