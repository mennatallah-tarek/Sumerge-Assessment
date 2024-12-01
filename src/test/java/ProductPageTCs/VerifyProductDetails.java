package ProductPageTCs;

import org.testng.Assert;
import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class VerifyProductDetails extends BaseTest {
    public void testProductDetailsAreDisplayed() {
        LoginPage.Username().click();
        LoginPage.UsernameField("standard_user");
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sauce");
        ProductsPage productsPage = LoginPage.clickLogin();

        List<ProductsPage.Product> products = productsPage.getAllProducts();
        for (ProductsPage.Product product : products) {
            Assert.assertTrue(product.isNameVisible(), "Product name is not visible.");
            Assert.assertTrue(product.isPriceVisible(), "Product price is not visible.");
            Assert.assertTrue(product.isImageVisible(), "Product image is not visible.");
        }
    }
}
