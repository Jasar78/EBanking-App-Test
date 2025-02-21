package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    By applogoLocator = By.className("ebank-logo");
    By headingLocator = By.className("heading");
    By digitalCardLocator = By.className("digital-card-image");
    By logoutButtonLocator = By.className("logout-button");

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findAppLogo() {
        return driver.findElement(applogoLocator);
    }

    public WebElement findDigitalCard() {
        return driver.findElement(digitalCardLocator);
    }

    public String getHeadingText() {
        return driver.findElement(headingLocator).getText();
    }

    public void clickOnLogoutButton(){
        driver.findElement(logoutButtonLocator).click();
    }
}