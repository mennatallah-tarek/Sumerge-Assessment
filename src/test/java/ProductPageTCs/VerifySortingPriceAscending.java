package ProductPageTCs;

import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Test
public class VerifySortingPriceAscending extends BaseTest {
    public void testSortByPriceLowToHigh() {
        LoginPage.Username().click();
        LoginPage.UsernameField("standard_user");
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sauce");
        ProductsPage productsPage = LoginPage.clickLogin();
        productsPage.selectSortingOption("Price (low to high)");

        List<Double> displayedPrices = productsPage.getAllProductPrices();
        List<Double> sortedPrices = new ArrayList<>(displayedPrices);
        Collections.sort(sortedPrices);

        Assert.assertEquals(displayedPrices, sortedPrices, "Products are not sorted by price in ascending order.");
    }
}
