package com.arbisoft.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.arbisoft.listeners.AllureListener;
import com.arbisoft.pageobjects.HomePage;
import com.arbisoft.setup.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({AllureListener.class})
public class HomeTestCases extends TestBase {

    HomePage homepage;


    public HomeTestCases(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homepage = new HomePage();
    }
  @Test(priority = 1)
  @Description("Select your place to get your order")
  @Epic("Ep001")
  @Feature("Valid Credentials")
  @Story("As a user I need to select my country to get my oder at my door step")
  @Step("My country to get my oder at my door step")
  @Severity(SeverityLevel.MINOR)
  public void validInputs(){
      homepage.validCredentials();

  }
  
  
  @Test(priority = 2)
  @Description("Select your place to get your order")
  @Epic("Ep001")
  @Feature("Invalid Credentials")
  @Story("As a user I need to select my country to get my oder at my door step")
  @Step("My country to get my oder at my door step")
  @Severity(SeverityLevel.CRITICAL)
  public void invalidInputs(){
      homepage.invalidCredentials();

  }
  
  @AfterMethod
  public void tearDown(){
	  driver.close();
  }
}

