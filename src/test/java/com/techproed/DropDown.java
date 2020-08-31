package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class DropDown {

    /*
        Bir class oluşturun: DropDown
        https://the-internet.herokuapp.com/dropdown adresine gidin.
        1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        4.Tüm dropdown değerleri(value) yazdırın
        5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
     */
    ChromeDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @After
    public void close(){
        driver.close();
    }

    @Test
    public void dropDownTest(){
        WebElement selectElement=driver.findElement(By.id("dropdown"));
        Select options=new Select(selectElement);

        String firstOption =options.getFirstSelectedOption().getText();
        System.out.println(firstOption);

        options.selectByIndex(1);

        options.selectByValue("2");

        options.selectByVisibleText("Option 1");

        List<WebElement> allOptions=options.getOptions();
        for(WebElement element:allOptions){
            System.out.println(element.getText());
        }

        int size=allOptions.size();

        Assert.assertTrue(size!=4);

        System.out.println((allOptions.size()==4) ? "FALSE" : "TRUE");

    }










}
