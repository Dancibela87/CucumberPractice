package com.cydeo.pages;

import com.cydeo.utilities.
        Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultPage {


    @FindBy(id = "result-stats")
    private WebElement searchResultCount;

    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']")
    private List<WebElement> resultLinks;

    public GoogleResultPage(){                                    //this is constructor
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //return the text of the result count element
    public String getResultCountText(){
        return searchResultCount.getText();

    }
    //print the text of all result link
    public void printAllSearchResultLink(){

        System.out.println( resultLinks.size() );

        for (WebElement eachLink : resultLinks) {
            System.out.println("eachLink.getText() = " + eachLink.getText());


        }

    }
}
