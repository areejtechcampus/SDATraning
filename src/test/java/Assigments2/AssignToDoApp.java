package Assigments2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.testng.Tests;

import java.time.Duration;

/*
//Go to URL: http://crossbrowsertesting.github.io/
//Click to To-Do App
//Checking Box to do-4 and Checking Box to do-5
//If both clicks worked, then the following List should be have length 2.
//Assert that this is correct
//Assert that the to do we added is present in the list
//Archiving old todos
//If our archive link worked, then the following list should have length 4.
//Assert that this is true as well
//Doing Cross Browser Testing.
 */
public class AssignToDoApp extends Tests {
    WebDriver driver;


    @Test
    public void toDoApp() {
        driver = new ChromeDriver();
        //Go to URL: http://crossbrowsertesting.github.io/
        driver.get("http://crossbrowsertesting.github.io/");
        //Click to To-Do App
        WebElement ToaddClick = driver.findElement(By.xpath("//a[@href='todo-app.html']"));
        ToaddClick.click();
        //Checking Box to do-4 and Checking Box to do-5
        WebElement do4 = driver.findElement(By.cssSelector("input[name='todo-4']"));
        do4.click();
        WebElement do5 = driver.findElement(By.cssSelector("input[name='todo-5']"));
        do5.click();

        // Verify that the list has length 2
        By NumselectedList = By.xpath("//span[@class='done-true']");
        int num = driver.findElements(NumselectedList).size();
        Assert.assertEquals(num, 2);

        WebElement text = driver.findElement(By.id("todotext"));
        WebElement button = driver.findElement(By.id("addbutton"));
        text.sendKeys("hello");
        button.click();


        // Assert that the added to-dos are present in the listAssert.assertTrue(driver.findElement());
        //Archiving old todos
        WebElement archive = driver.findElement(By.xpath("//a[text()='archive']"));
        archive.click();

           // Verify that the list has length 4 after archiving
            By NumselectedList2 = By.xpath("//span[@class='done-false']");
            int num2 = driver.findElements(NumselectedList2).size();
        Assert.assertEquals(num2, 4);
        //Doing Cross Browser Testing.
        //in the task5.xml file.


    }
}

