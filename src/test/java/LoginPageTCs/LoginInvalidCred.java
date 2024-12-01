package LoginPageTCs;

import Base.BaseTest;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class LoginInvalidCred extends BaseTest {
    public void LoginInvalidCred() {

        LoginPage.Username().click();
        LoginPage.UsernameField("standard_user");
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sae");
        ProductsPage productsPage = LoginPage.clickLogin();
        Assert.assertEquals(LoginPage.ErrorMessageText().getText(), "Epic sadface: Username and password do not match any user in this service");


    }
}




