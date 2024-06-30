package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test
    public void correctLogin(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(driver.findElement(By.cssSelector("[class=data-test]")).getText(), "Products");
    }

    @Test
    public void testLoginWithoutUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        // Проверить, что появилось сообщение об ошибке
        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();

        assertEquals(actualErrorMessage, expectedErrorMessage, "Сообщение об ошибке не соответствует ожидаемому");
    }
    @Test
    public void testlockedOutUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        // Проверить, что появилось сообщение об ошибке
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualErrorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();

        assertEquals(actualErrorMessage, expectedErrorMessage, "Сообщение об ошибке не соответствует ожидаемому");
    }
}
