package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    private WebDriver driver;
    private By accountcreatedText = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    private By continueButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    private By logedinText = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
    private By DeleteAccountText = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");

    public AccountCreatedPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean checkText(){
       return driver.findElement(accountcreatedText).isDisplayed();
    }
    public void clickContinue(){
        driver.findElement(continueButton).click();
    }
    public String GetLogedinText(){
        return driver.findElement(logedinText).getText();
    }
    public DeleteAccountPage clickDeleteAccountText(){
        driver.findElement(DeleteAccountText).click();
        return new DeleteAccountPage(driver);
    }
}
