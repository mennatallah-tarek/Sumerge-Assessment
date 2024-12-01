package LoginPageTCs;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test

public class Loginusernameonly extends BaseTest {
    public void Loginusernameonly() {
        LoginPage.Username().click();
        LoginPage.UsernameField("secret_sae");
        Assert.assertEquals(LoginPage.ErrorMessageText().getText(), "Epic sadface: Password is required");
    }
}


