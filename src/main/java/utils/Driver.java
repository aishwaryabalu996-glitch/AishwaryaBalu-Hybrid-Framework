package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class Driver {
    protected WebDriver driver;
    public static WebDriver initializeDriver(int timeout) {

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(
                    Duration.ofSeconds(timeout)
            );

            return driver;
        }
    }

