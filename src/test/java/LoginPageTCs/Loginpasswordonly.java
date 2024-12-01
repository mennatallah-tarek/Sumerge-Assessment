package LoginPageTCs;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test

public class Loginpasswordonly extends BaseTest {
    public void Loginpasswordonly() {
        LoginPage.Password().click();
        LoginPage.PasswordField("secret_sae");
        Assert.assertEquals(LoginPage.ErrorMessageText().getText(), "Epic sadface: Username is required");

    }
}
