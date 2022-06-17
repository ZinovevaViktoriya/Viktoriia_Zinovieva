import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private WebDriver driver;
    private static final String GLOW_URL = "https://glow.in.ua/";
    private static final String EMAIL = "zinoveva7vika@gmail.com";
    private static final String PASSWORD = "dfhfggjfdsb6847";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(GLOW_URL);
        BasePage basePage = getBasePage();
        basePage.clickOnPersonalProfileButton();
        basePage.inputEmailInEmailField(EMAIL);
        basePage.inputPasswordInPasswordField(PASSWORD);
        basePage.clickOnInputPersonalProfileButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public BasePage getBasePage() {
        return new BasePage(getDriver());
    }

    public BodyPage getBodyPage() {
        return new BodyPage(getDriver());
    }

    public CartPage getCartPage() {
        return new CartPage(getDriver());
    }

    public MakeupPage getMakeupPage() {
        return new MakeupPage(getDriver());
    }

    public PerfumePage getPerfumePage() {
        return new PerfumePage(getDriver());
    }

    public PersonalProfilePage getPersonalProfilePage() {
        return new PersonalProfilePage(getDriver());
    }

    public SearchPage getSearchPage() {
        return new SearchPage(getDriver());
    }

    public WishListPage getWishListPage() {
        return new WishListPage(getDriver());
    }
}