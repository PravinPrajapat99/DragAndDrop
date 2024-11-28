package service;

import CustomUtility.WaitFor;
import CustomUtility.WriteToExcel;
import org.openqa.selenium.*;

import java.util.*;

public class ShopingService {
    public void goToShopMenu(WebDriver driver) {
        List<WebElement> links = WaitFor.visibilityList(By.cssSelector("a.accent-primary-border"));
        WebElement fourthLink = links.get(3);
        fourthLink.click();
        String originalTab = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void clickOnMens(WebDriver driver) {
        WebElement closeButton =  WaitFor.visibility(By.xpath("/html/body/div[3]/div[2]/div/button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", closeButton);
        WaitFor.visibility(By.id("0")).click();
    }

    public void printData(WebDriver driver, Integer int1) {
        List<WebElement> list =WaitFor.visibilityList(By.xpath("//div[@class=\"grid grid-small-2-medium-3 row small-up-2 medium-up-3\"]/div"));
        Map<String,String> itemsList= new LinkedHashMap<>();
        for (int i = 0; i < list.size() && i < int1; i++) {
            WebElement element = list.get(i);
            WebElement anchor = element.findElement(By.xpath(".//div/div[2]/div[2]/a"));
            itemsList.put(anchor.getText(),element.findElement(By.xpath(".//div/div[2]/div[1]/div/div/div[1]/span/span/span[1]/span[2]")).getText());
        }
        WriteToExcel.writeData(itemsList);
    }
}
