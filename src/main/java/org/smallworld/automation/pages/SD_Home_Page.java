package org.smallworld.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.smallworld.automation.utils.Base;

public class SD_Home_Page extends Base {

    public SD_Home_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    public WebElement cart_link;

    @FindBy(xpath = "//*[@id='react-burger-menu-btn']")
    public WebElement menu_btn;


    @FindBy(xpath = "//*[@id='logout_sidebar_link']")
    public WebElement logout_btn;

    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    public WebElement cart_btn;





    public void clickOnMenuButton(){
        menu_btn.click();
    }

    public void clickLogoutButton(){
        logout_btn.click();
    }

    public boolean cartButtonClickable() {
        try {
        return cart_link.isDisplayed();
    }
        catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false; // Element not found or not displayed
        }

}
    public void selectProduct(String data){
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"));
        element.click();
    }

    public void clickOnCartIcon(){
        cart_btn.click();
    }
}
