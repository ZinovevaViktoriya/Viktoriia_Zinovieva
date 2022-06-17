import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@class='name']/a")
    private WebElement actualMakeupProductTitle;

    public WebElement getActualMakeupProductTitle() {
        return actualMakeupProductTitle;
    }

}
