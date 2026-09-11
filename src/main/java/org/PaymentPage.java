package org;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    private final By cardName =
            By.xpath("//input[@name='name_on_card']");

    private final By cardNumber =
            By.xpath("//input[@name='card_number']");

    private final By cvc =
            By.xpath("//input[@name='cvc']");

    private final By expiryMonth =
            By.xpath("//input[@name='expiry_month']");

    private final By expiryYear =
            By.xpath("//input[@name='expiry_year']");

    private final By payButton =
            By.xpath("//button[@id='submit']");

    private final By orderPlaced =
            By.xpath("//b[contains(text(),'Order Placed')]");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage enterCardName(String name) {
        enterText(cardName, name);
        return this;
    }

    public PaymentPage enterCardNumber(String number) {
        enterText(cardNumber, number);
        return this;
    }

    public PaymentPage enterCvc(String cvcValue) {
        enterText(cvc, cvcValue);
        return this;
    }

    public PaymentPage enterExpiryMonth(String month) {
        enterText(expiryMonth, month);
        return this;
    }

    public PaymentPage enterExpiryYear(String year) {
        enterText(expiryYear, year);
        return this;
    }

    public PaymentPage clickPayAndConfirm() {
        WebElement button = wait.until(
                ExpectedConditions.presenceOfElementLocated(payButton)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                button
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                button
        );

        return this;
    }

    public boolean isOrderPlaced() {
        return isDisplayed(orderPlaced);
    }
}

