package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login extends BaseClass{

    By username = new By.ById("user-name");
    By password = new By.ByName("password");
    By login_button = new By.ById("login-button");
    public Login(WebDriver driver){
        this.driver=driver;
    }
    public void login(String username, String password){
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.login_button).click();
    }

}
