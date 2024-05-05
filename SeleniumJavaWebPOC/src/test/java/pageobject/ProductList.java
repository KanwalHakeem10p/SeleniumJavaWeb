package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.UtilsConfig;

import java.util.Properties;

public class ProductList extends BaseClass {
    Properties properties = UtilsConfig.getProperties("test");
    By productTitle = new By.ByXPath(properties.getProperty("productTitle"));

    public ProductList(WebDriver driver) {
        this.driver = driver;
    }

    public void Product(String producttitle) {

        String tmp = driver.findElement(this.productTitle).getText();
        if (tmp.equals("Sauce Labs Backpack")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }


}
