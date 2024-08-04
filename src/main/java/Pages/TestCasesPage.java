package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    private WebDriver driver;
    private By testcases = By.xpath("//*[@id=\"form\"]");
    public TestCasesPage (WebDriver driver){
        this.driver = driver;
    }
    public boolean checkNavigationToTestCasePage(){
        return driver.findElement(testcases).isDisplayed();
    }


}
