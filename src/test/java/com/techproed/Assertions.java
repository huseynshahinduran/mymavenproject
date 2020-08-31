package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertions {

    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // titleTest => Sayfa başlığının “Google” oldugunu assertion kullanarak doğrulayın
    // imageTest => Google logosunun görüntülenip görüntülenmediğini doğrulayın
    // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini doğrulayın
    // Her testten sonra tarayıcıyı kapatin

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //Yavas web siteleri icin implicitly wait kullanilabilir.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    @After
//    public void close() {
//        driver.close();
//    }

    @Test
    public void titleTest() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(expectedTitle,actualTitle);


    }

    @Test
    public void imageTest() {

        WebElement googleImage = driver.findElement((By.id("hplogo")));

        Assert.assertTrue(googleImage.isDisplayed());

    }

    @Test
    public void gmailLinkTest() {

        WebElement gmailLinkURL = driver.findElement(By.linkText("Gmail"));

        Assert.assertTrue(gmailLinkURL.isDisplayed());


    }






}
