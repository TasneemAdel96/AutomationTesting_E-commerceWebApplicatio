package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    private WebDriver driver;
    private By TitleWithFirstNameAndLastName = By.cssSelector("li.address_firstname.address_lastname");
    private By CompanyName = By.xpath("//*[@id=\"address_delivery\"]/li[3]");
    private By CompanyNameBilling = By.xpath("//*[@id=\"address_invoice\"]/li[3]");
    private By Address1 = By.xpath("//*[@id=\"address_delivery\"]/li[4]");
    private By Address1Billing = By.xpath("//*[@id=\"address_invoice\"]/li[4]");
    private By Address2 = By.xpath("//*[@id=\"address_delivery\"]/li[5]");
    private By Address2Billing = By.xpath("//*[@id=\"address_invoice\"]/li[5]");
    private By CityAndStateAndZipCode = By.xpath("//*[@id=\"address_delivery\"]/li[6]");
    private By CityAndStateAndZipCodeBilling = By.xpath("//*[@id=\"address_invoice\"]/li[6]");
    private By CountryName = By.cssSelector("li.address_country_name");
    private By MobileNo = By.cssSelector("li.address_phone");
    private By ReviewFourthProduct = By.xpath("//*[@id=\"product-4\"]/td[1]/a/img");
    private By ReviewFifthProduct = By.xpath("//*[@id=\"product-5\"]/td[1]/a/img");
    private By Comment = By.cssSelector("textarea.form-control");
    private By PlaceOrder = By.cssSelector("a.btn.btn-default.check_out");
//    private By fourthProduct = By.id("product-4");
//    private By fifthProduct = By.id("product-5");
    public CheckOutPage(WebDriver driver){
        this.driver=driver;
    }
    public String VerifyAddressDetailsFirstNameAndLastName(){
        return driver.findElement(TitleWithFirstNameAndLastName).getText();
    }
    public String VerifyAddressDetailsCompanyName(){
        return driver.findElement(CompanyName).getText();
    }
    public String VerifyAddressDetailsCompanyNameInBilling(){
        return driver.findElement(CompanyNameBilling).getText();
    }
    public String VerifyAddressDetailsAddress1(){
        return driver.findElement(Address1).getText();
    }
    public String VerifyAddressDetailsAddress1Billing(){
        return driver.findElement(Address1Billing).getText();
    }
    public String VerifyAddressDetailsAddress2(){
        return driver.findElement(Address2).getText();
    }
    public String VerifyAddressDetailsAddress2Billing(){
        return driver.findElement(Address2Billing).getText();
    }
    public String VerifyAddressDetailsCityAndStateAndZipCode(){
        return driver.findElement(CityAndStateAndZipCode).getText();
    }
    public String VerifyAddressDetailsCityAndStateAndZipCodeBilling(){
        return driver.findElement(CityAndStateAndZipCodeBilling).getText();
    }
    public String VerifyAddressDetailsCountryName(){
        return driver.findElement(CountryName).getText();
    }
    public String VerifyAddressDetailsMobileNo(){
        return driver.findElement(MobileNo).getText();
    }
    public boolean VerifyAppearanceOfFourthProduct(){
        return  driver.findElement(ReviewFourthProduct).isDisplayed();
    }
    public boolean VerifyAppearanceOfFifthProduct(){
        return  driver.findElement(ReviewFifthProduct).isDisplayed();
    }
    public PaymentPage AddComment(String description){
        driver.findElement(Comment).sendKeys(description);
        driver.findElement(PlaceOrder).click();
        return new PaymentPage(driver);
    }


}
