package browserfactory;

/**
 * 1. userShouldNavigateToLoginPageSuccessfully()
 * * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage()
 * * click on the ‘Sign In’ link
 * * Enter the invalid username
 * * Enter the invalid password
 * * Click on the ‘Sign in’ button
 * * Verify the error message ‘Invalid email or password.’
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        //Launch Chrome browser
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
