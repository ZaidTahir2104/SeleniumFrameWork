package com.arbisoft.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.arbisoft.setup.TestBase;
import io.qameta.allure.Step;

public class HomePage extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 60);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions action = new Actions(driver);

    @FindBy(css = "#user-name")
    WebElement username;
    // key words search input field locator
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#password1")
    WebElement password1;
    @FindBy(css = "#login-button")
    WebElement login;
    
    public HomePage() {
        super();
        PageFactory.initElements(driver, this);

    }

    //Valid Credentials
	@Step(" User will hit the url : {0}, when user will land on the web page then he will select his country : {1}  ")
    public void validCredentials() {
    	String standard_user = prop.getProperty("standard_user");
		  username.sendKeys(standard_user);
		  String passwords = prop.getProperty("passwords");
		  password.sendKeys(passwords);
		  login.click();
		  Assert.assertEquals(driver.getTitle(), "Swag Labs");  
    }
	//Title unverified 
    public void invalidCredentials() {
    	String standard_user = prop.getProperty("standard_user");
		  username.sendKeys(standard_user);
		  String passwords = prop.getProperty("passwords");
		  password.sendKeys(passwords);
		  login.click();
		  Assert.assertEquals(driver.getTitle(), "Swag Labss");
    }
}

