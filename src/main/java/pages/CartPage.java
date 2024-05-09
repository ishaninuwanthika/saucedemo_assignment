package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

//    private By removeButton = By.id("remove-sauce-labs-backpack");


    public void removeCheapestProductFromCart(){

     List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));

     double cheapestPrice = Double.MAX_VALUE;
     WebElement cheapestPriceItem = null;


        for (WebElement priceElement : priceElements){
            String priceText =priceElement.getText().replace("$", "").trim();
            double price = Double.parseDouble(priceText);

            if (price < cheapestPrice){
                cheapestPrice = price;
                cheapestPriceItem = priceElement.findElement(By.xpath("//div[@class = 'cart_item']"));
            }
        }


        if (cheapestPriceItem != null){
           String itemName = cheapestPriceItem.findElement(By.className("inventory_item_name")).getText();
           String itemLink = cheapestPriceItem.findElement(By.tagName("a")).getAttribute("href");

           cheapestPriceItem.findElement(By.id("remove-sauce-labs-onesie")).click();
        }









    }
}
