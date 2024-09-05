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

    @When("user clicks first hotel")
    public void user_clicks_first_hotel() {
        hotelPage.clickOnFirstHotel();
    }
    @Then("verify user is on hotel details page")
    public void verify_user_is_on_hotel_details_page() {
       Assert.assertTrue(hotelPage.hotelDetailsPage());
    }
    @When("user clicks on see availability button")
    public void user_clicks_on_see_availability_button() {
        hotelPage.clickOnAvailabilityBtn();
    }
    @Then("verify user is on reservation page")
    public void verify_user_is_on_reservation_page() {
        Assert.assertTrue(hotelPage.reservationPage());
    }
    @When("user select and customise the hotel")
    public void user_select_and_customise_the_hotel() {

        hotelPage.selectAndCustomiseHotel();
    }
    @When("user clicks on reserve button")
    public void user_clicks_on_reserve_button() {
        hotelPage.clickOnReserveBtn();
    }
    @Then("verify user is on fill information page")
    public void verify_user_is_on_fill_information_page() {
        Assert.assertTrue(hotelPage.fillInfoPage());
    }
    @When("fill the information")
    public void fill_the_information() {
        hotelPage.fillInfo();
    }
    @When("user clicks on next step")
    public void user_clicks_on_next_step() {
        hotelPage.clickOnNextStep();
    }
    @Then("Verify user is on booking overview page")
    public void verify_user_is_on_booking_overview_page() {
        Assert.assertTrue(hotelPage.bookingReviewPage());
    }

    @And("user clicks on sort")
    public void userClicksOnSort() {
        hotelPage.clickOnSort();
    }

    @And("user select price low to high sorting")
    public void userSelectPriceLowToHighSorting() {
        hotelPage.clickOnPriceHighToLow();
    }

    @Then("verify price is in ascending order")
    public void verifyPriceIsInAscendingOrder() {
        Assert.assertTrue(hotelPage.priceIsInAscendingOrder());
    }

    @And("user clicks on filter")
    public void userClicksOnFilter() {
        hotelPage.clickOnFilter();
    }

    @And("user select free cancellation")
    public void userSelectFreeCancellation() {
        hotelPage.selectFreeCancellation();

    }

    @Then("verify the displayed hotels have the option of free cancellation")
    public void verifyTheDisplayedHotelsHaveTheOptionOfFreeCancellation() {
        Assert.assertTrue(hotelPage.hotelsHaveFreeCancellationOption());
    }

    @And("update location in to {string}")
    public void updateLocationInTo(String loc) {
        hotelPage.updateLocation(loc);

    }

    @And("clicks on search button")
    public void clicksOnSearchButton() {
        hotelPage.clickOnUpdateSearchBtn();
    }

    @Then("verify the location is updated with {string}")
    public void verifyTheLocationIsUpdatedWith(String loc) {
        Assert.assertTrue(hotelPage.searchBoxIsUpdated(loc));

    }


}
