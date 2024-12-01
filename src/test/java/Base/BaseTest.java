package Base;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected LoginPage LoginPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void main(String args[]) {
        BaseTest Test = new BaseTest();
        Test.setUp();
    }
}
