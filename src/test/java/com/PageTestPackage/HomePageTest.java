package com.PageTestPackage;

import com.BaseClassPackage.BaseClass;
import com.PageClassPackage.HomePage;
import com.PageClassPackage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass{

    HomePage home;
    LoginPage login;
    public HomePageTest(){

        super();

    }
    @BeforeMethod
    public void setup(){
        initialization();
        home=new HomePage();
    }
    @Test(priority=1)
    public void TestTitle(){
        String actual =home.VerifyTitle();
        String expected ="QA/QE/SDET Training.";
        Assert.assertEquals(expected,actual);
    }
    @Test(priority =2)
    public void VerifywblLogoTest(){
        boolean logo=home.verifywbllogo();
        Assert.assertTrue(logo);
    }
    @Test(priority = 3)
    public void VerifystudentTest(){
        boolean student = home.verifystudent();
        Assert.assertTrue(student);
    }
    @Test(priority = 4)
    public void TestLoginBtn(){

        home.VerifyLoginBtn();
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
