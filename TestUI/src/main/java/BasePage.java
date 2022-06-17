import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='links']//li[@class='static-link'][3]")
    private WebElement personalProfileButton;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement inputInPersonalProfileButton;

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnPersonalProfileButton() {
        personalProfileButton.isDisplayed();
        personalProfileButton.click();
    }

    public void inputEmailInEmailField(String email) {
        emailField.isDisplayed();
        emailField.click();
        emailField.sendKeys(email);
    }

    public void inputPasswordInPasswordField(String password) {
        passwordField.isDisplayed();
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickOnInputPersonalProfileButton() {
        inputInPersonalProfileButton.isDisplayed();
        inputInPersonalProfileButton.click();
    }
}

