package ProductPageTCs;

import org.testng.Assert;
import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.annotations.Test;

@Test

public class VerfiyProductsavailable extends BaseTest {
    public void testProductsAreDisplayed() {
        LoginPage.Username().click();
        LoginPage.UsernameField("standard_user");
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sauce");
        ProductsPage productsPage = LoginPage.clickLogin();
        Assert.assertTrue(productsPage.isProductsSectionVisible(), "Products section is not visible.");
        Assert.assertTrue(productsPage.getProductCount() > 0, "No products are displayed on the page.");
    }
}
