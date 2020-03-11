package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class utilSelenium {

    private ChromeDriver driver;

    utilSelenium(ChromeDriver drv){
        this.driver= drv;
    }

    public WebElement searchElement(By id){
        return driver.findElement(id);
    }

    public boolean elementExists(By locator)
    {
        return !driver.findElements(locator).isEmpty();
    }

    public void doCLick(WebElement el){
        el.click();
    }

    public boolean isDisplayedElement(WebElement el){
        return el.isDisplayed();
    }
}
