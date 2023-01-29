package com.Beymentest.Home;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class HomeTest {

    protected static WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("chromeDriver", "/Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        System.out.println("Test basladi.");
        driver.get("https://www.beymen.com/");
        System.out.println("Test linki: "+ driver.getTitle());
    }

    @After
    public void tearDown() {
        System.out.println("Test bitti.");
        driver.quit();
    }
}
