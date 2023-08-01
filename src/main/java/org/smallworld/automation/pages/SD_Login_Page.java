package org.smallworld.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.smallworld.automation.utils.Base;

public class SD_Login_Page extends Base {

    public SD_Login_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id='user-name']")
    public WebElement U_Name;


    @FindBy(xpath = "//*[@id='password']")
    public WebElement U_Password;

    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement Login_Button;


    @FindBy(xpath = "//*[@class='error-message-container error']")
    public WebElement error_message;


    public void openUrl(String Url) {
        Base.driver.get(Url);
    }
    public void Enter_Uname_Password(String uname,String Password) throws InterruptedException {

        System.out.println("User on Login Page");
        U_Name.sendKeys(uname);
        U_Password.sendKeys(Password);
    }

    public void clickOn_LoginButton() {
        Login_Button.click();
    }

    public String lockedUserErrorMessage(){
        String locked_user_error = error_message.getText();
        return locked_user_error;
    }


    public void clearUserNameField(){
        U_Name.clear();
    }

    public void clearPasswordField(){
        U_Password.clear();
    }
}
