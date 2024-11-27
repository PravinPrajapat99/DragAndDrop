package service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class DragAndDropService {
    public void getPage(WebDriver driver) {
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.switchTo().frame( wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-2669\"]/div[2]/div/div/div[1]/p/iframe"))));
    }

    public WebElement getImageForDrag(WebDriver driver) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gallery']/li[1]/img")));

    }

    public void dropImage(WebDriver driver, WebElement webElement) {
        WebElement trashBox= driver.findElement(By.id("trash"));
        Actions move= new Actions(driver);
        move.dragAndDrop(webElement,trashBox).perform();
    }

    public void verifyIfImageDroped(WebDriver driver) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"trash\"]/ul/li/img")));
            System.out.println("element droped");
        }catch (Exception e){
            System.out.println("element not found");
        }
    }
}
