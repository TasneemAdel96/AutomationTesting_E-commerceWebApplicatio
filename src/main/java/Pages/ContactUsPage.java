package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private WebDriver driver;
    private By getInTouchText = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2");
    private By name = By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input");
    private By email = By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input");
    private By subject = By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input");
    private By message = By.xpath("//*[@id=\"message\"]");
    private By chooseFile = By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input");
    private By submitButton =  By.cssSelector("input.submit_form");
    private By SuccessMessage = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");
    private By homeLink = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    public ContactUsPage (WebDriver driver){
        this.driver = driver;
    }
    public boolean checkGetInTouchTextVisibility(){
        return driver.findElement(getInTouchText).isDisplayed();
    }
    public void setNameInContactUs(String Name){
        driver.findElement(name).sendKeys(Name);
    }
    public void setEmailInContactUs(String Email){
        driver.findElement(email).sendKeys(Email);
    }
    public void setSubjectInContactUs(String Subject){
        driver.findElement(subject).sendKeys(Subject);
    }
    public void setMessageInContactUs(String Message){
        driver.findElement(message).sendKeys(Message);
    }
    public void ChooseFileToUpload(String File){
        driver.findElement(chooseFile).sendKeys(File);
    }
    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }
    public void clickOKFromAlert(){
        driver.switchTo().alert().accept();
    }
    public boolean checkSuccessMessage(){
        return driver.findElement(SuccessMessage).isDisplayed();
    }
    public HomePage clickHomePage(){
        driver.findElement(homeLink).click();
        return new HomePage(driver);
    }

}
