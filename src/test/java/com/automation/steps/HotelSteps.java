package com.automation.steps;

import com.automation.pages.HotelPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HotelSteps {

    HotelPage hotelPage = new HotelPage();

    @When("user enters location {string}")
    public void user_enters_location(String loc) throws InterruptedException {
        hotelPage.enterLocation(loc);

    }


    @And("user select checkIn date {string} and checkOut date {string}")
    public void userSelectCheckInDateAndCheckOutDate(String checkInDate, String checkOutDate) {
        hotelPage.selectCheckInDate(checkInDate,checkOutDate);
    }


    @Then("user clicks on search")
    public void user_clicks_on_search() {

        hotelPage.clickOnSearch();
    }

    @Then("verify user is on hotels displayed page")
    public void verify_user_is_on_hotels_displayed_page() {

        Assert.assertTrue(hotelPage.hotelSearchPageIsDisplayed());
    }
    @And("select number of rooms {string} and adults {string}")
    public void selectNumberOfRoomsAndAdults(String room, String adult) {
        hotelPage.selectNumberOfGuestsAndNumberOfRooms(room, adult);
    }

    @When("user clicks on search button")
    public void userClicksOnSearchButton() {
        hotelPage.clickOnSearch();
    }

    @Then("verify alert is displayed")
    public void verifyAlertIsDisplayed() {
        Assert.assertTrue(hotelPage.alertDisplayed());
    }

    @When("first hotel added to wishlist")
    public void firstHotelAddedToWishlist() {
        hotelPage.addHotelToWishlist();
    }

    @And("go to wishlist")
    public void goToWishlist() {
        hotelPage.goToWishlistPage();
    }

    @And("user clicks select date")
    public void userClicksSelectDate() {
        hotelPage.selectDate();
    }

    @Then("verify user is on hotels is added to wishlist")
    public void verifyUserIsOnHotelsIsAddedToWishlist() {
        Assert.assertTrue(hotelPage.verifyHotelIsInWishlist());
    }
}
