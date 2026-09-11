package org;

import utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

        // Locators
        private final By homeMenu =
                By.xpath("//a[text()=' Home']");

        private final By signupLoginMenu =
                By.xpath("//a[contains(text(),'Signup / Login')]");

        private final By productsButton =
                By.xpath("//a[text()=' Products']");

        private final By cartMenu =
                By.xpath("//a[contains(text(),'Cart')]");

        private final By loggedInUser =
                By.xpath("//a[contains(text(),'Logged in as')]");

        private final By logoutMenu =
                By.xpath("//a[text()=' Logout']");


        // Constructor
        public HomePage(WebDriver driver) {
            super(driver);
        }


        // Verify Home Page
        public boolean isHomePageDisplayed() {
            return isDisplayed(homeMenu);
        }


        // Click Home
        public HomePage clickHome() {
            click(homeMenu);
            return this;
        }


        // Click Signup / Login
        public LoginPage clickSignupLogin() {
            click(signupLoginMenu);
            return new LoginPage(driver);
        }


        // Click Products
        public ProductPage clickProducts() {
            click(productsButton);
            return new ProductPage(driver);
        }


        // Click Cart
        public CartPage clickCart() {
            click(cartMenu);
            return new CartPage(driver);
        }


        // Verify Login
        public boolean isLoggedIn() {
            return isDisplayed(loggedInUser);
        }


        // Logout
        public HomePage clickLogout() {
            click(logoutMenu);
            return this;
        }


        // Get Home Page Title
        public String getHomePageTitle() {
            return getTitle();
        }


        // Get Current URL
        public String getCurrentPageUrl() {
            return getCurrentUrl();
        }
    }