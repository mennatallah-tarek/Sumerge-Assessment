package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {
    private WebDriver driver;
    private By Pagetitle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    private By productsSections = By.className("inventory_list");
    private By productItems = By.cssSelector(".inventory_item");

    private By sortingDropdown = By.cssSelector(".product_sort_container");

    private By sortingDropdownOpions = By.cssSelector(" select > option");
    private By ProductPrices = By.cssSelector("div.inventory-item-price");
    //Logout
    private By sandwichmenu = By.id("react-burger-menu-btn");
    private By logout = By.id("logout_sidebar_link");

    //cart locators
    private By AddtoCart = By.cssSelector(".btn");
    private By Cart = By.cssSelector(".shopping_cart_badge");
    private By CartIcon = By.cssSelector(".shopping_cart_link");

    private By removebutton = By.cssSelector("#remove-sauce-labs-bike-light");


    public WebElement Productsections() {
        return driver.findElement(productsSections);
    }

    public List<WebElement> listOfProducts() {
        return driver.findElements(productItems);
    }

    public WebElement SortingDropdownList() {
        return driver.findElement(sortingDropdown);
    }

    public List<WebElement> sortingDropdownoptions() {
        return driver.findElements(sortingDropdownOpions);
    }

    public List<WebElement> Prices() {
        return driver.findElements(ProductPrices);
    }

    public WebElement Menu() {
        return driver.findElement(sandwichmenu);
    }

    public WebElement logoutButton() {
        return driver.findElement(logout);
    }

    public WebElement CartCounter() {
        return driver.findElement(Cart);
    }

    public List<WebElement> addToCartButtons() {
        return driver.findElements(AddtoCart);
    }

    public List<WebElement> removeFromCartButtons() {
        return driver.findElements(removebutton);
    }

    public boolean isProductsSectionVisible() {
        return Productsections().isDisplayed();
    }

    public int getProductCount() {
        return listOfProducts().size();
    }

    public List<Product> getAllProducts() {
        return listOfProducts().stream().map(Product::new).collect(Collectors.toList());
    }

    public WebElement CartButton() {
        return driver.findElement(CartIcon);
    }


    public int getExpectedProductCount() {
        return 6;
    }

    public WebElement Title() {
        return driver.findElement(Pagetitle);
    }

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String Gettitle() {
        return Title().getText();
    }

    public boolean isSortingDropdownVisible() {
        return SortingDropdownList().isDisplayed();
    }

    public List<String> getSortingOptions() {
        return sortingDropdownoptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void selectSortingOption(String option) {
        new Select(SortingDropdownList()).selectByVisibleText(option);
    }

    public List<Double> getAllProductPrices() {
        return Prices().stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", "").trim())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public void clickSandwichMenu() {
        Menu().click();
    }

    public void clicklogout() {
        logoutButton().click();
    }

    //cart locators
    public void addItemToCart(int index) {
        addToCartButtons().get(index - 1).click();
    }

    public int getCartBadgeCount() {
        return Integer.parseInt(CartCounter().getText());
    }

    public void removeItemFromCart(int productIndex) {
        removeFromCartButtons().get(productIndex - 1).click();
    }

    public checkoutPage clickcart() {
        CartButton().click();
        return new checkoutPage(driver);

    }


    ////////////////////////////
    public class Product {
        private WebElement productElement;

        public Product(WebElement productElement) {
            this.productElement = productElement;
        }

        public boolean isNameVisible() {
            return productElement.findElement(By.cssSelector(".inventory_item_name")).isDisplayed();
        }

        public boolean isPriceVisible() {
            return productElement.findElement(By.cssSelector(".inventory_item_price")).isDisplayed();
        }

        public boolean isImageVisible() {
            return productElement.findElement(By.cssSelector(".inventory_item_img")).isDisplayed();
        }

    }
}
