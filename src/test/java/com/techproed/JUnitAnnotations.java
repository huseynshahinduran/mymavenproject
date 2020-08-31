package com.techproed;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitAnnotations {
    //Bir jUnit projesinde testti calistirmak icin @Test annotation'i kullanilir
    //"test1" adinda bir void method olusturun

    @Before
    public void runBeforeTest(){
        System.out.println("@Before => run before test");
    }

    @After
    public void runAfterTest(){
        System.out.println("@After => run after test");
    }

    @Test //@Test ==> test caseleri main method olamdan calistirmamizi saglar
    public void test1(){
        System.out.println("Test1'i yazdir");
    }

    @Ignore //@Ignore ==> test methodunu gormezden gelmeyi saglar
    @Test
    public void test2(){
        System.out.println("Test2'yi yazdir");
    }


    @Test
    public void test3(){
        System.out.println("Test3'u yazdir");
    }




}
