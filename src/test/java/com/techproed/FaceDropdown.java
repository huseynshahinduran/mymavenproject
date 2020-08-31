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
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FaceDropdown {

    // Create class : FaceDropdown
    // Create method : Birthday
    // https://www.facebook.com adresine gidin
    // Ay , gun ve yil dropdownlarindan istediginiz bir tarihi secin.
    // Tarayiciyi kapatin.

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void birthday(){
        WebElement selectDay=driver.findElement(By.id("day"));
        Select optionsDay=new Select(selectDay);
        optionsDay.selectByIndex(6);

        WebElement selectMonth=driver.findElement(By.id("month"));
        Select optionsMonth=new Select(selectMonth);
        optionsMonth.selectByIndex(6);

        WebElement selectYear=driver.findElement(By.id("year"));
        Select optionsYear=new Select(selectYear);
        optionsYear.selectByValue("2001");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


}
