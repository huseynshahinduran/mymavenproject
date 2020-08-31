package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tekrar_BeforeAfter_BestBuy {
    /*
    Bir class oluşturun: Tekrar_BeforeAfter_BestBuy
    Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun      https://www.bestbuy.com/
    titleTest => Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
    logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
    mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
    Her testten sonra tarayıcıyı kapatin
    @Before ve @After metotlarini kullanarak yapalim.
     */
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void close(){
        driver.close();
    }

    @Test
    public void titleTest(){
        String actualTitel = driver.getTitle();
        String expectedTitel = "Best";

        if(actualTitel.contains(expectedTitel)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }

    @Test
    public void logoTest(){
        WebElement logo=driver.findElement(By.cssSelector(".logo"));
        if(logo.isDisplayed()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

    }

    @Test
    public void mexicoLinkTest(){
        WebElement mexicoLink=driver.findElement(By.linkText("Mexico"));
        if (mexicoLink.isEnabled()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }



}
