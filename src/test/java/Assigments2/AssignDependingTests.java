package Assigments2;

import org.testng.annotations.Test;
import tests.testng.Tests;

public class AssignDependingTests extends Tests {
    /*  /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
    @Test
    public void Facebook(){
        bot.navigate("https://www.Facebook.com/");
    }
    @Test(dependsOnMethods = "Facebook")
    public void Google(){
        bot.navigate("https://www.google.com/");
    }
    @Test(dependsOnMethods = "Google")
    public void Amazon(){
        bot.navigate("https://www.amazon.com/");
    }
}
