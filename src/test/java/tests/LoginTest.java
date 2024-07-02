package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest{

    @Test
    public void correctLogin(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productPage.getTitle(), "Products");
    }

    @DataProvider()
    public Object[][] loginData(){
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out." },
        };
    }
    @Test(dataProvider = "loginData")
    public void InCorrectLogin(String user, String password, String expectedError) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(), expectedError);
    }
}
