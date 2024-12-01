package ProductPageTCs;

import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Test
public class VerifySortingPriceDescending extends BaseTest {
    public void testSortByPriceHighToLow() {
        LoginPage.Username().click();
        LoginPage.UsernameField("standard_user");
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sauce");
        ProductsPage productsPage = LoginPage.clickLogin();
        productsPage.selectSortingOption("Price (high to low)");

        List<Double> displayedPrices = productsPage.getAllProductPrices();
        List<Double> sortedPrices = new ArrayList<>(displayedPrices);
        Collections.sort(sortedPrices, Collections.reverseOrder());

        Assert.assertEquals(displayedPrices, sortedPrices, "Products are not sorted by price in descending order.");
    }
}
