package base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void SetUP(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
        homePage = new HomePage(driver);

    }
    @BeforeMethod
    public void GoHome(){
        driver.get("https://www.automationexercise.com/");
    }
//    @AfterClass
//    public void TearDown() {
//        driver.quit();
//    }
     public void goBack(){
        driver.navigate().back();
     }
    public void goForward(){
        driver.navigate().forward();
    }
}
