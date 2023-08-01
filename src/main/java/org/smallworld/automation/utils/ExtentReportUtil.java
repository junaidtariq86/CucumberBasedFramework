package org.smallworld.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;




public class ExtentReportUtil extends Base {

    String fileName = reportLocation + "ExtentSparkReporter.html";


    public void ExtentReport() throws IOException, InterruptedException {
        extent = new ExtentReports();

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Test report for Selenium Basic");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test report");

        extent.attachReporter(htmlReporter);

    }

    public void ExtentReportScreenshot() throws Exception {
    	String snap_loc = snap_shot.takeSnapShot(driver);
    	System.out.println("==========================Test=====================");
    	System.out.println(snap_loc);
        scenarioDef.fail("details").addScreenCaptureFromPath(snap_loc);
    }
    public void FlushReport(){
        extent.flush();
    }




}
