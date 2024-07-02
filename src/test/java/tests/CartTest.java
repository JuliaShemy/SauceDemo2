package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void productCartTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.isOpened();
        productPage.addToCart("Sauce Labs Bike Light");
        productPage.openCart();
        assertTrue(productPage.getProductsNames().contains("Sauce Labs Bike Light"));
    }
}
