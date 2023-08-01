package org.smallworld.automation.stepdefinitions;

import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.smallworld.automation.pages.SD_Home_Page;
import org.smallworld.automation.pages.SD_Login_Page;
import org.smallworld.automation.utils.Base;
import org.smallworld.automation.utils.ExcelDriven_XLSX;

import org.smallworld.automation.utils.snap_shot;

import java.util.concurrent.TimeUnit;
@RunWith(Cucumber.class)
public class stepDefinition_SD_Login extends Base {

    SD_Login_Page sdLoginPage = new SD_Login_Page(driver);

    SD_Home_Page sdHomePage = new SD_Home_Page(driver);

    @Given("User is on Login Page")
    public void user_is_on_login_page() throws Exception {
        // Code to navigate to the login page goes here
        System.out.println("Read URL");
        String WebUrl = ExcelDriven_XLSX.readExcelData("Testdata", "Basic", "URL").get("Value").toString();
        System.out.println(WebUrl);
        System.out.println(Base.driver);
        System.out.println("Before Open URL ==============> " );
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        sdLoginPage.openUrl(WebUrl);
        driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS) ;
        System.out.println("After Open URL " );
        //Reporter.addStepLog(" ******************** User is on Login Page ******************** ");
        //scenarioDef.info("******************** User is on Login Page ********************");
        System.out.println("User is on Login Page" );
        String image_path = snap_shot.takeSnapShot(Base.driver);
        System.out.println("Screenshot path:"+image_path);
        //Reporter.addScreenCaptureFromPath(image_path);
    }

    @When("User login into application using valid user credentials")
    public void user_login_into_application_using_valid_user_credentials() throws Exception {
        String Username = ExcelDriven_XLSX.readExcelData("Testdata", "Basic", "UserName").get("Value").toString();
        String Password = ExcelDriven_XLSX.readExcelData("Testdata", "Basic", "Password").get("Value").toString();
        System.out.println("Before providing credentials ");
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        sdLoginPage.Enter_Uname_Password(Username, Password);
        System.out.println("after providing credentials");
        sdLoginPage.clickOn_LoginButton();
        System.out.println("User login to application");
        String image_path = snap_shot.takeSnapShot(Base.driver);
        System.out.println("Screenshot path:"+image_path);
        //Reporter.addScreenCaptureFromPath(image_path);
       // Reporter.addStepLog(" ******************** User login to application ********************");
    }

    @Then("Main Home Page is populated")
    public void main_home_page_is_populated() throws Exception {
        System.out.println("User is on home page");
        Assert.assertTrue("Cart logo not displayed.", sdHomePage.cartButtonClickable());
        String image_path = snap_shot.takeSnapShot(Base.driver);
        System.out.println("Screenshot path:"+image_path);
        //Reporter.addScreenCaptureFromPath(image_path);
        String currentURL = Base.driver.getCurrentUrl();
        //  Reporter.addStepLog("********************* Home page is populated: ***************************");
        //Base.scenarioDef.pass("Login to the application successfully");
    }

    @Then("User logout from application")
    public void user_logout_from_application() throws Exception {
        //System.out.println("User is on home page");
        sdHomePage.clickOnMenuButton();
        sdHomePage.clickLogoutButton();
        System.out.println("User logged-out successfully");
        String image_path = snap_shot.takeSnapShot(driver);
        System.out.println("Screenshot path:"+image_path);
        // Reporter.addScreenCaptureFromPath(image_path);

    }

    @Then("Close the browser")
    public void close_the_browser() throws Exception {
        System.out.println("Before closing browser");
        String image_path = snap_shot.takeSnapShot(driver);
        System.out.println("Screenshot path:"+image_path);
       // Reporter.addScreenCaptureFromPath(image_path);
        driver.close();

    }

    @When("Locked User login into application")
    public void locked_user_login_into_application() throws Exception {
        String Username = ExcelDriven_XLSX.readExcelData("Testdata", "UserData", "LockedUserName").get("Value").toString();
        String Password = ExcelDriven_XLSX.readExcelData("Testdata", "UserData", "LockedUserPassword").get("Value").toString();
        System.out.println("Before providing locked user credentials ");
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        sdLoginPage.Enter_Uname_Password(Username, Password);
        System.out.println("after providing locked user credentials");
        sdLoginPage.clickOn_LoginButton();
        System.out.println("login try with locked user!");

    }

    @And("Locked User error message is displayed")
    public void locked_user_error_message_is_displayed() throws Exception {
        String expLockedUserError = ExcelDriven_XLSX.readExcelData("Testdata", "UserData", "LockedUserErrorMessage").get("Value").toString();
        Assert.assertEquals("Error message match", expLockedUserError, sdLoginPage.lockedUserErrorMessage());
        System.out.println("Error message when locked user login");
        String image_path = snap_shot.takeSnapShot(driver);
        System.out.println("Screenshot path:"+image_path);

    }

    @And("Clear username field")
    public void clear_username_field() throws Exception {
        sdLoginPage.clearUserNameField();
        System.out.println("Empty user name field");
        String image_path = snap_shot.takeSnapShot(driver);
        System.out.println("Screenshot path:"+image_path);

    }

    @Then("Clear password field")
    public void clear_password_field() throws Exception {
        sdLoginPage.clearPasswordField();
        System.out.println("Empty password field.");
        String image_path = snap_shot.takeSnapShot(driver);
        System.out.println("Screenshot path:"+image_path);
        driver.navigate().refresh();

    }


}
