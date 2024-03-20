package Assigments2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.testng.Tests;

import java.time.Duration;

public class AssignLogin extends Tests {
    /* /* go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!"
*/
    @Test
    public void test(){
        bot.navigate("https://practicetestautomation.com/practice-test-login/");

        By userInput =  By.id("username");
        By passwordInput =  By.id("password");
        By loginButton = By.id("submit");

        bot.type(userInput,"student");
        bot.type(passwordInput,"incorrectPassword");
        bot.click(loginButton);

        By Errormessage = By.id("error");
        wait.until(f->driver.findElement(Errormessage).isDisplayed());

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(driver.findElement(Errormessage).isDisplayed());
        softAssert.assertEquals(driver.findElement(Errormessage).getText(),"Your password is invalid!");

        softAssert.assertAll();
    }
}