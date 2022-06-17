import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalProfilePage extends BasePage {

    public PersonalProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='main-menu text-center']//ul[@class='categories']//a[@href='parfums']")
    private WebElement perfumeCategoryButton;

    @FindBy(xpath = "//div[@class='main-menu text-center']//ul[@class='categories']//a[@href='/makeup']")
    private WebElement makeupCategoryButton;

    @FindBy(xpath = "//a[@class='shortcut-wrapper search-trigger from-top clicker']/i")
    private WebElement mainSearchButton;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchField;

    @FindBy(xpath = "//span[@class='btn btn-contrast do-search main']")
    private WebElement minorSearchButton;

    @FindBy(xpath = "//div[@class='main-menu text-center']//ul[@class='categories']//a[@href='telo']")
    private WebElement bodyCategoryButton;

    public void clickOnPerfumeCategoryButton() {
        perfumeCategoryButton.isDisplayed();
        perfumeCategoryButton.click();
    }

    public void clickOnMakeupCategoryButton() {
        makeupCategoryButton.isDisplayed();
        makeupCategoryButton.click();
    }

    public void clickOnMainSearchButton() {
        mainSearchButton.isDisplayed();
        mainSearchButton.click();
    }

    public void inputRequestOnSearchField(String keyword) {
        searchField.isDisplayed();
        searchField.click();
        searchField.sendKeys(keyword);
    }

    public void clickOnMinorSearchButton() {
        minorSearchButton.isDisplayed();
        minorSearchButton.click();
    }

    public void clickOnBodyCategoryButton() {
        bodyCategoryButton.isDisplayed();
        bodyCategoryButton.click();
    }
}
