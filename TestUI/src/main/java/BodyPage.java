import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BodyPage extends BasePage {

    public BodyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='grid-holder product-holder grid4']//div[@class='item single-product']")
    private List<WebElement> bodyProductList;

    @FindBy(xpath = "//p[@class='info is_wishlist']/a")
    private WebElement addProductInWishListButton;

    @FindBy(xpath = "//a[@class='popup-note-close']")
    private WebElement popupAdToWishList;

    @FindBy(xpath = "//a[@class='shortcut-wrapper wishlist']/div")
    private WebElement personalWishListButton;

    public void clickOnFirstBodyProductInList() {
        bodyProductList.get(0).isDisplayed();
        bodyProductList.get(0).click();
    }

    public void clickOnAddProductInWishListButton() {
        addProductInWishListButton.isDisplayed();
        addProductInWishListButton.click();
    }

    public void clickOnPopupAddToWishList() {
        waitVisibilityOfElement(3, popupAdToWishList);
        popupAdToWishList.isDisplayed();
        popupAdToWishList.click();
    }

    public void clickOnPersonalWishListButton() {
        waitVisibilityOfElement(20, personalWishListButton);
        personalWishListButton.isDisplayed();
        personalWishListButton.click();
    }
}
