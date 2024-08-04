package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By HomePage = By.className("carousel-indicators");
    private By SignupANDLogin = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By logedinText = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
    private By DeleteAccountText = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private By logout = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By contactUs = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    private By Testcases = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private By Products = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    private By HomeFooter = By.xpath("//*[@id=\"footer\"]/div[1]");
    private By TextSubscribtion = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
    private By EmailInput = By.cssSelector("input#susbscribe_email");
    private By ArrowButton = By.cssSelector("button#subscribe.btn.btn-default");
    private By AlertSuccessText = By.className("alert-success");
    private By Cart = By.linkText("Cart");
    private By ViewThirdProduct = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[4]/div/div[2]/ul/li/a");
    private By FourthProduct = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[5]/div/div[1]/div[1]/a");
    private By FifthProduct = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[6]/div/div[1]/div[1]/a");
    private By ContinueShopping = By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
    private By liftSideBar = By.xpath("/html/body/section[2]/div[1]/div/div[1]/div");
    private By categories = By.cssSelector("div#accordian.panel-group.category-products");
    private By WomenCategory = By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a");
    private By WomenDress = By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a");
    private By MenCategory = By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a");
    private By MenTShirts = By.xpath("//*[@id=\"Men\"]/div/ul/li[1]/a");
    private By brands = By.className("brands_products");
    private By polo = By.xpath("/html/body/section[2]/div[1]/div/div[1]/div[1]/div[3]/div/ul/li[1]/a");
    private By Biba = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[8]");
    private By recommendeItems = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[2]/h2");
    private By addRecommendedProduct = By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/a");
    private By viewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    private By arrowScrollUp = By.xpath("//*[@id=\"scrollUp\"]");
    private By introText = By.xpath("//*[@id=\"slider-carousel\"]/div/div[2]/div[1]/h2");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public boolean HomeVisibility(){
        return driver.findElement(HomePage).isDisplayed();
    }
    public SignUpANDLoginPage clickSignUpANDLoginPage(){
        driver.findElement(SignupANDLogin).click();
        return new SignUpANDLoginPage(driver);
    }
    public String GetLogedinTextAfterlogin(){

        return driver.findElement(logedinText).getText();
    }
    public DeleteAccountPage clickDeleteAccountText(){
        driver.findElement(DeleteAccountText).click();
        return new DeleteAccountPage(driver);
    }
    public SignUpANDLoginPage clickLogout(){
        driver.findElement(logout).click();
        return new SignUpANDLoginPage(driver);
    }
   public ContactUsPage clickContactUs(){
        driver.findElement(contactUs).click();
        return new ContactUsPage(driver);
   }
   public TestCasesPage clickTestCases(){
        driver.findElement(Testcases).click();
        return new TestCasesPage(driver);
   }
   public ProductsPage clickProducts(){
        driver.findElement(Products).click();
        return new ProductsPage(driver);
   }
   public boolean ScrollDownToFooter(){
        WebElement element = driver.findElement(HomeFooter);
       Actions actions = new Actions(driver);
       actions.moveToElement(element).perform();
       return driver.findElement(TextSubscribtion).isDisplayed();

   }
   public void SetEmailForSubscription(String email){
        driver.findElement(EmailInput).sendKeys(email);
   }
   public String clickArrowButton(){
        driver.findElement(ArrowButton).click();
        return driver.findElement(AlertSuccessText).getText();
   }
   public CartPage clickCart(){
        driver.findElement(Cart).click();
        return new CartPage(driver);
   }
   public ProductDetailsPage clickViewProductForThirdProduct(){
        driver.findElement(ViewThirdProduct).click();
        return new ProductDetailsPage(driver);
   }
   public void AddFourthProductToCart(){
        driver.findElement(FourthProduct).click();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueShopping));
       element.click();
   }
    public void AddFifthProductToCart(){
        driver.findElement(FifthProduct).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueShopping));
        element.click();
    }
    public boolean verifyCategoriesVisible(){
        // Locate the left sidebar element
        WebElement leftSidebar = driver.findElement(liftSideBar);

        // Find all category elements within the sidebar
        List<WebElement> category= leftSidebar.findElements(categories);
        // converts the list to a stream for efficient processing
        // checks if all elements in the stream satisfy the given condition
        return !category.isEmpty() && category.stream().allMatch(WebElement::isDisplayed);
    }
    public void clickWomenCategory(){
        driver.findElement(WomenCategory).click();
    }
    public ProductsPage clickWomenDress(){
        driver.findElement(WomenDress).click();
        return new ProductsPage(driver);
    }
    public void clickMenCategory(){
        driver.findElement(MenCategory).click();
    }
    public ProductsPage clickMenTShirts(){
        driver.findElement(MenTShirts).click();
        return new ProductsPage(driver);
    }
    public boolean verifyBrandsVisible(){
        // Locate the left sidebar element
        WebElement leftSidebar = driver.findElement(liftSideBar);

        // Find all brand elements within the sidebar
        List<WebElement> brand= leftSidebar.findElements(brands);
        // converts the list to a stream for efficient processing
        // checks if all elements in the stream satisfy the given condition
        System.out.println(!brand.isEmpty() && brand.stream().allMatch(WebElement::isDisplayed));
        return !brand.isEmpty() && brand.stream().allMatch(WebElement::isDisplayed);
    }
    public ProductsPage clickPoloBrand(){
        driver.findElement(polo).click();
        return new ProductsPage(driver);
    }
    public ProductsPage clickBibaBrand(){
        driver.findElement(Biba).click();
        return new ProductsPage(driver);
    }
    public boolean scrollToDownAndCheckVisibiltOfRecommendedItemsText(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(recommendeItems)).perform();
        return driver.findElement(recommendeItems).isDisplayed();
    }
    public void addRecommendedProductToACart(){
        WebElement element = driver.findElement(addRecommendedProduct);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/a")));
        driver.findElement(addRecommendedProduct).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")));
        driver.findElement(viewCart).click();
    }

    public void ScrollUpByArrow(){
        driver.findElement(arrowScrollUp).click();
    }
    public boolean checkVisibilityOfIntroText(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"slider-carousel\"]/div/div[2]/div[1]/h2")));
        return driver.findElement(introText).isDisplayed();
    }
    public boolean ScrollUp(){
        WebElement element = driver.findElement(introText);
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"slider-carousel\"]/div/div[2]/div[1]/h2")));
        action.moveToElement(element).perform();
        return element.isDisplayed();
    }







}
