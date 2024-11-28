package service;

import CustomUtility.LinkStatusChecker;
import CustomUtility.WaitFor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinkService {
    public void openPage(WebDriver driver) {
        driver.get("https://www.nba.com/warriors/");
        driver.manage().window().maximize();
        try {
            WaitFor.visibility(By.xpath("//div[@role='dialog']/div/div[text()=\"x\"]")).click();
        }catch (Exception ignored){}

    }

    public WebElement getFooter(WebDriver driver) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//Footer")));
         return   WaitFor.visibility(By.xpath("//footer"));

    }

    public List<String> getLinks(WebDriver driver, WebElement theFooterElement) {
        List<WebElement> list=theFooterElement.findElements(By.xpath(".//a"));
        List<String> hrefLinks = new ArrayList<>();
        for (WebElement anchor:list){
            String href =anchor.getAttribute("href");
            if(href!=null){
                hrefLinks.add(href);
                System.out.println(href);
            }
        }
        return hrefLinks;
    }

    public void moveLinksToExcel(WebDriver driver, List<String> allLinksFromFooter) {

        XSSFWorkbook wb= new XSSFWorkbook();
        XSSFSheet sheet=wb.createSheet("All Links");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Link URL");
        headerRow.createCell(1).setCellValue("status");
        int rowIdx= sheet.getLastRowNum()+1;

        for(String link:allLinksFromFooter){
            Row row =sheet.createRow(rowIdx++);
            Cell cell=row.createCell(0);
            cell.setCellValue(link);
            String status="";
            int statusoflink= LinkStatusChecker.getStatusCode(link);
            if(statusoflink>=400){
                status="broken";
                System.out.println(link);
            }else {
                status="working";
            }
            Cell cell1=row.createCell(1);
            cell1.setCellValue(status +"--"+statusoflink);

        }

        try {
            FileOutputStream fileOutputStream= new FileOutputStream("Link_Status.xlsx");
            wb.write(fileOutputStream);
            wb.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void checkForBrokenLink(WebDriver driver, List<String> allLinksFromFooter) {

    }
}
