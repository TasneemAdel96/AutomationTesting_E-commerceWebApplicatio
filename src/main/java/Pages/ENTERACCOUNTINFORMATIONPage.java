package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ENTERACCOUNTINFORMATIONPage {
    private WebDriver driver;
    private By  EnterAccountInformation  = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b");
    private By GenderMale = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[1]/div[1]/label");
    private By GenderFemale = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[1]/div[2]/label");
    private By password = By.xpath("//*[@id=\"password\"]");
    private By Day = By.xpath("//*[@id=\"days\"]");
    private By Month = By.xpath("//*[@id=\"months\"]");
    private By Year = By.xpath("//*[@id=\"years\"]");
    private By firstCheckbox = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[6]/label");
    private By secondCheckbox = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[7]/label");
    private By firstName = By.xpath("//*[@id=\"first_name\"]");
    private By lastName = By.xpath("//*[@id=\"last_name\"]");
    private By companyname = By.xpath("//*[@id=\"company\"]");
    private By Address1 = By.xpath("//*[@id=\"address1\"]");
    private By Address2 = By.xpath("//*[@id=\"address2\"]");
    private By CountryName = By.xpath("//*[@id=\"country\"]");
    private By stateName = By.xpath("//*[@id=\"state\"]");
    private By cityName = By.xpath("//*[@id=\"city\"]");
    private By ZipcodeNo = By.xpath("//*[@id=\"zipcode\"]");
    private By MobileNo = By.xpath("//*[@id=\"mobile_number\"]");
    private By createAccountButton = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");

    public ENTERACCOUNTINFORMATIONPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean enterAccountInformationVisibility(){
        return driver.findElement(EnterAccountInformation).isDisplayed();
    }
    public void chooseMale(){
        driver.findElement(GenderMale).click();
    }
    public void chooseFemale(){
        driver.findElement(GenderFemale).click();
    }
    public void SetPassword(String userpassword){
        driver.findElement(password).sendKeys(userpassword);
    }
    public void SetDay(String optionForDay){
        Select dropdownDay = new Select(driver.findElement(Day));
        dropdownDay.selectByVisibleText(optionForDay); // Select the option by visible text
    }
    public void SetMonth(String optionForMonth){
        Select dropdownMonth = new Select(driver.findElement(Month));
        dropdownMonth.selectByVisibleText(optionForMonth); // Select the option by visible text
    }
    public void SetYear(String optionForYear){
        Select dropdownYear = new Select(driver.findElement(Year));
        dropdownYear.selectByVisibleText(optionForYear); // Select the option by visible text
    }
    public void clickOnFirstCheckbox(){
        driver.findElement(firstCheckbox).click();
    }
    public void clickOnSecondCheckbox(){
        driver.findElement(secondCheckbox).click();
    }
    public void setFirstName(String userFirstName){
        driver.findElement(firstName).sendKeys(userFirstName);
    }
    public void setLastName(String userLastName){
        driver.findElement(lastName).sendKeys(userLastName);
    }
    public void setCompanyname(String userCompanyname){
        driver.findElement(companyname).sendKeys(userCompanyname);
    }
    public void setAddress1(String userAddress1){
        driver.findElement(Address1).sendKeys(userAddress1);
    }
    public void setAddress2(String userAddress2){
        driver.findElement(Address2).sendKeys(userAddress2);
    }
    public void selectFromCountryDropdown(String Countryoption) {
        Select dropdownCountry = new Select(driver.findElement(CountryName));
        dropdownCountry.selectByVisibleText(Countryoption); // Select the option by visible text
    }
    public void setState(String userState){
        driver.findElement(stateName).sendKeys(userState);
    }
    public void setCity(String userCity){
        driver.findElement(cityName).sendKeys(userCity);
    }
    public void setZipcodeNo(String userZipcodeNo){
        driver.findElement(ZipcodeNo).sendKeys(userZipcodeNo);
    }
    public void setMobileNo(String userMobileNo){
        driver.findElement(MobileNo).sendKeys(userMobileNo);
    }
    public AccountCreatedPage clickCreateAccountButton(){
        driver.findElement(createAccountButton).click();
        return new AccountCreatedPage(driver);
    }

}
