package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    @FindBy(id = "user_count")
    private WebElement userCount;

    @FindBy(id="book_count")
    private WebElement bookCount;

    @FindBy(id = "borrowed_books")
    private WebElement borrowedCount;

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    public String getUserCountText(){
       return userCount.getText();
    }

    public String bookCountText(){
      return   bookCount.getText();
    }

    public String borrowedBookCount(){
       return borrowedCount.getText();
    }








}
