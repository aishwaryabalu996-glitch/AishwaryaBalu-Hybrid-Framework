package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;
import utils.PropertyLoader;

public class SignupPage extends BasePage {

        private final By name =
                By.xpath("//input[@data-qa='signup-name']");

        private final By email =
                By.xpath("//input[@data-qa='signup-email']");

        private final By signupButton =
                By.xpath("//button[@data-qa='signup-button']");

        public SignupPage(WebDriver driver) {
            super(driver);
        }

        public SignupPage enterName(String nameValue) {
            enterText(name, nameValue);
            return this;
        }

        public SignupPage enterEmail(String emailValue) {
            enterText(email, emailValue);
            return this;
        }

        public AccountCreationPage clickSignup() {
            click(signupButton);
            return new AccountCreationPage(driver);
        }

        public AccountCreationPage signup() {

            enterName(
                    PropertyLoader.getProperty("firstName") + " " +
                            PropertyLoader.getProperty("lastName")
            );

            enterEmail(
                    PropertyLoader.getProperty("username")
            );

            return clickSignup();
        }
    }