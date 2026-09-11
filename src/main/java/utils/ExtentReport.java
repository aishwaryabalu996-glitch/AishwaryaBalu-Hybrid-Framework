package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReport{

        public static ExtentReports extent;

        public static void startReport() {

            String folderPath = System.getProperty("user.dir")
                    + "\\test-output";

            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String reportPath = folderPath
                    + "\\ExtentReport.html";

            System.out.println(">>> REPORT PATH: " + reportPath);

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Application", "Automation Exercise");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "Aishwarya");
            extent.setSystemInfo("Browser", "Chrome");
        }

        public static void endReport() {

            if (extent != null) {

                System.out.println(">>> CALLING EXTENT.FLUSH()");

                extent.flush();

                System.out.println(">>> REPORT GENERATED");
            }
        }
    }





