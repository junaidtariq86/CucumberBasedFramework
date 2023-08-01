package org.smallworld.automation.stepdefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.smallworld.automation.pages.SD_Home_Page;
import org.smallworld.automation.pages.SD_Product_Description_Page;
import org.smallworld.automation.utils.Base;
import org.smallworld.automation.utils.snap_shot;

public class stepDefinition_SD_Add_To_Cart_A_Product extends Base {

    SD_Home_Page sdHomePage = new SD_Home_Page(driver);
    SD_Product_Description_Page sdProductDescriptionPage = new SD_Product_Description_Page(driver);


    @And("^Select a \"([^\"]*)\" from Product list$")
    public void select_a_something_from_product_list(String product){
        sdHomePage.selectProduct(product);
    }


    @And("^select \"([^\"]*)\" from product description page$")
    public void select_something_from_product_description_page(String addToCartBtn){
        sdProductDescriptionPage.addToCartButton(addToCartBtn);
    }

    @And("verify that the Cart is not empty")
    public void verify_that_the_cart_is_not_empty() throws Exception {
        Assert.assertTrue("Cart is empty", sdProductDescriptionPage.CartNotEmpty());
        System.out.println("Product added into the cart successfully.");
        String image_path = snap_shot.takeSnapShot(Base.driver);
        System.out.println("Screenshot path:"+image_path);
    }

}
