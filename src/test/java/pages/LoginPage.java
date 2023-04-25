package pages;

import framework.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends CommonMethods {

    public LoginPage(WebDriver driver) throws IOException{
        super(driver);
    }
    public By username=By.xpath("//input[@id='user-name']");
    public By password=By.xpath("//input[@id='password']");
    public By loginbutton=By.xpath("//input[@id='login-button']");

}
