package CustomUtility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class WriteToExcel {

    public static void writeData(Map<String, String> itemsList) {
        XSSFWorkbook wb= new XSSFWorkbook();
        XSSFSheet sheet=wb.createSheet("itemsList");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Items name");
        headerRow.createCell(1).setCellValue("price");
        int rowIdx= sheet.getLastRowNum()+1;

        for(Map.Entry<String,String> entry:itemsList.entrySet()){
            Row row =sheet.createRow(rowIdx++);
            Cell cell=row.createCell(0);
            cell.setCellValue(entry.getKey());
            Cell cell1=row.createCell(1);
            cell1.setCellValue(entry.getValue().replaceFirst("(\\d+)(\\d{2})$", "$1^$2"));

        }
        try {
            FileOutputStream fileOutputStream= new FileOutputStream("PriceList.xlsx");
            wb.write(fileOutputStream);
            wb.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
