package ProductPageTCs;

import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class VerifyNoOfProducts extends BaseTest {
    public void testProductCountMatchesExpected() {
        LoginPage.Username().click();
        LoginPage.UsernameField("standard_user");
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sauce");
        ProductsPage productsPage = LoginPage.clickLogin();

        int displayedCount = productsPage.getProductCount();
        int expectedCount = productsPage.getExpectedProductCount(); // Fetch from config or database.
        Assert.assertEquals(displayedCount, expectedCount, "The product count does not match the expected value.");
    }
}
