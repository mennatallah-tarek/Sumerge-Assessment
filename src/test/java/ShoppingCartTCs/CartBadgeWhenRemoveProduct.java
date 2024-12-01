package ShoppingCartTCs;

import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CartBadgeWhenRemoveProduct extends BaseTest {


    public void testCartBadgeCountAfterRemovingItem() {
        LoginPage.Username().click();
        LoginPage.UsernameField("standard_user");
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sauce");
        ProductsPage productsPage = LoginPage.clickLogin();
        productsPage.addItemToCart(1); // Add an item first.
        productsPage.addItemToCart(2);
        int updatedCartCount = productsPage.getCartBadgeCount();

        productsPage.removeItemFromCart(1); // Remove the same item.
        int finalCartCount = productsPage.getCartBadgeCount();

        Assert.assertEquals(finalCartCount, updatedCartCount - 1, "Cart badge count did not decrease after removing an item.");
    }
}

