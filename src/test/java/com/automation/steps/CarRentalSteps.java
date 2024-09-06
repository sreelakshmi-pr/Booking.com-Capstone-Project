package com.automation.steps;

import com.automation.pages.CarRentalPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CarRentalSteps {
    CarRentalPage carRentalPage=new CarRentalPage();

    @When("user clicks on car rental")
    public void userClicksOnCarRental() {
        carRentalPage.clickOnCarRental();
    }

    @And("user enters pick up location {string}")
    public void userEntersPickUpLocation(String loc) {
        carRentalPage.enterPickUpLocation(loc);
    }

    @And("user select pickup date {string} and dropOff date {string}")
    public void userSelectPickupDateAndDropOffDate(String pickUpDate, String dropOffDate) {
        carRentalPage.selectDates(pickUpDate,dropOffDate);
    }

    @Then("user clicks on search of car rental")
    public void userClicksOnSearchOfCarRental() {
        carRentalPage.clickOnSearch();
    }

    @And("verify user is on cars displayed page")
    public void verifyUserIsOnCarsDisplayedPage() {
        Assert.assertTrue(carRentalPage.carPageIsDisplayed());
    }

    @When("user clicks on search button of car page")
    public void userClicksOnSearchButtonOfCarPage() {
        carRentalPage.clickOnSearch();
    }

    @Then("verify alert is displayed on car Page")
    public void verifyAlertIsDisplayedOnCarPage() {
        Assert.assertTrue(carRentalPage.alertDisplayed());

    }

    @And("clicks on return to same location")
    public void clicksOnReturnToSameLocation() {
        carRentalPage.clickOnReturnToSameLoc();
    }

    @Then("verify drop off location textbox is displayed")
    public void verifyDropOffLocationTextboxIsDisplayed() {
        Assert.assertTrue(carRentalPage.dropOffIsDisplayed());
    }

    @And("user enters drop off location {string}")
    public void userEntersDropOffLocation(String loc) {
        carRentalPage.enterDropOffLoc(loc);
    }

    @When("user clicks on first car")
    public void userClicksOnFirstCar() {
        carRentalPage.selectFirstCar();

    }

    @Then("verify user is on car details page")
    public void verifyUserIsOnCarDetailsPage() {
        Assert.assertTrue(carRentalPage.carDetailsPage());
    }

    @When("user click on next step")
    public void userClickOnNextStep() {
        carRentalPage.clickOnNextStep();
    }

    @Then("verify user is on protection option page")
    public void verifyUserIsOnProtectionOptionPage() {
        Assert.assertTrue(carRentalPage.protectionOptionPage());
    }

    @When("clicks on book without protection")
    public void clicksOnBookWithoutProtection() {
        carRentalPage.clickOnBookWithOutProtection();

    }

    @Then("verify user is on booking summary page")
    public void verifyUserIsOnBookingSummaryPage() {
        Assert.assertTrue(carRentalPage.bookingSummeryPage());
    }

    @Then("verify user is on driver details page")
    public void verifyUserIsOnDriverDetailsPage() {
        Assert.assertTrue(carRentalPage.driverDetailsPage());

    }

    @When("user fills the driver details")
    public void userFillsTheDriverDetails() {
        carRentalPage.fillDriverDetails();

    }

    @Then("verify user is on payment page")
    public void verifyUserIsOnPaymentPage() {
        Assert.assertTrue(carRentalPage.paymentPage());

    }

    @And("user select pickup up time {string} and drop off time {string}")
    public void userSelectPickupUpTimeAndDropOffTime(String pickUpTime, String dropOffTime) {
        carRentalPage.selectTime(pickUpTime,dropOffTime);
    }

    @When("clicks on book with protection")
    public void clicksOnBookWithProtection() {
        carRentalPage.clickOnBookWithProtection();

    }

    @And("verify protection amount is added to total rental price")
    public void verifyProtectionAmountIsAddedToTotalRentalPrice() {
        Assert.assertTrue(carRentalPage.protectionAmountAddedWithRentalPrice());
    }

    @And("user select price lowest first")
    public void userSelectPriceLowestFirst() {
        carRentalPage.clickOnPriceLowestFirst();
    }

    @Then("verify price is in lowest first order")
    public void verifyPriceIsInLowestFirstOrder() {
        Assert.assertTrue(carRentalPage.priceLowestFirst());
    }

    @And("user select automatic")
    public void userSelectAutomatic() {
        carRentalPage.clickOnAutomatic();

    }

    @Then("verify displayed cars are a automatic")
    public void verifyDisplayedCarsAreAAutomatic() {
        Assert.assertTrue(carRentalPage.carsAreAutomatic());

    }

    @And("user select fully electric")
    public void userSelectFullyElectric() {
        carRentalPage.clickOnFullyElectric();

    }

    @Then("verify displayed cars are a fully electric")
    public void verifyDisplayedCarsAreAFullyElectric() {
        Assert.assertTrue(carRentalPage.carsAreFullyElectric());
    }

    @And("user select {string} seat")
    public void userSelectSeat(String seat) {
        carRentalPage.selectSeat(seat);

    }

    @Then("verify displayed cars are {string} seater")
    public void verifyDisplayedCarsAreSeater(String seat) {
       Assert.assertTrue(carRentalPage.carsAreWithSelectedSeat(seat));
    }
}
