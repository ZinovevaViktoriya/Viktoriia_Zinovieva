import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PerfumePage extends BasePage {

    public PerfumePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='grid-holder product-holder grid4']//div[@class='item single-product']")
    private List<WebElement> perfumeProductList;

    @FindBy(xpath = "//button[@id='button-cart']")
    private WebElement addPerfumeProductInCard;

    @FindBy(xpath = "//div[@class='text-danger']")
    private WebElement errorMassage;

    public void clickOnFirstPerfumeProductInList() {
        perfumeProductList.get(0).isDisplayed();
        perfumeProductList.get(0).click();
    }

    public void clickOnAddPerfumeProductInCard() {
        addPerfumeProductInCard.isDisplayed();
        addPerfumeProductInCard.click();
    }

    public boolean checkThatErrorMassageIsVisibility() {
        waitVisibilityOfElement(5, errorMassage);
        return errorMassage.isDisplayed();
    }
}
