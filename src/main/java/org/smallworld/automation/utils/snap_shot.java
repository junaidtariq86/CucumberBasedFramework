package org.smallworld.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class snap_shot {
	public static String takeSnapShot(WebDriver driver) throws Exception
		{
String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
TakesScreenshot ts = (TakesScreenshot) driver;
File source = ts.getScreenshotAs(OutputType.FILE);
String destination = System.getProperty("user.dir") + "/target/reports/Screenshots/"+ dateName + ".png";
File currentDir = new File (".");
String basePath = currentDir.getCanonicalPath();
String destination1 = basePath+"\\target\\reports\\Screenshots\\"+ dateName + ".png";
File finalDestination = new File(destination);
FileUtils.copyFile(source, finalDestination);
return destination1;
    }
}