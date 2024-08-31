package com.automation.pages;

import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasePage {

    AppiumDriver driver;
    WebDriverWait wait;

    BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public boolean isPresent(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isPresents(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        }
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElementIfPresent(WebElement element) {
        if (isPresent(element)) {
            element.click();
        }
    }


    public void scrollOrSwipe(int startX, int startY, int endX, int endY) {
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(1)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }



    public  void zoom(int startX, int startY){
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
        Sequence sequence1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startX+50, startY+50 ))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(),startX+1500, startY+1500 ))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        Sequence sequence2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startX, startY ))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2,Duration.ofSeconds(2)))
                .addAction(finger2.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(),startX-100, startY-100 ))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg())) ;
        driver.perform(Arrays.asList(sequence1, sequence2));
    }

    public  void dateSelection(String dateString,WebElement calender){

        boolean flag=true;
        do {
            try {
                WebElement date = driver.findElement(By.xpath(dateString));
                date.click();
                flag = false;

            } catch (Exception e) {
                int x = calender.getLocation().getX();
                int y = calender.getLocation().getY();
                int cardWidth = calender.getSize().getWidth();
                int cardHeight = calender.getSize().getHeight();

                scrollOrSwipe(x + cardWidth/2, y + cardHeight-1, x+cardWidth/2, y );

            }
        }while (flag);

    }



    }




