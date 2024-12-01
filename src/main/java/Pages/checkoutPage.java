package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class checkoutPage {
    private WebDriver driver;

    private By Cartitems = By.cssSelector(".cart_item");


    private By removefromcart = By.cssSelector("#remove-sauce-labs-backpack");

    public List<WebElement> CartItem() {
        return driver.findElements(Cartitems);
    }

    public WebElement removeButtons() {
        return driver.findElement(removefromcart);
    }

    public checkoutPage(WebDriver driver) {

        this.driver = driver;
    }


    public boolean isProductInCart(String productName) {
        return CartItem().stream()
                .anyMatch(item -> item.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName));
    }

    public void removeItemFromCart(String productName) {
        for (WebElement item : CartItem()) {
            if (item.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName)) {
                item.findElement(By.cssSelector("#remove-sauce-labs-backpack")).click();
                return;
            }

        }
    }
}
