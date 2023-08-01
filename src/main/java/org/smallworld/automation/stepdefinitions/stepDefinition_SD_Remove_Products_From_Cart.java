package org.smallworld.automation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.smallworld.automation.pages.SD_Cart_Page;
import org.smallworld.automation.pages.SD_Home_Page;
import org.smallworld.automation.utils.Base;
import org.smallworld.automation.utils.snap_shot;

public class stepDefinition_SD_Remove_Products_From_Cart extends Base{

    SD_Home_Page sdHomePage = new SD_Home_Page(driver);
    SD_Cart_Page sdCartPage = new SD_Cart_Page(driver);


    @Then("Open the Cart")
    public void open_the_cart() throws Exception {
        sdHomePage.clickOnCartIcon();
        System.out.println("Cart is opened");
        String image_path = snap_shot.takeSnapShot(Base.driver);
        System.out.println("Screenshot path:"+image_path);

    }

    @And("Remove products from cart")
    public void remove_products_from_cart() throws InterruptedException {
        sdCartPage.removeProductsFromCart();

    }


}
