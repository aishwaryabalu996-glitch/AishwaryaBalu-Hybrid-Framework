package org;

import utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

        private final By deliveryAddress =
                By.xpath("//ul[@id='address_delivery']");

        private final By orderComment =
                By.xpath("//textarea[@name='message']");

        private final By placeOrder =
                By.xpath("//a[contains(normalize-space(),'Place Order')]");

        public CheckoutPage(WebDriver driver) {
            super(driver);
        }

        public boolean isAddressDisplayed() {
            return isDisplayed(deliveryAddress);
        }

        public String getDeliveryAddress() {
            return getText(deliveryAddress);
        }

        public CheckoutPage enterOrderComment() {
            enterText(
                    orderComment,
                    "Please deliver the order safely."
            );
            return this;
        }

        public PaymentPage clickPlaceOrder() {
            click(placeOrder);
            return new PaymentPage(driver);
        }
    }

