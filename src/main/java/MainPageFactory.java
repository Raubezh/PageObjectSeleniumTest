import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageFactory {
    private WebDriver driver;

    public MainPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(@data-ga-click,'sign-in')]")
    private WebElement signInButton;
    @FindBy(xpath = "//a[contains(@class,'HeaderMenu-link d-inline-block')]")
    private WebElement signUpButton;
    @FindBy(xpath = "//input[@id='user[login]']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@id='user[email]']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='user[password]']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[contains(@data-ga-click,'Sign up for GitHub;ref_loc:hero')]")
    private WebElement signUpFormButton;

    public LoginPage clickSignIn() {
        signInButton.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);

    }

    public SignUpPage clickSignUpFormButton() {
        signUpFormButton.click();
        return new SignUpPage(driver);

    }

    public MainPageFactory typeUserName(String username) {
        userNameField.sendKeys(username);
        return this;
    }

    public MainPageFactory typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public MainPageFactory typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPage register(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }


}
