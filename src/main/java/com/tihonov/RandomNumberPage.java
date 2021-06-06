package com.tihonov;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RandomNumberPage {
    public final static String URL = "https://testsheepnz.github.io/random-number.html";
    private WebDriver driver;

    public RandomNumberPage() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","chromedriver");
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "buildNumber")
    private WebElement buildNumber;

    @FindBy(id = "rollDiceButton")
    private WebElement rollDiceButton;

    @FindBy(id = "numberGuess")
    private WebElement numberGuess;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    @FindBy(id = "feedbackLabel")
    private WebElement feedbackLabel;

    public void openPage() {
        driver.get(URL);
    }

    public void closePage() {
        driver.close();
    }

    public void scrollToDown() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public WebElement getBuildNumber() {
        return buildNumber;
    }

    public WebElement getRollDiceButton() {
        return rollDiceButton;
    }

    public WebElement getNumberGuess() {
        return numberGuess;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getFeedbackLabel() {
        return feedbackLabel;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
