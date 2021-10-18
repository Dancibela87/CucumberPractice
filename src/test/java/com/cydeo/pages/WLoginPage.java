package com.cydeo.pages;

import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WLoginPage {

    //we do not need find elements anymore
    //we use FindBY annotations , it is interface

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameFiled;

    @FindBy(name = "ctl00$MainContent$password")
    public WebElement passwordFiled;

    @FindBy(css = "#ctl00_MainContent_login_button")
    public WebElement loginBtn;

    @FindBy(xpath = "//span[.='Invalid Login or Password.']")
    public WebElement errorMsg;

    //now we have to instruct selenium to start looking for elements
    //when this constructor is called, and constructor is called when new object os create


    public WLoginPage(){ //this is constructor, no argument

        PageFactory.initElements(Driver.getDriver(), this); //page factory has 4 option, this one is withWebDriver an dobject
        //this key word = says it represent the object that is created when constructor called
    }

    // PageFactory is a selenium class that support Page Object Model
    // and it has method called initElements
    // once it's called , it will locate all the element
    // specified using @FindBy annotation with locator
    // initElements accept 2 arguments ,
    // WebDriver instance and Page class instance (this) means current instance of this class.

    //create a method called goTo, accepts no parameters, just navigates to login page
    //use congif.properties for url

    public void goTo(){
        Driver.getDriver().navigate().to( ConfigReader.read("weborder_url")    );
    }

    //create login method
    public void login(String username, String password){

        // you can access directly using userNameField or this.userNameField
        this.usernameFiled.sendKeys(username);
        this.passwordFiled.sendKeys(password);
        this.loginBtn.click();

    }
    /**
     * Check error message is present if wrong credentials provided
     * loginErrorMsgPresent  simple return the result of isDisplayed method call
     */

    public boolean loginErrorMsgPresent(){

        return  this.errorMsg.isDisplayed()  ;

    }





}
