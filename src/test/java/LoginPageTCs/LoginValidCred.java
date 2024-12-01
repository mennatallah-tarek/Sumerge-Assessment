package LoginPageTCs;

import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test

public class LoginValidCred extends BaseTest {
    public void LoginWithValidCredintials() {
        LoginPage.Username().click();
        LoginPage.UsernameField("standard_user");
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sauce");
        ProductsPage productsPage = LoginPage.clickLogin();
        String actualTitle = productsPage.Gettitle();
        Assert.assertEquals(actualTitle, "Products");

    }

}
