package com.tihonov;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestCalc {

    @Test
    public void testSubtract() {
        CalculatorPage calculatorPage = new CalculatorPage();
        calculatorPage.openPage();
        calculatorPage.scrollToDown();
        calculatorPage.getSelectBuild().sendKeys("Prototype");
        calculatorPage.getField1().sendKeys("2");
        calculatorPage.getField2().sendKeys("3");
        calculatorPage.getSelectOperation().sendKeys("Subtract");
        calculatorPage.getCalculateButton().click();
        assertThat(calculatorPage.getAnswerField().getAttribute("value"), is("-1"));
        calculatorPage.closePage();
    }

    @Test
    public void testConcatenate() {
        CalculatorPage calculatorPage = new CalculatorPage();
        calculatorPage.openPage();
        calculatorPage.scrollToDown();
        calculatorPage.getSelectBuild().sendKeys("Prototype");
        calculatorPage.getField1().sendKeys("gs");
        calculatorPage.getField2().sendKeys("bu");
        calculatorPage.getSelectOperation().sendKeys("Concatenate");
        calculatorPage.getCalculateButton().click();
        assertThat(calculatorPage.getAnswerField().getAttribute("value"), is("gsbu"));
        calculatorPage.closePage();
    }

    @Test
    public void testSubmit() {
        RandomNumberPage randomNumberPage = new RandomNumberPage();
        randomNumberPage.openPage();
        randomNumberPage.scrollToDown();
        randomNumberPage.getBuildNumber().sendKeys("Demo");
        randomNumberPage.getRollDiceButton().click();
        WebDriverWait wait = new WebDriverWait(randomNumberPage.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(randomNumberPage.getNumberGuess()));
        randomNumberPage.getNumberGuess().sendKeys("string");
        randomNumberPage.getSubmitButton().click();
        assertThat(randomNumberPage.getFeedbackLabel().isDisplayed(), is(true));
        assertThat(randomNumberPage.getFeedbackLabel().getText(), is("string: Not a number!"));
        randomNumberPage.closePage();
    }

}
