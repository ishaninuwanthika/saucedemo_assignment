package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

    private WebDriver driver;

    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }

    private By checkOutButton = By.id("checkout");

    private By firstNameText = By.id("first-name");

    private By lastNameText = By.id("last-name");

    private By postalCodeText = By.id("postal-code");

    private  By continueButton = By.id("continue");

    private By finishButton = By.id("finish");

    public void clickCheckOutButton(){
        driver.findElement(checkOutButton).click();
    }

    public void enterCustomerDetails(String firstName,String lastName, String postalCode ){

        driver.findElement(firstNameText).sendKeys(firstName);
        driver.findElement(lastNameText).sendKeys(lastName);
        driver.findElement(postalCodeText).sendKeys(postalCode);
        driver.findElement(continueButton).click();

    }

    public void completeShopping(){
        driver.findElement(finishButton).click();
    }
}
