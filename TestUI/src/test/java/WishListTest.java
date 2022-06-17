import org.junit.Assert;
import org.testng.annotations.Test;

public class WishListTest extends BaseTest{

    @Test(priority = 1)
    public void checkThatSuccessfulUpdateMassageIsVisibility() {
        getBasePage().waitForPageLoadComplete(30);
        getPersonalProfilePage().clickOnBodyCategoryButton();
        getBodyPage().clickOnFirstBodyProductInList();
        getBodyPage().clickOnAddProductInWishListButton();
        getBasePage().waitForPageLoadComplete(20);
        getBodyPage().clickOnPersonalWishListButton();
        getWishListPage().clickOnRemoveProductFromWishListButton();
        Assert.assertTrue(getWishListPage().checkThatSuccessfulUpdateMassageIsVisibility());
    }
}
