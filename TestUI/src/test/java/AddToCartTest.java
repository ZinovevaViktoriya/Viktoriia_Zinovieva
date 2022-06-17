import org.junit.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test(priority = 1)
    public void checkErrorMassageVisibility() {
        getBasePage().waitForPageLoadComplete(30);
        getPersonalProfilePage().clickOnPerfumeCategoryButton();
        getPerfumePage().clickOnFirstPerfumeProductInList();
        getPerfumePage().clickOnAddPerfumeProductInCard();
        Assert.assertTrue(getPerfumePage().checkThatErrorMassageIsVisibility());
    }

    @Test(priority = 2)
    public void checkThatProductTitleInMakeupPageAndProductTitleInCartPageTheSame() {
        getBasePage().waitForPageLoadComplete(30);
        getPersonalProfilePage().clickOnMakeupCategoryButton();
        getMakeupPage().clickOnFirstMakeupProductInList();
        String expectedTitle = getMakeupPage().getExpectedMakeupProductTitle().getText();
        getMakeupPage().clickOnAddMakeupProductInCart();
        getBasePage().waitForPageLoadComplete(20);
        getMakeupPage().clickOnPersonalCartButton();
        String actualTitle = getCartPage().getActualMakeupProductTitle().getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

}

