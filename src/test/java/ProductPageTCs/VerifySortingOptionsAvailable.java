package ProductPageTCs;

import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class VerifySortingOptionsAvailable extends BaseTest {
    public void testSortingOptionsExist() {
        LoginPage.Username().click();
        LoginPage.UsernameField("standard_user");
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sauce");
        ProductsPage productsPage = LoginPage.clickLogin();
        Assert.assertTrue(productsPage.isSortingDropdownVisible(), "Sorting dropdown is not visible.");
        List<String> sortingOptions = productsPage.getSortingOptions();
        Assert.assertTrue(sortingOptions.contains("Price (low to high)"), "Option 'Price (low to high)' is missing.");
        Assert.assertTrue(sortingOptions.contains("Price (high to low)"), "Option 'Price (high to low)' is missing.");
    }
}
