package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@text=\"Not now\"]")
    WebElement notificationOffBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    WebElement loginCloseClick;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.booking:id/facet_entry_point_item_label\" and @text=\"Stays\"]")
    WebElement staysBtn;

    public void openApplication(){
        notificationOffBtn.click();
        loginCloseClick.click();
    }

    public boolean verifyHomePageIsDisplayed(){
        return isPresent(staysBtn);
    }
}
