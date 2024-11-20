package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a")).click();
        String expectedText = "Welcome Back!";
        WebElement welcomeTextElement = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/article/h2"));
        String actualText = welcomeTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
    }


    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a")).click();
        driver.findElement(By.id("user[email]")).sendKeys("priyanshp");
        driver.findElement(By.id("user[password]")).sendKeys("13333");
        driver.findElement(By.className("button-primary")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement errorMessage = driver.findElement(By.className("form-error__list-item"));
        Assert.assertEquals("Invalid email or password.", errorMessage.getText().trim());

    }

    @After
    public void tearDownBrowser() {
        closeBrowser();

    }
}
