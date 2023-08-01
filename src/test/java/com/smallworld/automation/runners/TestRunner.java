package com.smallworld.automation.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.smallworld.automation.utils.Base;
import org.smallworld.automation.utils.folderOptions;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "org.smallworld.automation.stepdefinitions", // Location of your step definitions
        plugin = {"pretty", "html:target/cucumber-reports",} // Plugins for reporting (optional)
        )

public class TestRunner {

    public static WebDriver driver;

    @BeforeClass
    public static void deleteFiles() throws IOException {
        folderOptions folder = new folderOptions();
        folder.deleteScreenShotImages();
        System.out.println("Previous screenshots deleted");
        System.out.println("Open browser");
        driver= Base.getDriver();
        System.out.println("Browser initiated: "+driver);

    }

    @AfterClass
    public static void TearDown(){
        System.out.println("Close browser");
        Base.driver.quit(); //quit browser
    }



}
