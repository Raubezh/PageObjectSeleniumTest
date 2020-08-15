import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpTest {
    WebDriver driver;
    SignUpPage signUpPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPass(){
        SignUpPage newSignUpPage = signUpPage.typePassword("dfdg1");
        String error = newSignUpPage.getPasswordErrorText();
        Assert.assertEquals("Password is too short (minimum is 8 characters) and is in a list of passwords commonly used on other websites", error);
    }

    @Test
    public void signUpWithNameUsernameTest(){
        SignUpPage newSignUpPage = signUpPage.typeUserName("username");
        String error = newSignUpPage.getUserNameErrorText();
        Assert.assertEquals("Username 'username' is unavailable.", error);

    }

    @Test
    public void signUpTakenUsernameTest(){
        SignUpPage newSignUpPage = signUpPage.typeUserName("user");
        String error = newSignUpPage.getUserNameErrorText();
        Assert.assertEquals("Username user is not available.", error);


    }

    @Test

    public void getHeadingTest(){
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }
    @After
    public  void tearDown(){
        driver.quit();
    }
}
