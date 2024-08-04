package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpANDLoginPage {
    private WebDriver driver;
    private By signupform = By.className("signup-form");
    private By name = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    private By emailAddress = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    private By signupButton = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
    private By loginform = By.className("login-form");
    private By EmailAddressForlogin = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[2]");
    private By Password = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[3]");
    private By loginButton = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/button");
    private By ErrorMessage = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
    private By ErrorMessageForRegister = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");
    public SignUpANDLoginPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean signupformVisibility(){
        return driver.findElement(signupform).isDisplayed();
    }
    public void setName(String username){
        driver.findElement(name).sendKeys(username);
    }
    public void setEmailAddress(String email){
        driver.findElement(emailAddress).sendKeys(email);
    }
    public ENTERACCOUNTINFORMATIONPage clickSignUpButton(){
        driver.findElement(signupButton).click();
        return new ENTERACCOUNTINFORMATIONPage(driver);
    }
    public boolean loginFormVisibility(){
        return driver.findElement(loginform).isDisplayed();
    }
    public void setEmailAddressforLogin(String emailAddress){
        driver.findElement(EmailAddressForlogin).sendKeys(emailAddress);
    }
    public void setPasswordforLogin(String password){
        driver.findElement(Password).sendKeys(password);
    }
    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
    public boolean EnsureErrorMessageForIncorrectLogin(){
      return driver.findElement(ErrorMessage).isDisplayed();
    }
    public boolean EnsureErrorMessageForIncorrectRegister(){
        return driver.findElement(ErrorMessageForRegister).isDisplayed();
    }






}
