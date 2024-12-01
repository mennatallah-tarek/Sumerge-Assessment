package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;


    private By username = By.id("user-name");
    private By Password = By.xpath("//*[@id=\"password\"]");
    private By LoginButton = By.id("login-button");
    private By errorMessage = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3");
    private By LoginPagetitle = By.className("login_logo");


    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }


    public WebElement Username() {
        return driver.findElement(username);
    }

    public WebElement Password() {
        return driver.findElement(Password);
    }

    public WebElement LoginButton() {
        return driver.findElement(LoginButton);
    }

    public WebElement ErrorMessageText() {
        return driver.findElement(errorMessage);
    }

    public WebElement LoginTilte() {
        return driver.findElement(LoginPagetitle);
    }


    public void UsernameField(String Lesson) {
        Username().sendKeys(Lesson);
        Username().sendKeys(Keys.ENTER);
    }

    public void PasswordField(String Lesson) {
        Password().sendKeys(Lesson);
        Password().sendKeys(Keys.ENTER);
    }

    public void errormessage() {
        System.out.println(ErrorMessageText().getText());

    }

    public ProductsPage clickLogin() {
        LoginButton().click();
        return new ProductsPage(driver);

    }


}
