package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private By AllProducts = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div");
    private By ProductsListCategories = By.cssSelector("div.left-sidebar");
    private By ViewFirstProduct = By.linkText("View Product");
    private By SearchInput = By.className("input-lg");
    private By IntiateSearchButton = By.cssSelector("button#submit_search.btn.btn-default.btn-lg");
    private By SearchedProductsText = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2");
    private By ProductsAfterSearch = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div");
    private By Firstproduct = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]");
    private By AddToCart = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a");
    private By ContinueShopping = By.cssSelector("button#submit_search.btn.btn-default.btn-lg");
    private By Secondproduct = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]");
    private By AddToCartSecondProduct = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a");
    private By Viewcart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    private By categoryView = By.xpath("/html/body/section/div/div[2]/div[2]");
    private By CenterTextCategory = By.cssSelector("h2.title.text-center");
    private By brandPage = By.xpath("/html/body/section/div/div[1]/ol/li[2]");
    private By brandProductstext = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
    private By searchProducts = By.cssSelector("div.productinfo.text-center");
    private By addProductsToCart = By.cssSelector("a.btn.btn-default.add-to-cart");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean AllProductsPageVisibility() {
        return driver.findElement(AllProducts).isDisplayed();
    }

    public boolean ProductsListVisibility() {
        return driver.findElement(ProductsListCategories).isDisplayed();
    }

    public ProductDetailsPage clickViewProductForFirstProduct() {
        driver.findElement(ViewFirstProduct).click();
        return new ProductDetailsPage(driver);
    }

    public void setSearchInput(String Input) {
        driver.findElement(SearchInput).sendKeys(Input);
        driver.findElement(IntiateSearchButton).click();

    }

    public boolean SearchProductTextVisibilty() {
        return driver.findElement(SearchedProductsText).isDisplayed();
    }

    public boolean ProductsRelatedToSearchVisibilty() {
        return driver.findElement(ProductsAfterSearch).isDisplayed();
    }

    public void HoverOverFirstProduct() {
        WebElement element = driver.findElement(Firstproduct);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void AddFirstProductToCart() {
        driver.findElement(AddToCart).click();
        driver.findElement(ContinueShopping).click();
    }

    public void HoverOverSecondProduct() {
        WebElement element = driver.findElement(Secondproduct);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void AddSecondProductToCart() {
        driver.findElement(AddToCartSecondProduct).click();
    }

    public CartPage ClickViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Viewcart));
        element.click();
        return new CartPage(driver);
    }

    public boolean VerifyCategoryIsDisplayed() {
        return driver.findElement(categoryView).isDisplayed();
    }

    public String VerifyTextIsDisplayed() {
        return driver.findElement(CenterTextCategory).getText();
    }

    public String verifyNavigationToBrandPage() {
        return driver.findElement(brandPage).getText();

    }

    public String VerifyBrandProductIsDisplayed() {
        return driver.findElement(brandProductstext).getText();
    }

    public boolean verifyShirtSearchResults() {
        List<WebElement> productTitles = driver.findElements(By.cssSelector("div.productinfo.text-center p"));
        for (WebElement productTitle : productTitles) {
            String text = productTitle.getText();
//        System.out.println(productTitle.getText());
            if (!text.toLowerCase().contains("shirt") && !text.toLowerCase().contains("top")) {
                return false; // If any product is not related to shirt or top, return false
            }
        }
        return true; // All products are related to shirt or top
    }

    public void AddProductsToCart() {
//        List<WebElement> Products = driver.findElements(searchProducts);
//         Actions actions = new Actions(driver);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
//         for(WebElement product : Products){
//             actions.moveToElement(product).perform();
//             driver.findElement(AddToCart).click();
//             try {
//                 // Explicit wait for ContinueShopping button
//                 WebElement continueShoppingButton = wait.until(ExpectedConditions.elementToBeClickable(ContinueShopping)); // Replace with actual locator
//                 continueShoppingButton.click();
//             } catch (Exception e) {
//                 // Handle exception: you can retry, log, or take other actions
//                 System.out.println("Error clicking Continue Shopping: " + e.getMessage());
//             }
//
//         }
        WebElement Products = driver.findElement(searchProducts);
         Actions actions = new Actions(driver);
         actions.moveToElement(Products).perform();
         driver.findElement(AddToCart).click();
         driver.findElement(ContinueShopping).click();





    }

}


