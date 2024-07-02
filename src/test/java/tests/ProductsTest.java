package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    private String goodsName = "Sauce Labs Backpack";

    @Test
    public void buyProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.isOpened();
        productPage.addToCart(goodsName);
        productPage.addToCart("Sauce Labs Bike Light");
        productPage.openCart();
        assertTrue(productPage.getProductsNames().contains(goodsName));
    }
}
