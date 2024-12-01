package ShoppingCartTCs;

import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CartBadgeWhenAddProduct extends BaseTest {

    public void testCartBadgeCountAfterAddingItem() {
        LoginPage.Username().click();
        LoginPage.UsernameField("standard_user");
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sauce");
        ProductsPage productsPage = LoginPage.clickLogin();
        productsPage.addItemToCart(1);
        int intial_count = 0;
        int updatedCartCount = productsPage.getCartBadgeCount();
        Assert.assertEquals(updatedCartCount, intial_count + 1, "Cart badge count did not increase after adding an item.");

    }
}


