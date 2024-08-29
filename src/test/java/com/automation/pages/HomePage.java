package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@text=\"Not now\"]")
    WebElement notificationOffBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    WebElement loginCloseClick;

    @FindBy(xpath = "//android.widget.TextView[@text='Stays']")
    WebElement staysClick;

    @FindBy(xpath = "//android.widget.TextView[@text='Attractions']")
    WebElement attractionsClick;

    public void openApplication(){
        if(isPresent(notificationOffBtn)){
            notificationOffBtn.click();
        }
        if(isPresent(loginCloseClick)) {
            loginCloseClick.click();
        }
    }

    public boolean verifyHomePageIsDisplayed(){
        return isPresent(staysClick);
    }

    public void clickAttractions() {
        int startX = staysClick.getLocation().getX();
        int startY = staysClick.getLocation().getY();
        //scrollOrSwipe(startX,0,,0);
        attractionsClick.click();
    }
}
