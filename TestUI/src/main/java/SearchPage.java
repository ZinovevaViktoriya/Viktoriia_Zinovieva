import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "   //div[@class='pos_category_top']")
    private WebElement badRequestMessage;

    public boolean checkThatBadRequestMassageIsVisibility() {
        return badRequestMessage.isDisplayed();
    }
}
