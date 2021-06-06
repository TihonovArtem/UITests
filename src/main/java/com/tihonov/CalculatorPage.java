package com.tihonov;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    public final static String URL = "https://testsheepnz.github.io/BasicCalculator.html";
    private WebDriver driver;

    public CalculatorPage() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","chromedriver");
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "selectBuild")
    private WebElement selectBuild;

    @FindBy(id = "number1Field")
    private WebElement field1;

    @FindBy(id = "number2Field")
    private WebElement field2;

    @FindBy(id = "selectOperationDropdown")
    private WebElement selectOperation;

    @FindBy(id = "calculateButton")
    private WebElement calculateButton;

    @FindBy(id = "numberAnswerField")
    private WebElement answerField;

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

    public WebElement getSelectBuild() {
        return selectBuild;
    }

    public WebElement getField1() {
        return field1;
    }

    public WebElement getField2() {
        return field2;
    }

    public WebElement getSelectOperation() {
        return selectOperation;
    }

    public WebElement getCalculateButton() {
        return calculateButton;
    }

    public WebElement getAnswerField() {
        return answerField;
    }
}
