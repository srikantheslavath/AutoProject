package com.BaseClassPackage;

import com.UtilityPackage.UtilsClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;
    //public static Logger logger=null;


    public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream in = new FileInputStream(
                    "C:\\Users\\Sampath Velupula\\IdeaProjects\\WblProject\\" +
                            "src\\main\\java\\com\\ConfigPackage\\Config.Properties");
            prop.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // String log4jpath =System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
        //PropertyConfigurator.configure(log4jpath);

    }

    public static void initialization() {
       // String browserName = prop.getProperty("browser");
        WebDriverManager.chromedriver().setup();
        /*if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\Sampath Velupula\\IdeaProjects\\WhiteBoxQa\\" +
                            "src\\main\\resources\\Browsers\\chromedriver107.exe");
            // create a driver object for Chrome browser
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    ".\\resources\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

         */
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(UtilsClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(UtilsClass.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));


    }
}
