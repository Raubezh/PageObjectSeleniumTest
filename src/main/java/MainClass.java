import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class MainClass {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        
//        MainPage mainPage = new MainPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        SignUpPage signUpPage = new SignUpPage(driver);
        MainPageFactory mainPageFactory = PageFactory.initElements(driver, MainPageFactory.class);

        mainPageFactory.register("dmitriy", "ddurngij.com", "12345fjgjgjgj");


//        mainPage.clickSignUpFormButton();
//        signUpPage.registerWithInvalidCreds("Petya", "dhfgdj.com", "171615er");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        if (signUpPage.getMainErrorText().contains("There were problems creating your account")) {
//            System.out.println(signUpPage.getMainErrorText());
//        }
//        if (signUpPage.getUserNameErrorText().contains("Username can't be blank")) {
//            System.out.println(signUpPage.getUserNameErrorText());
//        }
//        if (signUpPage.getEmailErrorText().contains("Email can't be blank")) {
//            System.out.println(signUpPage.getEmailErrorText());
//        }
//        if (signUpPage.getPasswordErrorText().contains("Password can't be blank")) {
//            System.out.println(signUpPage.getPasswordErrorText());
//        }

//        if (loginPage.getHeadingText().equals("Sign in to GitHub")) {
//            System.out.println("We are on '" + loginPage.getHeadingText() + "' page");
//        } else System.out.println("Sorry we are not '" + loginPage.getHeadingText() + "' page");

    }
}
