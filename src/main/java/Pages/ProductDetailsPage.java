package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    private WebDriver driver;
    private By PName = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
    private By PCategory = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]");
    private By PPrice = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
    private By PAvailability = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]");
    private By PCondition = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]");
    private By PBrand = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]");
    private By ThirdProductDetails = By.xpath("/html/body/section/div/div/div[2]");
    private By ThirdProductInputQuantity = By.cssSelector("input#quantity");
    private By AddToCart = By.cssSelector("button.btn.btn-default.cart");
    private By ViewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a");
    private By WriteYourReview = By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a");
    private By reviewName = By.cssSelector("input#name");
    private By reviewEmail = By.cssSelector("input#email");
    private By reviewMessage = By.cssSelector("textarea#review");
    private By submitReview = By.id("button-review");
    private By successSubmitionReview = By.xpath("//*[@id=\"review-section\"]/div/div/span");
    public ProductDetailsPage(WebDriver driver){
        this.driver= driver;
    }
    public boolean CheckVisibilityOfProductName(){
        return driver.findElement(PName).isDisplayed();
    }
    public boolean CheckVisibilityOfProductCategory(){
        return driver.findElement(PCategory).isDisplayed();
    }
    public boolean CheckVisibilityOfProductPrice(){
        return driver.findElement(PPrice).isDisplayed();
    }
    public boolean CheckVisibilityOfProductAvailability(){
        return driver.findElement(PAvailability).isDisplayed();
    }
    public boolean CheckVisibilityOfProductCondition(){
        return driver.findElement(PCondition).isDisplayed();
    }
    public boolean CheckVisibilityOfProductBrand(){
        return driver.findElement(PBrand).isDisplayed();
    }
    public boolean VerifyVisibilityOfThirdProductDetails(){
        return driver.findElement(ThirdProductDetails).isDisplayed();
    }
    public void IncreaseQuantityForThirdProduct(String Quantity){
        driver.findElement(ThirdProductInputQuantity).clear();
        driver.findElement(ThirdProductInputQuantity).sendKeys(Quantity);
    }
    public void AddThirdProductToCart(){
        driver.findElement(AddToCart).click();
    }
    public CartPage ClickViewCartAfterAddingThirdProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ViewCart));
        element.click();
        return new CartPage(driver);
    }
    public boolean checkVisibilityOfWriteReviewText(){
        return driver.findElement(WriteYourReview).isDisplayed();
    }
    public void setNameInReview(String name){
        driver.findElement(reviewName).sendKeys(name);
    }
    public void setEmailInReview(String email){
        driver.findElement(reviewEmail).sendKeys(email);
    }
    public void setMessageInReview(String message){
        driver.findElement(reviewMessage).sendKeys(message);
    }
    public void clickSubmitReview(){
        driver.findElement(submitReview).click();
    }
    public boolean successReviewSubmit(){
        return driver.findElement(successSubmitionReview).isDisplayed();
    }

}
