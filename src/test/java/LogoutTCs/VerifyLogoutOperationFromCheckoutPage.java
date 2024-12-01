package LogoutTCs;

import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class VerifyLogoutOperationFromCheckoutPage extends BaseTest {
    public void LogoutfromCheckoutPage() {
        LoginPage.Username().click();
        LoginPage.UsernameField("standard_user");
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sauce");
        ProductsPage productsPage = LoginPage.clickLogin();
        productsPage.clickSandwichMenu();
        productsPage.clicklogout();
        Assert.assertEquals(LoginPage.LoginTilte().getText(), "Swag Labs");
    }
}
