package org.smallworld.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;


public class Base {

    public static WebDriver driver;

    public ExtentReports extent;

    public static ExtentTest scenarioDef;
    public static ExtentTest features;
    public static String reportLocation = "src/";


    public static WebDriver getDriver() throws IOException {


        String WebBrowser = ExcelDriven_XLSX.readExcelData("Testdata", "Basic", "Browser").get("Value").toString();
        String Proxy = ExcelDriven_XLSX.readExcelData("Testdata", "Basic", "Proxy").get("Value").toString();
        String main_drive = ExcelDriven_XLSX.readExcelData("Testdata", "Basic", "drive").get("Value");
        String drive_location = ExcelDriven_XLSX.readExcelData("Testdata", "Basic", "folder_Location").get("Value").toString();
        System.out.println(main_drive + File.separator + drive_location);
        System.out.println(Proxy);
        System.out.println(WebBrowser);
        if (WebBrowser.equalsIgnoreCase("Google Chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (WebBrowser.equalsIgnoreCase("Fire Fox")) {

            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        } else if (WebBrowser.equalsIgnoreCase("Internet Explorer")) {

            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
