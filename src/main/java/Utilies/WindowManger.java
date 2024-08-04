package Utilies;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class WindowManger {
    private WebDriver driver;
    public WindowManger(WebDriver driver){
        this.driver = driver;
    }
    public void goBack(){
        driver.navigate().back();
    }
    public void goForward(){
        driver.navigate().forward();
    }
    public void makeRefresh(){
        driver.navigate().refresh();
    }
    public void goTo(String URL){
        driver.navigate().to(URL);
    }
    public void openTabAndSwitchToTab(){
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        Actions actions = new Actions(driver);
        driver.findElement(By.linkText("Multiple Windows")).click();
        WebElement newtab = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        actions.keyDown(Keys.CONTROL).click(newtab).keyUp(Keys.CONTROL).perform();
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println(allWindows);
        for (String window : allWindows){
            if(!window.equalsIgnoreCase(parent)){
                driver.switchTo().window(window);
                System.out.println(window);
            }
        }





    }
//    public  void SwitchToTab(){
//        driver.getWindowHandles()
//        driver.switchTo().window("New Window");
//    }
}
