package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageobject.Login;
import pageobject.ProductList;
import utils.UtilsConfig;
import java.time.Duration;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        Properties properties = UtilsConfig.getProperties("test");
        driver.get(properties.getProperty("URL"));
        Login login=new Login(driver);
        ProductList Product=new ProductList(driver);
        login.login(properties.getProperty("username"),properties.getProperty("password"));
        Product.Product(properties.getProperty("productTitle"));
        driver.findElement(By.xpath(properties.getProperty("productTitle"))).click();
        driver.findElement(By.xpath(properties.getProperty("ProductAddbtn"))).click();
        driver.findElement(By.xpath(properties.getProperty("addtocart"))).click();

    }
}