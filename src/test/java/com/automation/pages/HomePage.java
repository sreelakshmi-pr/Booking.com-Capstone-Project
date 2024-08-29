package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@text=\"Not now\"]")
    WebElement notificationOffBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    WebElement loginCloseClick;

    public void openApplication(){
        notificationOffBtn.click();
        loginCloseClick.click();
    }
}
