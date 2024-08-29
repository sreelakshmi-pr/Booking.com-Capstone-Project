package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class HomeSteps {
    HomePage homePage = new HomePage();
    @Given("user opens application")
    public void user_opens_application() {
       homePage.openApplication();
    }

    @Then("verify user is on home screen")
    public void verify_user_is_on_home_screen() {
        Assert.assertTrue(homePage.verifyHomePageIsDisplayed());
    }

}
