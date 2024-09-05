package com.automation.pages;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.datatransfer.StringSelection;

public class CarRentalPage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@text=\"Car rental\"]")
    WebElement carRental;
    public void clickOnCarRental() {
        carRental.click();
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Enter a pick-up location\"]")
    WebElement loc1;

    @FindBy(xpath = "//android.widget.EditText[@text='Pickup location']")
    WebElement loc2;

    String clickOnFirstLoc = "(//androidx.recyclerview.widget.RecyclerView//android.widget.LinearLayout//android.widget.TextView[contains(@text,'%s')])[1]";
    public void enterPickUpLocation(String loc) {
        loc1.click();
        waitForElementToBeVisible(loc2);
        loc2.sendKeys(loc);

        String loc1 = String.format(clickOnFirstLoc, loc);
        WebElement firstPlace = driver.findElement(By.xpath(loc1));
        waitForElementToBeVisible(firstPlace);
        firstPlace.click();

    }
    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,\"Pick-up date\")]")
    WebElement dateBtn;

    @FindBy(xpath = "//android.widget.Button[@text=\"Select dates\"]")
    WebElement selectDateBtn;
    public void selectDates(String pickUpDate, String dropOffDate) {

        dateBtn.click();
        WebElement calender = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.booking:id/calendar_month_list\"]"));
        waitForElementToBeClickable(calender);

        String dateString = String.format("(//android.view.View[contains(@content-desc,'%s')])[1]", pickUpDate);
        dateSelection(dateString, calender);

        String dateString2 = String.format("(//android.view.View[contains(@content-desc,'%s')])[1]", dropOffDate);
        dateSelection(dateString2, calender);

        selectDateBtn.click();
    }

    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,\"Pick-up time\")]")
    WebElement pickUpTime1;
    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,\"Drop-off time\")]")
    WebElement dropOffTime1;
    public void selectTime(String pickUpTime, String dropOffTime) {
        pickUpTime1.click();
        String p=String.format("//android.widget.TextView[contains(@text,'%s')]",pickUpTime);
        driver.findElement(By.xpath(p)).click();

        dropOffTime1.click();
        String d=String.format("//android.widget.TextView[contains(@text,'%s')]",dropOffTime);
        driver.findElement(By.xpath(d)).click();


    }

    @FindBy(xpath = "(//android.widget.TextView[@text=\"Search\"])[1]")
    WebElement searchBtn;

    public void clickOnSearch() {

        searchBtn.click();
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Sort\"]")
    WebElement sortBtn;
    @FindBy(xpath = "(//android.widget.TextView[contains(@text,\"US$\")])[1]")
    WebElement carPrice;
    public boolean carPageIsDisplayed() {
        return sortBtn.isDisplayed() && carPrice.isDisplayed();
    }

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    WebElement okBtn;
    @FindBy(xpath = "//android.widget.TextView[@text='Enter your pick-up location']")
    WebElement errMsg;

    public boolean alertDisplayed() {
        return okBtn.isDisplayed() && errMsg.isDisplayed();
    }

    @FindBy(xpath = "//android.view.View[contains(@content-desc,\"return the car to the same location\")]")
    WebElement offReturnCarToSameLoc;
    public void clickOnReturnToSameLoc() {
        offReturnCarToSameLoc.click();
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Enter a drop-off location\"]")
    WebElement dropOffLoc;
    public boolean dropOffIsDisplayed() {
        return dropOffLoc.isDisplayed();
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Enter a drop-off location\"]")
    WebElement loc3;

    @FindBy(xpath = "//android.widget.EditText[@text='Drop-off location']")
    WebElement loc4;

     public void enterDropOffLoc(String loc) {
         waitForElementToBeVisible(loc3);
        loc3.click();
        waitForElementToBeVisible(loc4);
        loc4.sendKeys(loc);

        String loc1 = String.format(clickOnFirstLoc, loc);
        WebElement firstPlace = driver.findElement(By.xpath(loc1));
        waitForElementToBeVisible(firstPlace);
        firstPlace.click();

    }

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]")
    WebElement firstCar;
    public void selectFirstCar() {

        firstCar.click();
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Car Details\"]")
    WebElement carDetailsText;
    public boolean carDetailsPage() {
        return carDetailsText.isDisplayed();
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Next step\"]")
    WebElement nextStep;
    public void clickOnNextStep() {
        nextStep.click();

    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Protection options\"]")
    WebElement protectionPage;
    public boolean protectionOptionPage() {
       return protectionPage.isDisplayed();
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Go to book without Full Protection\"]")
    WebElement withOutProtection;
    public void clickOnBookWithOutProtection() {

        withOutProtection.click();
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Booking summary\"]")
    WebElement bookingSummaryText;
    public boolean bookingSummeryPage() {
        return bookingSummaryText.isDisplayed();
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Main driver details\"]")
    WebElement driverDetailsPageText;
    public boolean driverDetailsPage() {
        return driverDetailsPageText.isDisplayed();
    }

    @FindBy(xpath = "(//android.widget.TextView[@content-desc=\"First name required\"]/following-sibling::android.widget.EditText)[1]")
    WebElement fName;

    @FindBy(xpath = "(//android.widget.TextView[@content-desc=\"Last name required\"]/following-sibling::android.widget.EditText)[1]")
    WebElement lName;

    @FindBy(xpath = "(//android.widget.TextView[@content-desc=\"Email address required\"]/following-sibling::android.widget.EditText)[1]")
    WebElement email;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Country/Region code required\"]")
    WebElement country;

    @FindBy(xpath = "//android.view.View[@content-desc=\"The rest of the phone number required\"]//android.widget.EditText")
    WebElement phNo;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Address required\"]/following-sibling::android.widget.EditText")
    WebElement address;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"City required\"]/following-sibling::android.widget.EditText")
    WebElement city;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Zip code required\"]/following-sibling::android.widget.EditText")
    WebElement zipCode;
    public void fillDriverDetails() {

        fName.sendKeys(ConfigReader.getConfigValue("f.name"));
        lName.sendKeys(ConfigReader.getConfigValue("l.name"));
        email.sendKeys(ConfigReader.getConfigValue("email"));

        //select country to add phone number
        country.click();
        String c=String.format("//android.widget.TextView[contains(@text,'%s')]", ConfigReader.getConfigValue("country"));
        driver.findElement(By.xpath(c)).click();
        phNo.sendKeys(ConfigReader.getConfigValue("phNo"));

        //scroll
        int w = driver.manage().window().getSize().getWidth();
        int h = driver.manage().window().getSize().getHeight();
        scrollOrSwipe(w / 2, h / 2+h/6 , w / 2, 0);

        fName.sendKeys(ConfigReader.getConfigValue("f.name"));
        lName.sendKeys(ConfigReader.getConfigValue("l.name"));
        country.click();
        driver.findElement(By.xpath(c)).click();
        phNo.sendKeys(ConfigReader.getConfigValue("phNo"));

        address.sendKeys(ConfigReader.getConfigValue("address"));
        city.sendKeys(ConfigReader.getConfigValue("city"));
        zipCode.sendKeys(ConfigReader.getConfigValue("zipCode"));

    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Payment \"]")
    WebElement paymentText;
    public boolean paymentPage() {
        return paymentText.isDisplayed();
    }


    @FindBy(xpath = "//android.widget.TextView[@text=\"Go to book with Full Protection\"]")
    WebElement withProtection;
    public void clickOnBookWithProtection() {
         withProtection.click();
    }

    @FindBy(xpath = "(//android.widget.TextView[@text=\"Car rental price\"]/following-sibling::android.widget.TextView)[1]")
    WebElement carRentalPrice;
    @FindBy(xpath = "(//android.widget.TextView[@text=\"Full Protection\"]/following-sibling::android.widget.TextView)[1]")
    WebElement fullProtectionPrice;
    @FindBy(xpath = "(//android.widget.TextView[@text=\"Total rental price\"]/following-sibling::android.widget.TextView[@text=\"approx.\"]/following-sibling::android.widget.TextView)[1]")
    WebElement totalPrice;
    public boolean protectionAmountAddedWithRentalPrice() {
        System.out.println(carRentalPrice.getText().substring(3));
        System.out.println(fullProtectionPrice.getText().substring(3));
        System.out.println("total price : "+totalPrice.getText().substring(3));

        Double carRentalPrice1=Double.parseDouble(carRentalPrice.getText().substring(3));
        Double fullProtectionPrice1=Double.parseDouble(fullProtectionPrice.getText().substring(3));
        Double totalPrice1=Double.parseDouble(totalPrice.getText().substring(3));

        Double calculatedPrice=carRentalPrice1+fullProtectionPrice1;
        System.out.println("total price we calculated : "+calculatedPrice);
        return totalPrice1.equals(calculatedPrice);


    }
}
