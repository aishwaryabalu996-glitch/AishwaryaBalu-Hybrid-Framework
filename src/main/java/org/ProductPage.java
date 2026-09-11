package org;

import utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

        private final By firstAddToCart =
                By.xpath("(//a[contains(@class,'add-to-cart')])[1]");

        private final By continueShopping =
                By.xpath("//button[contains(text(),'Continue Shopping')]");

        public ProductPage(WebDriver driver) {
            super(driver);
        }

        public ProductPage selectProduct() {

            waitForElement(firstAddToCart);

            return this;
        }

        public ProductPage addProductToCart() {

            clickWithJavaScript(firstAddToCart);

            return this;
        }

        public ProductPage clickContinueShopping() {

            click(continueShopping);

            return this;
        }
    }

