package org;

import utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

        private final By email =
                By.xpath("//input[@data-qa='login-email']");

        private final By password =
                By.xpath("//input[@data-qa='login-password']");

        private final By loginButton =
                By.xpath("//button[@data-qa='login-button']");


        public LoginPage(WebDriver driver) {
            super(driver);
        }


        public LoginPage enterEmail(String emailId) {
            enterText(email, emailId);
            return this;
        }


        public LoginPage enterPassword(String pwd) {
            enterText(password, pwd);
            return this;
        }


        public HomePage clickLogin() {
            click(loginButton);
            return new HomePage(driver);
        }
    }


