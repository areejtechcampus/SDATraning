package tests.testng.expandTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.expandTesting.Login;
import tests.testng.Tests;

public class FluentPomPatternPomTests extends Tests {
    /**
     * breakout task: 40 minutes
     * - implement fluent POM design, using abstract page class
     * - add a new failed login test
     * - read data from json
     * - generate single allure html file
     */
    @Test(description = "Successful Login")
    public void loginTest1(){
        String actualText = new Login(driver,bot)
                .goTo()
                .successfulLogin((String) testData.get("Username"), (String) testData.get("Password"))
                .readSuccessMessage();
        Assert.assertEquals(actualText, (String) testData.get("ExpectedSuccessMessage"));
        logger.info("Login was successful as expected!");
    }

    @Test(description = "Failed Login - Wrong Password")
    public void loginTest2(){
        String actualText = new Login(driver,bot)
                .goTo()
                .failedLogin((String) testData.get("Username"), (String) testData.get("WrongPassword"))
                .readFailureMessage();
        Assert.assertEquals(actualText, (String) testData.get("ExpectedFailureMessagePassword"));
        logger.info("Login failed as expected!");
    }

    @Test(description = "Failed Login - Wrong Username")
    public void loginTest3(){
        String actualText = new Login(driver,bot)
                .goTo()
                .failedLogin((String) testData.get("WrongUsername"), (String) testData.get("Password"))
                .readFailureMessage();
        Assert.assertEquals(actualText, (String) testData.get("ExpectedFailureMessageUsername"));
        logger.info("Login failed as expected!");
    }

    @BeforeClass
    public void initializeTestDataReader(){
        testData = (JSONObject) testData.get("expandTesting");
    }
}
