package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks {

        protected static WebDriver driver;

        @BeforeMethod
        public void setUp() {

            int timeout = PropertyLoader.getIntProperty("timeout");

            driver = Driver.initializeDriver(timeout);

            driver.get(
                    PropertyLoader.getProperty("url")
            );
        }

        @AfterMethod
        public void tearDown() {

            if (driver != null) {

                driver.quit();

            }
        }
    }
