package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;
import java.util.*;


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
        String s = hotelNameOnHotelSearchPage.getAttribute("text");
        System.out.println(s);
        ConfigReader.setConfigValue("hotel_name", s);
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
        String a = ConfigReader.getConfigValue("hotel_name");
        System.out.println(a);
        return a.equals(hotelNameOnWishlistPage.getAttribute("text"));
    }

    public void selectDate() {
        selectDateBtn.click();
    }

    public void clickOnFirstHotel() {
        fistHotel.click();
    }

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.booking:id/select_room_cta\"]")
    WebElement selectRoomBtn;

    public boolean hotelDetailsPage() {
        return selectRoomBtn.isDisplayed();
    }

    public void clickOnAvailabilityBtn() {
        selectRoomBtn.click();
    }

    @FindBy(xpath = "//android.widget.Button[@text=\"Reserve\"]")
    WebElement reserveBtn;

    public boolean reservationPage() {
//        waitForElementToBeClickable(reserveBtn);
        return reserveBtn.isDisplayed();
    }

    @FindBy(className = "android.widget.Button")
    WebElement selectRoom; //select btn
    @FindBy(xpath = "//androidx.compose.ui.viewinterop.ViewFactoryHolder/android.view.ViewGroup/android.view.View/android.view.View/android.widget.Button")
    WebElement selectBtn;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Select and customize\"]")
    WebElement selectAndCustomise;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.booking:id/main_action\"]")
    WebElement nextStep;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.booking:id/room_list_marketing_rewards_card\"]")
    WebElement oneFullBed;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.booking:id/main_action\"]")
    WebElement nextStep2;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Confirm\"]")
    WebElement confirmBtn;

    public void selectAndCustomiseHotel() {

        selectBtn.click();

    }

    public void clickOnReserveBtn() {


        try {
            nextStep.isDisplayed();
            nextStep.click();

            if (nextStep2.isDisplayed()) {
                nextStep2.click();
            }
            waitForElementToBeVisible(confirmBtn);
            confirmBtn.click();
            reserveBtn.click();
        } catch (Exception e) {

            reserveBtn.click();
            System.out.println("customisation not exist");
        }
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Fill in your info\"]")
    WebElement fillInfoText;

    public boolean fillInfoPage() {
        return fillInfoText.isDisplayed();
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_container_label\" and @text=\"First Name *\"]")
    WebElement fstName;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_container_label\" and @text=\"Last Name *\"]")
    WebElement lstName;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_container_label\" and @text=\"Email Address *\"]")
    WebElement email;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_container_label\" and @text=\"Mobile Phone *\"]")
    WebElement phoneNum;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Leisure\"]")
    WebElement purposeOfTrip;

    public void fillInfo() {
        fstName.sendKeys(ConfigReader.getConfigValue("first.name"));
        lstName.sendKeys(ConfigReader.getConfigValue("last.name"));
        email.sendKeys(ConfigReader.getConfigValue("email"));
        phoneNum.sendKeys(ConfigReader.getConfigValue("phone.num"));
        purposeOfTrip.click();

    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Next step\"]")
    WebElement nextStep3;

    public void clickOnNextStep() {
        nextStep3.click();
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Booking Overview\"]")
    WebElement bookingOverview;
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//androidx.compose.ui.viewinterop.ViewFactoryHolder[1]//android.widget.TextView")
    WebElement hotelNameInOverviewPage;

    public boolean bookingReviewPage() {
        String s = hotelNameInOverviewPage.getAttribute("text");
        System.out.println(s);
        System.out.println(ConfigReader.getConfigValue("hotel_name"));
        return bookingOverview.isDisplayed() && s.equals(ConfigReader.getConfigValue("hotel_name"));

    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Sort\"]")
    WebElement sort;

    public void clickOnSort() {
        sort.click();
    }

    @FindBy(xpath = "//android.widget.CheckedTextView[@text=\"Price (low to high)\"]")
    WebElement priceHighToLow;

    public void clickOnPriceHighToLow() {
        priceHighToLow.click();
    }

    public boolean priceIsInAscendingOrder() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            List<WebElement> priceList = driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'Price')]/following-sibling::android.widget.TextView[1]"));
            for (WebElement price : priceList) {
                String p = price.getText().substring(12);

                try {
                    System.out.println(p.trim());
                    li.add(Integer.parseInt(p.replaceAll("[^0-9]", "")));
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    System.err.println("Failed to parse integer from: " + p);
                }

            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int w = driver.manage().window().getSize().getWidth();
            int h = driver.manage().window().getSize().getHeight();
            scrollOrSwipe(w / 2, h / 2 + h / 4, w / 2, 0);

        }
        System.out.println("Original list (low to high) \n" + li);

        List<Integer> copy_li = new ArrayList<>(li);
        System.out.println("Copy of original list(low to high) \n " + copy_li);

        Collections.sort(copy_li);
        System.out.println("Sorted list (low to high) \n" + copy_li);

        return li.equals(copy_li);
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Filter\"]")
    WebElement filter;

    public void clickOnFilter() {
        filter.click();

    }

    @FindBy(xpath = "//android.view.View[contains(@content-desc,\"Free cancellation\")]")
    WebElement freeCancellation;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Show results\"]")
    WebElement showResults;

    public void selectFreeCancellation() {
        boolean flag = true;
        while (flag) {

            int w = driver.manage().window().getSize().getWidth();
            int h = driver.manage().window().getSize().getHeight();
            scrollOrSwipe(w / 2, h / 2 , w / 2, 0);

            try {
               freeCancellation.isDisplayed();
                flag=false;
            }catch (Exception e){
                System.out.println("not displayed");
            }

        }
        freeCancellation.click();
        waitForElementToBeVisible(showResults);
        showResults.click();
    }

    public boolean hotelsHaveFreeCancellationOption() {

        List<String> li = new ArrayList<>();

        for(int i = 0;i<6;i++) {

            List<WebElement> cancellationList = driver.findElements(By.xpath("//android.widget.TextView[@text=\"��Free cancellation\"]"));
            for (WebElement cancel : cancellationList) {
                System.out.println(cancel.getText());
                li.add(cancel.getText());
            }
            int w = driver.manage().window().getSize().getWidth();
            int h = driver.manage().window().getSize().getHeight();
            scrollOrSwipe(w / 2, h / 2 + h / 4, w / 2, 0);
        }
        boolean flag=true;
        for (String l:li){
            if(!l.contains("Free cancellation")){
                System.out.println(l);
                flag=false;
                break;
            }
        }
        return flag;
    }
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]/following-sibling::android.view.ViewGroup")
    WebElement searchBox;
    @FindBy(xpath = "(//android.widget.Button)[1]")
    WebElement searchBox2;
    @FindBy(xpath = "//android.widget.EditText")
    WebElement enterNewLocation;
    public void updateLocation(String loc) {
         searchBox.click();
         searchBox2.click();
         enterNewLocation.sendKeys(loc);
         String s = String.format("(//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]//android.widget.TextView[contains(@text,'%s')])[1]",loc);
         driver.findElement(By.xpath(s)).click();
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Search\"]")
    WebElement updateSearchBtn;
    public void clickOnUpdateSearchBtn() {
        updateSearchBtn.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @FindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Navigate up\"]/following-sibling::android.view.ViewGroup//android.widget.TextView)[1]")
    WebElement updatedLoc;
    public boolean searchBoxIsUpdated(String loc) {

      return updatedLoc.getText().equals(loc);

    }


}


