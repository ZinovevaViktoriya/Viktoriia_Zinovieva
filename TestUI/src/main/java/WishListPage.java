import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@class='remove-cell text-center']/a")
    private WebElement removeProductFromWishListButton;

    @FindBy(xpath = "//div[@class='alert alert-success']/I")
    private WebElement successfulUpdateMassage;

    public void clickOnRemoveProductFromWishListButton() {
        removeProductFromWishListButton.isDisplayed();
        removeProductFromWishListButton.click();
    }

    public boolean checkThatSuccessfulUpdateMassageIsVisibility() {
        return successfulUpdateMassage.isDisplayed();
    }

}
