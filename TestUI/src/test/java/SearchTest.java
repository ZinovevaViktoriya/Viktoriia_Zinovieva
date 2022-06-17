import org.junit.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

    private static final String KEYWORD_1 = "dsdfg";
    private static final String KEYWORD_2 = "sane";

    @Test(priority = 1)
    public void checkThatBadRequestMassageIsVisibility() {
        getBasePage().waitForPageLoadComplete(30);
        getPersonalProfilePage().clickOnMainSearchButton();
        getPersonalProfilePage().inputRequestOnSearchField(KEYWORD_1);
        getPersonalProfilePage().clickOnMinorSearchButton();
        Assert.assertTrue(getSearchPage().checkThatBadRequestMassageIsVisibility());
    }

    @Test(priority = 2)
    public void checkThatUrlContainsSearchRequest() {
        getBasePage().waitForPageLoadComplete(30);
        getPersonalProfilePage().clickOnMainSearchButton();
        getPersonalProfilePage().inputRequestOnSearchField(KEYWORD_2);
        getPersonalProfilePage().clickOnMinorSearchButton();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("sane"));
    }


}
