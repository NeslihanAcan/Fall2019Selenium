package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {
    @BeforeTest
    public void BeforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void AfterTest(){

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
    @BeforeMethod
   public void setup(){
       System.out.println("Before Method");
   }
   @AfterMethod
   public void teardown(){
       System.out.println("After Method");
   }
    @Test
    public void Test1(){
        System.out.println("Test 1");
        String expected="apple";
        String actual="apple";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
        int num1=5;
        int num2=10;

        //it calls hard assertion
        //
        Assert.assertTrue(num1<num2);

    }
}
