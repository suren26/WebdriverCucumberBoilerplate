package pages;
import framework.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Inventorypage extends CommonMethods {
    private static Map<String,By> item=new HashMap<>();
    public Inventorypage(WebDriver driver) throws IOException{
        super(driver);
        itemList();
    }
//    public static Map<String,By> getData(){
//        return item;
//    }
    public By swaglabs=By.xpath("//div[@id='shopping_cart_container']");
    public By cartQuantity = By.xpath("//div[@id='shopping_cart_container']/a/span");
    public By menuList = By.xpath("//button[@id='react-burger-menu-btn']");
    public By logOut = By.xpath("//button[@id='logout_sidebar_link']");


    public static void itemList(){
        item.put("shoppingcartBag",By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        item.put("bikeLight",By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));

    }
    public static By getItem(String key){
        return item.get(key);
    }
}
