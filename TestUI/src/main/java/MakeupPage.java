import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MakeupPage extends BasePage {

    public MakeupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='grid-holder product-holder grid4']//div[@class='item single-product']")
    private List<WebElement> makeupProductList;

    @FindBy(xpath = "//div[@class='product-h1']/h1")
    private WebElement expectedMakeupProductTitle;

    @FindBy(xpath = "//button[@id='button-cart']")
    private WebElement addMakeupProductInCart;

    @FindBy(xpath = "//a[@class='popup-note-close']")
    private WebElement popupAddToCart;

    @FindBy(xpath = "//a[@class='shortcut-wrapper cart']")
    private WebElement personalCartButton;

    public void clickOnFirstMakeupProductInList() {
        makeupProductList.get(0).isDisplayed();
        makeupProductList.get(0).click();
    }

    public WebElement getExpectedMakeupProductTitle() {
        return expectedMakeupProductTitle;
    }

    public void clickOnAddMakeupProductInCart() {
        addMakeupProductInCart.isDisplayed();
        addMakeupProductInCart.click();
    }

    public void clickOnPopupAddToCart() {
        waitVisibilityOfElement(3, popupAddToCart);
        popupAddToCart.isDisplayed();
        popupAddToCart.click();
    }

    public void clickOnPersonalCartButton() {
        waitVisibilityOfElement(30, personalCartButton);
        personalCartButton.click();
    }
}
