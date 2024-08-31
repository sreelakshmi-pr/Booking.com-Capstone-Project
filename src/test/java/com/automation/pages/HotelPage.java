package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;
import java.util.List;


public class HotelPage extends BasePage {

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Enter your destination\"]")
    WebElement place1;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement place;

    String clickOnFirstLoc = "(//android.widget.TextView[contains(@text,'%s')])[1]";

    public void enterLocation(String loc) {

        place1.click();
        waitForElementToBeVisible(place);
        place.sendKeys(loc);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String loc1 = String.format(clickOnFirstLoc, loc);
        WebElement firstPlace = driver.findElement(By.xpath(loc1));
        firstPlace.click();

    }

    @FindBy(className = "android.widget.Button")
    WebElement selectDateBtn;

    public void selectCheckInDate(String checkInDate, String checkOutDate) {

        WebElement calender = driver.findElement(By.xpath("(//android.view.View[@resource-id=\"com.booking:id/month_custom_view\"])[2]"));
        waitForElementToBeClickable(calender);

        String dateString = String.format("//android.view.View[@content-desc='%s']", checkInDate);
        dateSelection(dateString, calender);

        String dateString2 = String.format("//android.view.View[@content-desc='%s']", checkOutDate);
        dateSelection(dateString2, calender);

        selectDateBtn.click();


    }

    @FindBy(xpath = "//android.view.View[@content-desc=\"Accommodation search box\"]/android.view.View/android.widget.Button")
    WebElement searchBtn;

    public void clickOnSearch() {
        searchBtn.click();
    }

    @FindBy(xpath = "//android.view.View[@resource-id=\"sr_list\"]/android.view.View[2]")
    WebElement fistHotel;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.booking:id/sr_topbar_frame\"]/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]")
    WebElement sortIcon;

    public boolean hotelSearchPageIsDisplayed() {
        waitForElementToBeVisible(fistHotel);
        return fistHotel.isDisplayed() && sortIcon.isDisplayed();
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"1 room, 2 adults, 0 children\"]")
    WebElement guestAndNumber;

    @FindBy(xpath = "(//android.widget.Button[@content-desc=\"Increase\"])[1]")
    WebElement addRooms;

    @FindBy(xpath = "(//android.widget.Button[@content-desc=\"Increase\"])[2]")
    WebElement addAdults;

    @FindBy(xpath = "(//android.widget.Button[@content-desc=\"Increase\"])[3]")
    WebElement addChild;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_stepper_value\" and @text=\"1\"]")
    WebElement roomCount;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_stepper_value\" and @text=\"2\"]")
    WebElement adultCount;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_stepper_value\" and @text=\"0\"]")
    WebElement childCount;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.booking:id/group_config_apply_button\"]")
    WebElement doneBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Select age\"]")
    WebElement clickOnChildAge;


    public void selectNumberOfGuestsAndNumberOfRooms(String room, String adult) {
        guestAndNumber.click();

        int room1 = Integer.parseInt(room);
        int adult1 = Integer.parseInt(adult);
//        int child1 = Integer.parseInt(child);

        int roomCount1 = Integer.parseInt(roomCount.getText());
        int adultCount1 = Integer.parseInt(adultCount.getText());
        int childCount1 = Integer.parseInt(childCount.getText());

        if (roomCount1 == room1) {
            System.out.println();
        } else {
            while (roomCount1 != room1) {
                addRooms.click();
                roomCount1++;
            }
        }

        if (adultCount1 == adult1) {
            System.out.println();
        } else {
            while (adultCount1 != adult1) {
                addAdults.click();
                adultCount1++;
            }
        }

//        if (childCount1 == child1) {
//            System.out.println();
//        } else {
//            while (childCount1 != child1) {
//                addChild.click();
//                childCount1++;
//            }
//        }
//        clickOnChildAge.click();
//
//            WebElement calender = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.booking:id/age_picker_view\"]"));
//            waitForElementToBeClickable(calender);
//
//            boolean flag=true;
//            do {
//                try {
//                    WebElement date = driver.findElement(By.xpath(String.format("//android.widget.Button[@text=\"'%s' year old\"]",childAge)));
//                    date.click();
//                    flag = false;
//
//                } catch (Exception e) {
//                    int x = calender.getLocation().getX();
//                    int y = calender.getLocation().getY();
//                    int cardWidth = calender.getSize().getWidth();
//                    int cardHeight = calender.getSize().getHeight();
//
//                    scrollOrSwipe(x + cardWidth/2, y + cardHeight-1, x+cardWidth/2, y+cardHeight-50 );
//
//                }
//            }while (flag);
        doneBtn.click();
        }
        @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.booking:id/button_positive\"]")
        WebElement okBtn;
        @FindBy(xpath = "//android.widget.TextView[@text='Please enter your destination']")
        WebElement errMsg;

    public boolean alertDisplayed() {
        return okBtn.isDisplayed() && errMsg.isDisplayed();
    }

    @FindBy(xpath = "//android.view.View[@resource-id=\"sr_list\"]/android.view.View[1]//android.widget.ImageView")
    WebElement wishlistIcon;
    @FindBy(xpath = "(//android.view.View[@resource-id=\"sr_list\"]/android.view.View[1]//android.widget.TextView)[1]")
    WebElement hotelNameOnHotelSearchPage;

    public void addHotelToWishlist() {
        String s=hotelNameOnHotelSearchPage.getAttribute("text");
        System.out.println(s);
        ConfigReader.setConfigValue("hotel_name",s);
        wishlistIcon.click();
    }

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    WebElement backBtn;
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Saved\"]")
    WebElement wishlistPageIcon;
    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[4]")
    WebElement clickOnNextTrip;
    public void goToWishlistPage() {
           backBtn.click();
           wishlistPageIcon.click();
           clickOnNextTrip.click();
    }

    @FindBy(xpath = "(//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]//android.widget.TextView)[1]")
    WebElement hotelNameOnWishlistPage;
    public boolean verifyHotelIsInWishlist() {
        String a=ConfigReader.getConfigValue("hotel_name");
        System.out.println(a);
        return a.equals(hotelNameOnWishlistPage.getAttribute("text"));
    }

    public void selectDate() {
        selectDateBtn.click();
    }
}


