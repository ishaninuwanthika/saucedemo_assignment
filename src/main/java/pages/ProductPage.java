package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    private By productSortDropDownHigh = By.xpath("//div[@id = 'header_container']//div[@class = 'header_secondary_container']//div[@class = 'right_component']//select[@class = 'product_sort_container']");

    private By itemPrice = By.xpath("//div[@class = 'inventory_item_description']//div[@class = 'pricebar']//div[@class = 'inventory_item_price']");

    private By addToCartButton = By.xpath("//a[@class = 'shopping_cart_link']");

    public void selectHighToLowPrice(String productDropDown){

        WebElement productSortDropDown =driver.findElement(productSortDropDownHigh);
        Select selectObj = new Select(productSortDropDown);
        selectObj.selectByVisibleText(productDropDown);

    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }




    public void addCheapestProductToCart(){


        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        List<Double> prices = new ArrayList<>();

        for (WebElement product : products) {
            String priceString = product.findElement(By.className("inventory_item_price")).getText();
            double price = Double.parseDouble(priceString.replace("$", ""));
            prices.add(price);
        }
        prices.sort(Double::compareTo);
// Add the three cheapest products to the basket
        for (int i = 0; i < 3; i++) {
            double cheapestPrice = prices.get(i);
            for (WebElement product : products) {
                String priceString = product.findElement(By.className("inventory_item_price")).getText();
                double price = Double.parseDouble(priceString.replace("$", ""));
                if (price == cheapestPrice) {
                    product.findElement(By.className("btn_inventory")).click();
                    break;
                }
            }
        }



    }




}
