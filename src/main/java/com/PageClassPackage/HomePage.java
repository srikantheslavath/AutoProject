package com.PageClassPackage;

import com.BaseClassPackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(xpath="//*[@id=\"logo\"]")
    WebElement wbqa;
    @FindBy(xpath="//*[@id=\"headerfblogin\"]")
    WebElement freestudent;
    @FindBy(xpath="//*[@id=\"wblhead\"]")
    WebElement wbl;
    @FindBy(xpath="//*[@id=\"loginButton\"]")
    WebElement loginBtn;

    public HomePage(){

        PageFactory.initElements(driver,this);

       // logger= Logger.getLogger(HomePage.class);
       // logger.info("we are in home page");
    }

    public String VerifyTitle(){
        String title = driver.getTitle();
        return title;

    }
    public boolean verifywbllogo(){
        boolean logo =wbqa.isDisplayed();
        return logo;

    }
    public boolean verifystudent(){
        boolean stu=freestudent.isDisplayed();
        return stu;
    }
    public LoginPage VerifyLoginBtn(){
        loginBtn.click();
        return new LoginPage();

    }
}
