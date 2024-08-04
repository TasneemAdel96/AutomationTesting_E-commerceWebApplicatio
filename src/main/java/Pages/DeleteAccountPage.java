package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPage {
    private WebDriver driver;
    private By AccountDeletedText = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    private By continueDelete = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    public DeleteAccountPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean checkAccountDeletedText(){
        return driver.findElement(AccountDeletedText).isDisplayed();
    }
    public void clickcontinueDelete(){
        driver.findElement(continueDelete).click();
    }
}