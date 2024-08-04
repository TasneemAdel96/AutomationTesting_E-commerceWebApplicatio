package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class PaymentPage {
    private static WebDriver driver;
    private By NameOnCard = By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input");
    private By CardNum = By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input");
    private By CVC = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input");
    private By ExpirationMonth = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input");
    private By ExpirationYear = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input");
    private By PayAndConfirm = By.cssSelector("button#submit.form-control.btn.btn-primary.submit-button");
    private By ConfirmMessage = By.xpath("//*[@id=\"success_message\"]/div");
    private By downloadInvoice = By.xpath("//*[@id=\"form\"]/div/div/div/a");
    private By Continue = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    public PaymentPage(WebDriver driver){
        this.driver = driver;
    }
    public void SetNameOnCard(String name){
        driver.findElement(NameOnCard).sendKeys(name);
    }
    public void SetCardNum(String cardNumber){
        driver.findElement(CardNum).sendKeys(cardNumber);
    }
    public void SetCVC(String CVCNum){
        driver.findElement(CVC).sendKeys(CVCNum);
    }
    public void SetExpirationMonth(String Month){
        driver.findElement(ExpirationMonth).sendKeys(Month);
    }
    public void SetExpirationYear(String Year){
        driver.findElement(ExpirationYear).sendKeys(Year);
    }
    public void clickPayandConfirmOrder(){
        driver.findElement(PayAndConfirm).click();
    }
    public String VerifyConfirmMessageAfterPay(){
        return driver.findElement(ConfirmMessage).getText();

    }
    public void clickDownloadInvoice(){
        driver.findElement(downloadInvoice).click();
    }
    public boolean checkFileDownloaded(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        File downloadedFile = new File("C:\\Users\\Twins\\Downloads"+"\\invoice.txt");
        if (downloadedFile.exists()) {
            System.out.println("File downloaded successfully!" + downloadedFile.exists());
        } else {
            System.out.println("File download failed!");
        }
       return downloadedFile.exists();
    }
    public void clickContinue(){
        driver.findElement(Continue).click();
    }
// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmMessage));


}

