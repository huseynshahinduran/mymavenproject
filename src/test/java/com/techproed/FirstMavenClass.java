package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstMavenClass {

    public static void main(String[] args) {

        // Driver i baslatmak icin bunu java projelerinde kullaniyoruz. System.setProperty("","");
        //Bunun yerine Maven projesinde WebDriverManager

        WebDriverManager.chromedriver().setup(); //kirmizi olmasinin sebebi eksik dependency lerin olmasindandir.
        //Dependency ler nerden alinir??? https://mvnrepository.com/git ve WebDriverManager ara

        WebDriver driver =new ChromeDriver();

        driver.get("https://www.google.com/");


        //Fake data nasil olusturulur:
         //Fake data olusturmak icin "JavaFaker" denilen bir dependency gerekir
        //searcBox elementini locate edin
        WebElement searchBox=driver.findElement(By.name("q"));

        //faker objecti olustur
        Faker faker=new Faker();
        //Searchboxa fake data gonder ve ENTER tusuna bas.
        searchBox.sendKeys(faker.country().capital()+ Keys.ENTER);
        System.out.println(faker.country().capital());











    }



}
