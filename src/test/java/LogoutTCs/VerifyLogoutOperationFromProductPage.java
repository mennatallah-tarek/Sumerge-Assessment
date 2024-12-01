package LogoutTCs;

import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class VerifyLogoutOperationFromProductPage extends BaseTest {
    public void LogoutfromProductPage() {
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
