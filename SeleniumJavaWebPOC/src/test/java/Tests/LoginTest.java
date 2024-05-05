package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pageobject.Login;
import pageobject.ProductList;
import utils.UtilsConfig;

import java.util.Properties;

public class LoginTest {
    @Test
    public void testOne(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        Properties properties = UtilsConfig.getProperties("test");
        driver.get(properties.getProperty("URL"));
        Login login=new Login(driver);
        ProductList Product=new ProductList(driver);
        login.login(properties.getProperty("username"),properties.getProperty("password"));
    }
}
