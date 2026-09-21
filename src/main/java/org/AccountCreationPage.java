package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;
import utils.PropertyLoader;

public class AccountCreationPage extends BasePage {
    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }
            public AccountCreationPage enterAccountDetails() {

                enterText(
                        By.id("first_name"),
                        PropertyLoader.getProperty("firstName")
                );

                enterText(
                        By.id("last_name"),
                        PropertyLoader.getProperty("lastName")
                );

                enterText(
                        By.id("password"),
                        PropertyLoader.getProperty("password")
                );

                enterText(
                        By.id("address1"),
                        PropertyLoader.getProperty("address")
                );

                enterText(
                        By.id("state"),
                        PropertyLoader.getProperty("state")
                );

                enterText(
                        By.id("city"),
                        PropertyLoader.getProperty("city")
                );

                enterText(
                        By.id("zipcode"),
                        PropertyLoader.getProperty("zipCode")
                );

                enterText(
                        By.id("mobile_number"),
                        PropertyLoader.getProperty("mobileNumber")
                );
                System.out.println("First Name: " +
                        getAttribute(By.id("first_name"), "value"));

                System.out.println("Last Name: " +
                        getAttribute(By.id("last_name"), "value"));

                System.out.println("Mobile: " +
                        getAttribute(By.id("mobile_number"), "value"));

                return this;
            }
        }

