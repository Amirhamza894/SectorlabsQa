package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    private WebDriver driver;

    @FindBy(css="[aria-label='Login']")
    public WebElement loginBtn;

    @FindBy(css = "[name='email']")
    public WebElement emailInput;

    @FindBy(id="password")
    public WebElement paswordInput;

    @FindBy(css="button[type='submit']")
    public WebElement sumitBtn;

    @FindBy(css = "[aria-label='Username']")
    public WebElement usernameLabel;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCredentials(String email, String password) {
        emailInput.sendKeys(email);
        paswordInput.sendKeys(password);
    }

}
