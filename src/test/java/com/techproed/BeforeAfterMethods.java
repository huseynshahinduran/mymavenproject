package com.techproed;

import com.sun.glass.ui.Window;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BeforeAfterMethods {
    // Bir class oluşturun: BeforeAfterMethods
    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // titleTest => Sayfa başlığının “Google” oldugunu doğrulayın
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

    @After
    public void close() {
        driver.close();
    }

    @Test
    public void titleTest() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }


    }

    @Test
    public void imageTest() {

        WebElement googleImage = driver.findElement((By.id("hplogo")));
        if (googleImage.isDisplayed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

    }

    @Test
    public void gmailLinkTest() {

        WebElement gmailLinkURL = driver.findElement(By.linkText("Gmail"));
        if (gmailLinkURL.isEnabled()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }


    }


}
