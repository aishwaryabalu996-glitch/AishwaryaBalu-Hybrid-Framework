package utils;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks{
        protected static WebDriver driver;
        protected static ExtentTest test;

        @BeforeMethod
        public void setUp() {

            // Start Extent Report
            ExtentReport.startReport();

            // Create test
            test = ExtentReport.extent.createTest("Place Order Test");

            int timeout = PropertyLoader.getIntProperty("timeout");

            driver = Driver.initializeDriver(timeout);

            driver.get(PropertyLoader.getProperty("url"));

            test.info("Browser launched");
            test.info("Application opened");
        }

        @AfterMethod
        public void tearDown(ITestResult result) {

            if (result.getStatus() == ITestResult.SUCCESS) {

                test.pass("Test passed successfully");

            } else if (result.getStatus() == ITestResult.FAILURE) {

                test.fail("Test failed");

            } else {

                test.skip("Test skipped");
            }

            if (driver != null) {
                driver.quit();
            }
            ExtentReport.endReport();
        }
}


