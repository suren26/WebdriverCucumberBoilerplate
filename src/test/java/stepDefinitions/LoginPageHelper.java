package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import framework.CreateSession;
import org.openqa.selenium.WebDriver;
import pages.Inventorypage;
import pages.LoginPage;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPageHelper {
    LoginPage loginPage;
    WebDriver driver;
    String url;
    String csvFilePath;

    Inventorypage inventoryPage;

    public LoginPageHelper() throws IOException {
        driver = CreateSession.getWebDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new Inventorypage(driver);
        csvFilePath = ".//src//test//java//outputFiles//searchResults.csv";
    }

    @Given("^user is logged in on saucedemo page \\\"([^\\\"]*)\\\"$")
    public void user_is_on_saucedemo_page(String url) throws Throwable {
        loginPage.get(url);
        loginPage.findElement(loginPage.username).sendKeys("standard_user");
        loginPage.findElement(loginPage.password).sendKeys(System.getenv("standard_user_password"));
        loginPage.clickOnElementUsingActions(loginPage.loginbutton);
        loginPage.isElementPresent(inventoryPage.swaglabs);
        System.out.println("Successfully Logged in");
    }

}
