package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;

    }

    private By loginUserName = By.id("user-name");

    private By loginPassword = By.id("password");

    private By loginButton = By.id("login-button");

    public void enterUserName(String createUserName){
        driver.findElement(loginUserName).sendKeys(createUserName);
    }

    public void enterPassword(String createUserPassword){
        driver.findElement(loginPassword).sendKeys(createUserPassword);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
}
