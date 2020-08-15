import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest() {
        SignUpPage signUpPage = mainPage.register("jfhjjrgljn", "dhfgkj", "12vbkbl678");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void singUpEmptyUsernameTest() {
        SignUpPage signUpPage = mainPage.register("", "dhfgkj", "12vbkbl678");
        String error = signUpPage.getUserNameErrorText();
        Assert.assertEquals("Username can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailText() {
        SignUpPage signUpPage = mainPage.register("jfhjjrgljn", "fgfgf", "12vbkbl678");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @Test
    public void signUpEmptyPasswordTest() {
        SignUpPage signUpPage = mainPage.register("jfhjjrgljn", "fgfgf", "");
        String error = signUpPage.getPasswordErrorText();
        Assert.assertEquals("Password can't be blank", error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
