import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Driver;

public class BaseTest {

    private static final String START_URL = "https://www.wildberries.by/catalog/264220770/detail.aspx";

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(START_URL);
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
