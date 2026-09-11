package org;

import utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

        private final By viewCart =
                By.xpath("//u[text()='View Cart']");

        private final By cartProduct =
                By.xpath("//td[@class='cart_description']");

        private final By proceedToCheckout =
                By.xpath("//a[contains(text(),'Proceed To Checkout')]");

        public CartPage(WebDriver driver) {
            super(driver);
        }

        public void clickViewCart() {
            clickWithJavaScript(viewCart);
        }

        public boolean isProductDisplayed() {
            return isDisplayed(cartProduct);
        }

        public CheckoutPage clickProceedToCheckout() {
            click(proceedToCheckout);
            return new CheckoutPage(driver);
        }
    }

