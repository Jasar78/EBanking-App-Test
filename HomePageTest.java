import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import pages.LoginPage;
import pages.HomePage;

public class HomePageTest {

    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "PATH_TO_CHROMEDRIVER");
        driver = new ChromeDriver();
        driver.get("https://qaebank.ccbp.tech/ebank/login");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.loginToApplication("142420", "231225");

        String expectedUrl = "https://qaebank.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testHomepageHeading() {
        Assert.assertTrue(homePage.findAppLogo().isDisplayed(), "App logo is not displayed");

        String actualHeading = homePage.getHeadingText();
        String expectedHeading = "Your Flexibility, Our Excellence";
        Assert.assertEquals(actualHeading, expectedHeading, "Heading text does not match");

        Assert.assertTrue(homePage.findDigitalCard().isDisplayed(), "Digital card image is not displayed");
    }

    @Test(priority = 2)
    public void testLogoutFunctionality() {
        homePage.clickOnLogoutButton();

        String expectedLoginUrl = "https://qaebank.ccbp.tech/ebank/login";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedLoginUrl, "URLs do not match");
    }
}