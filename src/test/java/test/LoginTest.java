package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductPage;

import static org.testng.Assert.assertNotNull;

public class LoginTest extends BaseTest {

//    private WebDriver driver;
//
//    @BeforeTest
//    public void setUpDriver() {
//        driver = new ChromeDriver(); // Initialize the WebDriver
//    }

    @Test(priority = 1)
    public void loginSauceDemoWeb(){
       // assertNotNull(driver, "WebDriver is not properly initialized.");
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @Test(priority = 2)
    public void sortProductByPriceHighToLow(){

        ProductPage productPage = new ProductPage(driver);
        productPage.selectHighToLowPrice("Price (high to low)");

    }

    @Test(priority = 3)
    public void addThreeCheapestProductInBasket() {
        ProductPage productPage = new ProductPage(driver);
        productPage.addCheapestProductToCart();
        productPage.clickAddToCartButton();
        //Thread.sleep(2000);
//        driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);

    }


    @Test(priority = 4)
    public void removeCheapestProductFromCart(){
        CartPage checkOutPage = new CartPage(driver);
        checkOutPage.removeCheapestProductFromCart();
    }

    @Test(priority = 5)
    public void redirectCheckoutPage(){
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickCheckOutButton();

    }

    @Test(priority = 6)
    public void completeCheckOut(){
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterCustomerDetails("Ishani", "Nuwanthika","9090");
    }

    @Test(priority = 7)
    public void finishShopping(){
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.completeShopping();
    }
}
