package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private By CartFooter = By.xpath("//*[@id=\"footer\"]/div[1]");
    private By TextSubscribtion = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
    private By EmailInput = By.cssSelector("input#susbscribe_email");
    private By ArrowButton = By.cssSelector("button#subscribe.btn.btn-default");
    private By AlertSuccessText = By.className("alert-success");
    private By FirstProduct = By.xpath("//*[@id=\"product-1\"]/td[1]/a/img");
    private By SecondProduct = By.xpath("//*[@id=\"product-2\"]/td[1]/a/img");
    private By FirstProductPrice = By.xpath("//*[@id=\"product-1\"]/td[3]/p");
    private By FirstProductQuantity = By.xpath("//*[@id=\"product-1\"]/td[4]/button");
    private By FirstProductTotal = By.xpath("//*[@id=\"product-1\"]/td[5]/p");
    private By SecondProductPrice = By.xpath("//*[@id=\"product-2\"]/td[3]/p");
    private By SecondProductQuantity = By.xpath("//*[@id=\"product-2\"]/td[4]/button");
    private By SecondProductTotal = By.xpath("//*[@id=\"product-2\"]/td[5]/p");
    private By ThirdProduct = By.xpath("//*[@id=\"product-3\"]/td[1]/a/img");
    private By ThirdQuantity = By.xpath("//*[@id=\"product-3\"]/td[4]/button");
    private By CartPage = By.cssSelector("li.active");
    private By ProceedToCheckOut = By.cssSelector("a.btn.btn-default.check_out");
    private By RegisterORLoginLink = By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a");
    private By DeleteFromCart = By.xpath("//*[@id=\"product-4\"]/td[6]/a");
    private By FourthProduct = By.id("product-4");

    private By cartProduct2 = By.id("product-2");
    public CartPage(WebDriver driver){
        this.driver= driver;
    }
    public boolean ScrollDownToFooterInCart(){
        WebElement element = driver.findElement(CartFooter);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        return driver.findElement(TextSubscribtion).isDisplayed();

    }
    public void SetEmailForSubscriptionInCart(String email){
        driver.findElement(EmailInput).sendKeys(email);
    }
    public String clickArrowButtonInCart(){
        driver.findElement(ArrowButton).click();
        return driver.findElement(AlertSuccessText).getText();
    }
    public boolean VerifyAdditionOfFirstProduct(){
        return driver.findElement(FirstProduct).isDisplayed();
    }
    public boolean VerifyAdditionOfSecondProduct(){
        return driver.findElement(SecondProduct).isDisplayed();
    }
    public String GetFirstProductPrice(){
        return driver.findElement(FirstProductPrice).getText();
    }
    public String GetFirstProductQuantity(){
        return driver.findElement(FirstProductQuantity).getText();
    }
    public String GetFirstProductTotal(){
        return driver.findElement(FirstProductTotal).getText();
    }
    public String GetSecondProductPrice(){
        return driver.findElement(SecondProductPrice).getText();
    }
    public String GetSecondProductQuantity(){
        return driver.findElement(SecondProductQuantity).getText();
    }
    public String GetSecondProductTotal(){
        return driver.findElement(SecondProductTotal).getText();
    }
    public boolean checkThirdProductAddition(){
        return driver.findElement(ThirdProduct).isDisplayed();
    }
    public String GetQuantityOfThirdProduct(){
        return driver.findElement(ThirdQuantity).getText();
    }
    public boolean VerifyCartPageDisplayed(){
        return driver.findElement(CartPage).isDisplayed();
    }
    public CheckOutPage clickProceedToCheckOut(){
        driver.findElement(ProceedToCheckOut).click();
        return new CheckOutPage(driver);
    }
    public SignUpANDLoginPage clickRegisterORLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterORLoginLink));
        element.click();
        return new SignUpANDLoginPage(driver);
    }
    public void DeleteParticularItemFromCart() {
        driver.findElement(DeleteFromCart).click();
    }
    public boolean CheckProductDeletion(){
        // Wait for product removal (adjust wait time as needed)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("product-4")));
        // Verify product is not present in the cart
        try {
            driver.findElement(FourthProduct);
            System.out.println("product not deleted");
            return false;
        } catch (Exception e) {
            // Product is not found, which means it's deleted
            System.out.println("Product successfully deleted");
            return true;
        }
    }
    public  boolean verifyProductInCart(){
        return driver.findElement(cartProduct2).isDisplayed();
    }



}
