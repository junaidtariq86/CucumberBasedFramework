package org.smallworld.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.smallworld.automation.utils.Base;

public class SD_Product_Description_Page extends Base {

    public SD_Product_Description_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@class='shopping_cart_badge']")
    public WebElement cart_count;

    public void addToCartButton(String data){
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"));
        element.click();
    }

    public boolean CartNotEmpty(){
        try {
            return cart_count.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false; // Element not found or not displayed
        }

    }

}
