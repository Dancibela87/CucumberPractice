package com.cydeo.step_definitions;

import com.cydeo.pages.WLoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.apache.commons.logging.Log;

import java.util.List;
import java.util.Map;

public class DatatableStepDef {
    @Given("I have a {string}")
    //@Given("I have a {word}")
    public void i_have_a(String animal) {
        System.out.println("Given I have "+ animal);
    }
    @When("I call their names")
    public void i_call_their_names() {
        System.out.println("When I call their names ");
    }
    @Then("They come to me.")
    public void they_come_to_me() {
        System.out.println("Than they come to me ");
    }

    @Given("I have following animals")
    public void i_have_following_animals(List<String> animalsList) {
        System.out.println("animalsList = " + animalsList);
    }

    @When("I call their names with bellow names")
    public void iCallTheirNamesWithBellowNames(List<String> namesList) {
        System.out.println("namesList = " + namesList);
    }


    @Then("They come to me with below noise")
      public void theyComeToMeWithBelowNoise(Map<String, String> animalNoiseMap ){
       System.out.println("animalNoiseMap = " + animalNoiseMap);

    }

    @When("we provide below credentials")
    public void weProvideBelowCredentials(Map<String, String> credentials) {
        System.out.println("credentials = " + credentials);

        WLoginPage login = new WLoginPage();
        String username = credentials.get("username");
        String password = credentials.get("password");
        login.login(username,password);

    }

    @Given("this is the product reference")
    public void thisIsTheProductReference(List<Map<String, Object>> productMapList)  {

        System.out.println("productMapList = " + productMapList);
        for(Map<String, Object> eachRowMap : productMapList){
            System.out.println("eachRowMap = " + eachRowMap);
        }

        Map<String, Object> thirdRowMap = productMapList.get(2);
        // the key is column name , the value is cell value
        System.out.println("thirdRowMap = " + thirdRowMap);
        // print Discount column of 3rd row
        System.out.println("thirdRowMap.get(\"Discount\") = "
                + thirdRowMap.get("Discount"));

        //give me the price value of family album
        System.out.println("productMapList.get(1).get(\"Price\") = "
                + productMapList.get(1).get("Price"));

    }


    @And("I have another product reference without header")
    public void iHaveAnotherProductReferenceWithoutHeader(List<List<String>> productInfoList) {

        System.out.println("productInfoList = " + productInfoList);

        //get entire third row
        List<String> thirdRow =  productInfoList.get(2);
        System.out.println("thirdRow = " + thirdRow);

        //get the price value of third row
        System.out.println("thirdRow.get(1) = " + thirdRow.get(1));

        //get discount column of the first row
        System.out.println("productInfoList.get(0).get(2) = " + productInfoList.get(0).get(2));


    }
}

