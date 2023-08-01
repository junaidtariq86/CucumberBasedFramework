package org.smallworld.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.smallworld.automation.utils.Base;

import java.util.List;

public class SD_Cart_Page extends Base {

    public SD_Cart_Page(WebDriver driver) {PageFactory.initElements(driver, this );}


    public void removeProductsFromCart() throws InterruptedException {
    List<WebElement> removeList = driver.findElements(By.xpath("//*[contains(@class,'cart_list')]//*[contains(text(),'Remove')]"));

    for (int i = 0; i < removeList.size(); i++) {
        removeList.get(i).click();
        Thread.sleep(2000);
        if (removeList.size() == 0) {
            break;
        }
    }
}

}
