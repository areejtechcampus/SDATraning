package Assigments2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenCartTest {
    /* //Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.*/
    WebDriver driver;

    @Test(dataProvider = "search")
    public void products(String keyword) {
        // Open the site
        driver = new ChromeDriver();
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        // Login with credentials
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("clarusway@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123456789");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        // Perform search
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.ENTER);



        // Close the browser
        //driver.quit();
    }

    @DataProvider(name = "search")
    public Object[][] search() {
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
}
