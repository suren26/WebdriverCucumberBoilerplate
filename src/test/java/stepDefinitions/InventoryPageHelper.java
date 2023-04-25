package stepDefinitions;

import framework.CreateSession;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Inventorypage;

import java.io.IOException;

public class InventoryPageHelper {
    WebDriver driver;
    String url;
    String csvFilePath;
    Inventorypage inventoryPage;

    public InventoryPageHelper() throws IOException {
        driver = CreateSession.getWebDriver();
        inventoryPage = new Inventorypage(driver);
        csvFilePath = ".//src//test//java//outputFiles//searchResults.csv";
    }
    @When("^User sees the product$")
    public void user_sees_the_product() throws Throwable {
        Thread.sleep(10000);
        inventoryPage.findElement(inventoryPage.getItem("shoppingcartBag"));
    }
    @And("^Adds the products into cart \\\"([^\\\"]*)\\\"$")
    public void user_adds_the_product(String item) throws Throwable {

        inventoryPage.clickOnElementUsingActions(inventoryPage.getItem(item));
    }
    @Then("^User sees the quantity in shopping cart badge$")
    public void user_sees_the_quantity() throws Throwable {
        if(inventoryPage.getIntValue(inventoryPage.findElement(inventoryPage.cartQuantity).getText())>=1){
        System.out.println("Element successfully added into the cart");
        }
        else {
            throw new RuntimeException();
        }
        System.out.println("Case 1 Completed");
    }
    @And("^user logs out$")
    public void user_logs_out() throws Throwable{
        if(inventoryPage.findElement(inventoryPage.menuList).isDisplayed()) {
            inventoryPage.clickOnElementUsingActions((inventoryPage.menuList));
            inventoryPage.clickOnElementUsingActions((inventoryPage.logOut));
        }
        else{
            System.out.println("Menu Not found !!!!!");
        }
    }


}
