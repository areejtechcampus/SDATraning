package Assigments2;

import org.testng.annotations.Test;
import tests.testng.Tests;

public class DependingTests extends Tests {
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
