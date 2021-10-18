package com.cydeo.pages;

import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    public GoogleHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goTo(){

       // Driver.getDriver().get("https://google.com"));
        Driver.getDriver().get(ConfigReader.read("google.url"));
    }

    public void searchKeyword(String keyWord){
       this.searchBox.sendKeys(keyWord);
       this.searchBtn.submit();

    }

    public boolean isAt(){

       return Driver.getDriver().getTitle().equals("Google");
    }




}
